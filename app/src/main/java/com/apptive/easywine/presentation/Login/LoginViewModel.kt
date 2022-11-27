package com.apptive.easywine.presentation.Login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apptive.easywine.domain.model.EmailPassword
import com.apptive.easywine.domain.use_case.member.doLogin
import com.apptive.easywine.domain.util.Resource
import com.apptive.easywine.domain.util.log
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
	private val doLoginUseCase: doLogin
): ViewModel() {
	private var _emailPw = mutableStateOf(
		EmailPassword(
			// TODO: delete later
			email = "test1",
			pass = "1234",
		)
	)
	val emailPw: State<EmailPassword> = _emailPw

	private val _eventFlow = MutableSharedFlow<UiEvent>()
	val eventFlow = _eventFlow.asSharedFlow()

	private suspend fun login() {
		doLoginUseCase(_emailPw.value).collectLatest {
			when (it) {
				is Resource.Success -> {
					_eventFlow.emit(UiEvent.Login)
				}
				is Resource.Error -> {
					"로그인 중 에러 발생".log()
					_eventFlow.emit(UiEvent.Error("cannot login"))
				}
				is Resource.Loading -> {
					"토큰 값 가져오는 중...".log()
				}
			}
		}
	}

	fun onEvent(event: LoginEvent) {
		when (event) {
			is LoginEvent.EnteredEmail -> {
				_emailPw.value = emailPw.value.copy(
					email = event.value
				)
			}
			is LoginEvent.EnteredPassword -> {
				_emailPw.value = emailPw.value.copy(
					pass = event.value
				)
			}
			is LoginEvent.Login -> {
				viewModelScope.launch {
					try {
						if (emailPw.value.email.isNullOrBlank()
							|| emailPw.value.pass.isNullOrBlank()
						) {
							"ERROR 입력 되지 않은 칸이 존재".log()
							_eventFlow.emit(UiEvent.Error(message = "모든 칸의 내용을 채워주세요"))
							return@launch
						}
						 login()
					} catch (e: Exception) {
						"로그인 중 에러 발생".log()
						_eventFlow.emit(UiEvent.Error(message = "로그인 중 에러 발생"))
					}
				}
			}
		}

	}

	sealed class UiEvent {
		data class Error(val message: String) : UiEvent()
		object Login : UiEvent()
	}
}
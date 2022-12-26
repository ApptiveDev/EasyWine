package com.apptive.easywine.presentation.Login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apptive.easywine.domain.model.EmailPassword
import com.apptive.easywine.domain.model.UserInfo
import com.apptive.easywine.domain.use_case.member.createAccount
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
	private val doLoginUseCase: doLogin,
	private val createAccountUseCase: createAccount,
): ViewModel() {

	var userInfo: UserInfo by mutableStateOf(
		UserInfo(
			email = "test1",
			pass = "1234",
		)
	)
		private set

	private val _eventFlow = MutableSharedFlow<UiEvent>()
	val eventFlow = _eventFlow.asSharedFlow()

	private suspend fun login() {
		doLoginUseCase(EmailPassword(userInfo.email, userInfo.pass)).collectLatest {
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

	private suspend fun createAccount() {
		createAccountUseCase(userInfo).collectLatest {
			when (it) {
				is Resource.Success -> {
					_eventFlow.emit(UiEvent.CreateAccount)
				}
				is Resource.Error -> {
					"회원가입 중 에러 발생".log()
					_eventFlow.emit(UiEvent.Error("cannot login"))
				}
				is Resource.Loading -> {
					"회원가입 중...".log()
				}
			}
		}
	}

	fun onEvent(event: LoginEvent) {
		when (event) {
			is LoginEvent.EnteredEmail -> {
				userInfo = userInfo.copy(
					email = event.value
				)
			}
			is LoginEvent.EnteredPassword -> {
				userInfo = userInfo.copy(
					pass = event.value
				)
			}

			is LoginEvent.EnteredAge -> {
				userInfo = userInfo.copy(
					age = event.value
				)
			}
			is LoginEvent.EnteredGender -> {
				userInfo = userInfo.copy(
					gender = 0 // TODO - fix
				)
			}
			is LoginEvent.EnteredName -> {
				userInfo = userInfo.copy(
					name = event.value
				)
			}
			is LoginEvent.Login -> {
				viewModelScope.launch {
					try {
						if (userInfo.email.isBlank()
							|| userInfo.pass.isBlank()
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
			is LoginEvent.CreateAccount -> {
				viewModelScope.launch {
					try {
						if (userInfo.email.isBlank()
							|| userInfo.pass.isBlank()
							|| userInfo.age.toString().isBlank()
							|| userInfo.gender.toString().isBlank()
							|| userInfo.name.isBlank()
						) {
							"ERROR 입력 되지 않은 칸이 존재".log()
							_eventFlow.emit(UiEvent.Error(message = "모든 칸의 내용을 채워주세요"))
							return@launch
						}
						createAccount()
					} catch (e: Exception) {
						"계정생성 중 에러 발생".log()
						_eventFlow.emit(UiEvent.Error(message = "계정생성 중 에러 발생"))
					}
				}
			}
		}

	}

	sealed class UiEvent {
		data class Error(val message: String) : UiEvent()
		object Login : UiEvent()
		object SignUp : UiEvent()
		object CreateAccount : UiEvent()
	}
}
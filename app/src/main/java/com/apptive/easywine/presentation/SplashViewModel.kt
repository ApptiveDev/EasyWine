package com.apptive.easywine.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apptive.easywine.domain.use_case.member.checkLogined
import com.apptive.easywine.domain.util.Resource
import com.apptive.easywine.domain.util.log
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
	private var checkLoginedUseCase: checkLogined,
) : ViewModel() {

	var isLogined by mutableStateOf(false)

	init {
		viewModelScope.launch {
			checkLogined()
		}
	}

	suspend fun checkLogined() {
		checkLoginedUseCase().collect() {
			when (it) {
				is Resource.Success -> {
					isLogined = true
				}
				is Resource.Error -> {
					isLogined = false
					"자동 로그인 실패...".log()
				}
				is Resource.Loading -> {
					isLogined = false
					"토큰 가져오는 중...".log()
				}
			}
		}
	}
}

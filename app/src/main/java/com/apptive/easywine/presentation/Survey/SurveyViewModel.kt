package com.apptive.easywine.presentation.Survey

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apptive.easywine.domain.model.Question
import com.apptive.easywine.domain.use_case.survey.GetQuestions
import com.apptive.easywine.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SurveyViewModel @Inject constructor(
	private val getQuestionUseCase: GetQuestions,
) : ViewModel() {

	var questions1 by mutableStateOf(emptyList<Question>())
		private set
	var questions2 by mutableStateOf(emptyList<Question>())
		private set
	var questions3 by mutableStateOf(emptyList<Question>())
		private set

	init {
		getQuestion1()
		getQuestion2()
		getQuestion3()
	}

	fun getQuestion1() {
		viewModelScope.launch {
			getQuestionUseCase.getQuestion1().conflate().collect() { result ->
				when (result) {
					is Resource.Success -> {
						questions1 = result.data!!
					}
					is Resource.Error -> {
						Log.d("SurveyViewModel", "error")
					}
					is Resource.Loading -> {
						Log.d("SurveyViewModel", "loading")
					}
				}
			}
		}
	}

	fun getQuestion2() {
		viewModelScope.launch {
			getQuestionUseCase.getQuestion2().conflate().collect() { result ->
				when (result) {
					is Resource.Success -> {
						questions2 = result.data!!
					}
					is Resource.Error -> {
						Log.d("SurveyViewModel", "error")
					}
					is Resource.Loading -> {
						Log.d("SurveyViewModel", "loading")
					}
				}
			}
		}
	}

	fun getQuestion3() {
		viewModelScope.launch {
			getQuestionUseCase.getQuestion3().conflate().collect() { result ->
				when (result) {
					is Resource.Success -> {
						questions3 = result.data!!
					}
					is Resource.Error -> {
						Log.d("SurveyViewModel", "error")
					}
					is Resource.Loading -> {
						Log.d("SurveyViewModel", "loading")
					}
				}
			}
		}
	}
}
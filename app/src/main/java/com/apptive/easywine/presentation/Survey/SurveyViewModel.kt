package com.apptive.easywine.presentation.Survey

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apptive.easywine.domain.model.Question
import com.apptive.easywine.domain.model.RecommendBody
import com.apptive.easywine.domain.model.StorageWine
import com.apptive.easywine.domain.model.WineLiked
import com.apptive.easywine.domain.use_case.survey.GetQuestions
import com.apptive.easywine.domain.use_case.survey.GetRecommend
import com.apptive.easywine.domain.use_case.wine_storage.setLikedWine
import com.apptive.easywine.domain.util.Resource
import com.apptive.easywine.enums.SurveyLevel
import com.apptive.easywine.presentation.Login.LoginViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SurveyViewModel @Inject constructor(
	private val getQuestionUseCase: GetQuestions,
	private val getRecommend: GetRecommend,
	private val setWineLikedUseCase: setLikedWine
) : ViewModel() {

	var questions1 by mutableStateOf(emptyList<Question>())
		private set
	var questions2 by mutableStateOf(emptyList<Question>())
		private set
	var questions3 by mutableStateOf(emptyList<Question>())
		private set
	var level by mutableStateOf(SurveyLevel.FLAVOR)

	var inputData by mutableStateOf(mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0))

	var recommendedWine by mutableStateOf(StorageWine())

	private val _eventFlow = MutableSharedFlow<UiEvent>()
	val eventFlow = _eventFlow.asSharedFlow()

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

	fun submitSurvey() {
		viewModelScope.launch {
			getRecommend(
				RecommendBody(
					inputData[0],
					inputData[1],
					inputData[2],
					inputData[3],
					inputData[4],
					inputData[5],
					inputData[6],
					inputData[7],
					inputData[8],
					inputData[9]
				)
			).collect() { result ->
				when (result) {
					is Resource.Success -> {
						_eventFlow.emit(UiEvent.Submit)
						recommendedWine = result.data!!
						Log.d("SurveyViewModel", "SUCCESS!!! ${result.data!!}")
					}
					is Resource.Error -> {
						_eventFlow.emit(UiEvent.Error("Error"))
						Log.d("SurveyViewModel", "error")
					}
					is Resource.Loading -> {
						Log.d("SurveyViewModel", "loading")
					}
				}
			}
		}
	}

	fun setWineLiked(liked : Boolean) {
		viewModelScope.launch {
			setWineLikedUseCase(wineLiked = WineLiked(recommendedWine.id, liked)).collect() { result ->
				when (result) {
					is Resource.Success -> {
						recommendedWine._like = liked
						Log.d("SurveyViewModel", "SUCCESS!!! ${result.data!!}")
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

sealed class UiEvent {
	data class Error(val message: String) : UiEvent()
	object Submit : UiEvent()
}
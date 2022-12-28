package com.apptive.easywine.presentation.WineStorage

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apptive.easywine.domain.model.StorageWine
import com.apptive.easywine.domain.use_case.wine_storage.getLikedWineList
import com.apptive.easywine.domain.use_case.wine_storage.getWineList
import com.apptive.easywine.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WineStorageViewModel @Inject constructor(
	private val getWineListUseCase: getWineList,
	private val getLikedWineListUseCase: getLikedWineList,
) : ViewModel() {

	var wineList by mutableStateOf(listOf<StorageWine>())
	var wineLikedList by mutableStateOf(listOf<StorageWine>())

	init {
		getWineList()
		getLikedWineList()
	}

	fun getWineList() {
		viewModelScope.launch {
			getWineListUseCase().conflate().collect() { result ->
				when (result) {
					is Resource.Success -> {
						wineList = result.data!!
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

	fun getLikedWineList() {
		viewModelScope.launch {
			getLikedWineListUseCase().conflate().collect() { result ->
				when (result) {
					is Resource.Success -> {
						wineLikedList = result.data!!
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

package com.apptive.easywine.data.repository

import com.apptive.easywine.data.remote.WineStorageApi
import com.apptive.easywine.domain.model.StorageWine
import com.apptive.easywine.domain.model.Wine
import com.apptive.easywine.domain.model.WineLiked
import com.apptive.easywine.domain.repository.WineStorageRepository
import retrofit2.Response
import javax.inject.Inject

class WineStorageRepositoryImpl @Inject constructor(
	private val api: WineStorageApi
): WineStorageRepository {
	override suspend fun getWine(id: Int): Response<Wine> {
		return api.getWine(id)
	}

	override suspend fun getWineList(): Response<List<StorageWine>> {
		return api.getWineList()
	}

	override suspend fun setLikedWine(wineLiked: WineLiked): Response<WineLiked> {
		return api.setLikedWine(wineLiked)
	}

}
package com.apptive.easywine.domain.repository

import com.apptive.easywine.domain.model.*
import retrofit2.Response

interface WineStorageRepository {
	suspend fun getWine(id : Int): Response<Wine>
	suspend fun getWineList(): Response<List<StorageWine>>
	suspend fun getLikedWineList(): Response<List<StorageWine>>
	suspend fun setLikedWine(wineLiked: WineLiked): Response<WineLiked>
}
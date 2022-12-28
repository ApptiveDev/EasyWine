package com.apptive.easywine.data.remote

import com.apptive.easywine.domain.model.StorageWine
import com.apptive.easywine.domain.model.Wine
import com.apptive.easywine.domain.model.WineLiked
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface WineStorageApi {

	@GET("/wine/id/v1/{id}")
	suspend fun getWine(
		@Path("id") id: Int
	) : Response<Wine>

	@GET("/getContainers/v1")
	suspend fun getWineList() : Response<List<StorageWine>>

	@POST("/container/modifyContainer/v1")
	suspend fun setLikedWine(
		@Body wineLiked: WineLiked
	) : Response<WineLiked>
}
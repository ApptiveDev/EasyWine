package com.apptive.easywine.data.remote

import com.apptive.easywine.domain.model.Question
import com.apptive.easywine.domain.model.RecommendBody
import com.apptive.easywine.domain.model.StorageWine
import com.apptive.easywine.domain.model.Wine
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface SurveyApi {

	// api for requesting questions type 1
	@GET("/question/category/v1/1")
	suspend fun getQuestion1(
	): Response<List<Question>>

	// api for requesting questions type 2
	@GET("/question/category/v1/2")
	suspend fun getQuestion2(
	): Response<List<Question>>

	// api for requesting questions type 3
	@GET("/question/category/v1/3")
	suspend fun getQuestion3(
	): Response<List<Question>>

	@POST("/question/answer/v2")
	suspend fun getRecommend(
		@Body recommendBody: RecommendBody
	): Response<StorageWine>
}
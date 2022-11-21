package com.apptive.easywine.data.remote

import com.apptive.easywine.domain.model.Question
import retrofit2.Response
import retrofit2.http.GET

interface SurveyApi {

	// api for requesting questions type 1
	@GET("/question/category/1")
	suspend fun getQuestion1(
	): Response<Question>

	// api for requesting questions type 2
	@GET("/question/category/2")
	suspend fun getQuestion2(
	): Response<Question>

	// api for requesting questions type 3
	@GET("/question/category/3")
	suspend fun getQuestion3(
	): Response<Question>
}
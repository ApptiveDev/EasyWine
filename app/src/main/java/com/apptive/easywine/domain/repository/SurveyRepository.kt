package com.apptive.easywine.domain.repository

import com.apptive.easywine.domain.model.Question
import retrofit2.Response

interface SurveyRepository {
	suspend fun getQuestion1(): Response<List<Question>>
	suspend fun getQuestion2(): Response<List<Question>>
	suspend fun getQuestion3(): Response<List<Question>>
}
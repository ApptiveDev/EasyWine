package com.apptive.easywine.domain.repository

import com.apptive.easywine.data.remote.response.QuestionDTO
import retrofit2.Response
import java.io.File

interface SurveyRepository {

	suspend fun getQuestion1(): Response<QuestionDTO>
	suspend fun getQuestion2(): Response<QuestionDTO>
	suspend fun getQuestion3(): Response<QuestionDTO>
}
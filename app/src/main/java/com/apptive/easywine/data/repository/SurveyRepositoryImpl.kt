package com.apptive.easywine.data.repository

import com.apptive.easywine.data.remote.SurveyApi
import com.apptive.easywine.data.remote.response.QuestionDTO
import com.apptive.easywine.domain.repository.SurveyRepository
import retrofit2.Response
import javax.inject.Inject

class SurveyRepositoryImpl @Inject constructor(
	private val api: SurveyApi
): SurveyRepository {
	override suspend fun getQuestion1(): Response<QuestionDTO> {
		return api.getQuestion1()
	}

	override suspend fun getQuestion2(): Response<QuestionDTO> {
		return api.getQuestion2()
	}

	override suspend fun getQuestion3(): Response<QuestionDTO> {
		return api.getQuestion3()
	}

}
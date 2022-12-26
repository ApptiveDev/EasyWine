package com.apptive.easywine.data.repository

import com.apptive.easywine.data.remote.MemberApi
import com.apptive.easywine.data.remote.SurveyApi
import com.apptive.easywine.domain.model.EmailPassword
import com.apptive.easywine.domain.model.LoginInfo
import com.apptive.easywine.domain.model.Question
import com.apptive.easywine.domain.model.UserInfo
import com.apptive.easywine.domain.repository.MemberRepository
import com.apptive.easywine.domain.repository.SurveyRepository
import retrofit2.Response
import javax.inject.Inject

class MemberRepositoryImpl @Inject constructor(
	private val api: MemberApi
): MemberRepository {
	override suspend fun doLogin(emailPassword: EmailPassword): Response<LoginInfo> {
		return api.doLogin(emailPassword)
	}

	override suspend fun createAccount(userInfo: UserInfo): Response<UserInfo> {
		return api.createAccount(userInfo)
	}
}
package com.apptive.easywine.data.repository

import com.apptive.easywine.data.remote.MemberApi
import com.apptive.easywine.data.remote.SurveyApi
import com.apptive.easywine.data.storage.UserStore
import com.apptive.easywine.domain.model.EmailPassword
import com.apptive.easywine.domain.model.LoginInfo
import com.apptive.easywine.domain.model.Question
import com.apptive.easywine.domain.model.UserInfo
import com.apptive.easywine.domain.repository.MemberRepository
import com.apptive.easywine.domain.repository.SurveyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import retrofit2.Response
import javax.inject.Inject

class MemberRepositoryImpl @Inject constructor(
	private val store: UserStore,
	private val api: MemberApi
): MemberRepository {
	override suspend fun doLogin(emailPassword: EmailPassword): Response<LoginInfo> {
		return api.doLogin(emailPassword)
	}

	override suspend fun createAccount(userInfo: UserInfo): Response<UserInfo> {
		return api.createAccount(userInfo)
	}

	override suspend fun getUserToken(): String {
		return runBlocking(Dispatchers.IO) {
			store.getToken().first()
		}
	}
	override suspend fun setUserToken(token: String) {
		runBlocking(Dispatchers.IO) {
			store.setToken(token)
		}
	}
}
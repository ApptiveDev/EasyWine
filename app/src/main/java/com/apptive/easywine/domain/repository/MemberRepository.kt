package com.apptive.easywine.domain.repository

import com.apptive.easywine.domain.model.EmailPassword
import com.apptive.easywine.domain.model.LoginInfo
import com.apptive.easywine.domain.model.Question
import com.apptive.easywine.domain.model.UserInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import retrofit2.Response

interface MemberRepository {
	suspend fun doLogin(emailPassword: EmailPassword): Response<LoginInfo>
	suspend fun createAccount(userInfo: UserInfo): Response<UserInfo>

	suspend fun getUserToken(): String
	suspend fun setUserToken(token: String)
}
package com.apptive.easywine.domain.repository

import com.apptive.easywine.domain.model.EmailPassword
import com.apptive.easywine.domain.model.LoginInfo
import com.apptive.easywine.domain.model.Question
import retrofit2.Response

interface MemberRepository {
	suspend fun doLogin(emailPassword: EmailPassword): Response<LoginInfo>
}
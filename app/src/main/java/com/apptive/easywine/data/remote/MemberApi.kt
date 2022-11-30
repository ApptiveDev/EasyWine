package com.apptive.easywine.data.remote

import com.apptive.easywine.domain.model.EmailPassword
import com.apptive.easywine.domain.model.LoginInfo
import com.apptive.easywine.domain.model.Question
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST

interface MemberApi {

//	@POST("/member/join/v1")
//	suspend fun join(
//	): Response<>

	@POST("member/login/v1")
	suspend fun doLogin(
		@Body emailPassword: EmailPassword
	): Response<LoginInfo>

}
package com.apptive.easywine.domain.use_case.member

import com.apptive.easywine.domain.repository.MemberRepository
import com.apptive.easywine.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class checkLogined @Inject constructor(
    val repository: MemberRepository
){
    operator fun invoke(): Flow<Resource<String>> = flow {
        emit(Resource.Loading())
        val token = repository.getUserToken()

        if(token == "token null") emit(Resource.Error("로그인에 실패했습니다"))
        else emit(Resource.Success(token))
    }
}
package com.apptive.easywine.domain.use_case.member

import android.util.Log
import com.apptive.easywine.domain.model.EmailPassword
import com.apptive.easywine.domain.model.LoginInfo
import com.apptive.easywine.domain.model.UserInfo
import com.apptive.easywine.domain.repository.MemberRepository
import com.apptive.easywine.domain.util.Resource
import com.apptive.easywine.domain.util.log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class createAccount @Inject constructor(
    val repository: MemberRepository
){
    operator fun invoke(userInfo: UserInfo): Flow<Resource<UserInfo>> = flow {
        try {
            emit(Resource.Loading())
            val r = repository.createAccount(userInfo)

            when(r.code()) {
                200 -> emit(Resource.Success(r.body()!!))
                else -> Log.d("use case", r.errorBody().toString())
            }
        } catch(e: HttpException) {
            "An unexpected error occured".log("use case")
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            "Couldn't reach server. Check your internet connection".log("use case")
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}
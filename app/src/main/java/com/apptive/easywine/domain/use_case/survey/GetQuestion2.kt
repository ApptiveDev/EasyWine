package com.apptive.easywine.domain.use_case.survey

import android.util.Log
import com.apptive.easywine.domain.model.Question
import com.apptive.easywine.domain.repository.SurveyRepository
import com.apptive.easywine.domain.util.Resource
import com.apptive.easywine.domain.util.log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class GetQuestion2 @Inject constructor(
    val repository: SurveyRepository
){
    operator fun invoke(): Flow<Resource<List<Question>>> = flow {
        try {
            emit(Resource.Loading())
            val r = repository.getQuestion2()

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
package com.apptive.easywine.di

import android.content.Context
import android.util.Log
import androidx.datastore.preferences.core.stringPreferencesKey
import com.apptive.easywine._const.NetworkConst.BASE_URL
import com.apptive.easywine.data.remote.MemberApi
import com.apptive.easywine.data.remote.SurveyApi
import com.apptive.easywine.data.remote.WineStorageApi
import com.apptive.easywine.data.repository.MemberRepositoryImpl
import com.apptive.easywine.data.repository.SurveyRepositoryImpl
import com.apptive.easywine.data.storage.dataStore
import com.apptive.easywine.domain.repository.MemberRepository
import com.apptive.easywine.domain.repository.SurveyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

	/* TODO - JWT TOKEN 인증을 위한 AuthInterceptor. 추후 TOKEN 추가 */
	@Provides
	@Singleton
	fun provideAuthInterceptor(
		@ApplicationContext appContext: Context,
	): Interceptor = Interceptor { chain ->
		val newRequest = chain
			.request()
			.newBuilder()
			.addHeader(
				"X-AUTH-TOKEN",
						"${runBlocking{appContext.dataStore.data.map {it[stringPreferencesKey("token")]}.first() }}"
			)
			.build()
		return@Interceptor chain.proceed(newRequest)
	}

	// rest api 통신 logger
	@Singleton
	@Provides
	fun provideLoggingInterceptor(): HttpLoggingInterceptor =
		HttpLoggingInterceptor() {
			Log.d(
				"HTTP",
				it,
			)
		}.setLevel(HttpLoggingInterceptor.Level.BODY)

	// client 제공
	@Provides
	@Singleton
	fun provideOkHttpClient(
		interceptor: Interceptor,
		loggingInterceptor: HttpLoggingInterceptor,
	): OkHttpClient {
		return OkHttpClient
			.Builder()
			.addInterceptor(interceptor)
			.addInterceptor(loggingInterceptor)
			.build()
	}

	// Retrofit 제공
	@Provides
	@Singleton
	fun provideRetrofit(client: OkHttpClient): Retrofit {
		return Retrofit.Builder()
			.baseUrl(BASE_URL)
			.addConverterFactory(GsonConverterFactory.create())
			.client(client)
			.build()
	}

	@Provides
	@Singleton
	fun provideSurveyApi(retrofit: Retrofit): SurveyApi {
		return retrofit.create(SurveyApi::class.java)
	}

	@Provides
	@Singleton
	fun provideMemberApi(retrofit: Retrofit): MemberApi {
		return retrofit.create(MemberApi::class.java)
	}

	@Provides
	@Singleton
	fun provideWineStorageApi(retrofit: Retrofit): WineStorageApi {
		return retrofit.create(WineStorageApi::class.java)
	}

}
package com.apptive.easywine.di

import com.apptive.easywine.data.remote.MemberApi
import com.apptive.easywine.data.remote.SurveyApi
import com.apptive.easywine.data.remote.WineStorageApi
import com.apptive.easywine.data.repository.MemberRepositoryImpl
import com.apptive.easywine.data.repository.SurveyRepositoryImpl
import com.apptive.easywine.data.repository.WineStorageRepositoryImpl
import com.apptive.easywine.domain.repository.MemberRepository
import com.apptive.easywine.domain.repository.SurveyRepository
import com.apptive.easywine.domain.repository.WineStorageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

	@Provides
	@Singleton
	fun provideSurveyRepository(api: SurveyApi): SurveyRepository {
		return SurveyRepositoryImpl(api)
	}

	@Provides
	@Singleton
	fun provideMemberRepository(api: MemberApi): MemberRepository {
		return MemberRepositoryImpl(api)
	}

	@Provides
	@Singleton
	fun provideWineStorageRepository(api: WineStorageApi): WineStorageRepository {
		return WineStorageRepositoryImpl(api)
	}

}
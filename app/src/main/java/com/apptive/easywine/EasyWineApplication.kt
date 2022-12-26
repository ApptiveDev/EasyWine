package com.apptive.easywine

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class EasyWineApplication : Application() {

	init{
		instance = this
	}

	companion object {
		lateinit var instance: EasyWineApplication
		fun applicationContext() : Context {
			return instance.applicationContext
		}
	}

	override fun onCreate() {
		super.onCreate()
	}
}
package com.apptive.easywine.presentation.navgation

sealed class Screen(val route: String) {
	object SplashScreen: Screen("splash_screen")
	object LoginScreen: Screen("login_screen")
	object HomeScreen: Screen("home_screen")
	object SurveyScreen: Screen("survey_screen")
	object SurveyYesOrNoScreen: Screen("survey_yesorno_screen")
	object StorageScreen: Screen("storage_screen")
}
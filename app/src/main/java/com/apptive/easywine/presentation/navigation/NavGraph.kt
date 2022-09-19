package com.apptive.easywine.presentation.navgation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.easyWineGraph(
	navController: NavController,
	upPress: () -> Unit = {}
) {
	composable(Screen.SplashScreen.route) {
		// Splash Screen
	}

	composable(Screen.HomeScreen.route) {
		// Home Screen
	}

	composable(Screen.SurveyScreen.route) {
		// Survey Screen
	}

	composable(Screen.StorageScreen.route) {
		// Storage Screen
	}
}
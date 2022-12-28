package com.apptive.easywine.presentation.navgation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.apptive.easywine.presentation.Home.HomeScreen
import com.apptive.easywine.presentation.Home.WineStorage
import com.apptive.easywine.presentation.Login.LoginScreen
import com.apptive.easywine.presentation.Survey.SurveyScreen

fun NavGraphBuilder.easyWineGraph(
	navController: NavController,
	upPress: () -> Unit = {}
) {
	composable(Screen.SplashScreen.route) {
		// Splash Screen
	}

	composable(Screen.LoginScreen.route) {
		LoginScreen(navController)
	}

	composable(Screen.HomeScreen.route) {
		HomeScreen(navController)
	}

	composable(Screen.SurveyScreen.route) {
		SurveyScreen(navController)
	}

	composable(Screen.StorageScreen.route) {
		// Storage Screen
		WineStorage(navController)
	}
}
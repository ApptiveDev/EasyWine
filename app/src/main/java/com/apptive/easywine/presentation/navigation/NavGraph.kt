package com.apptive.easywine.presentation.navgation

import androidx.compose.material.ScaffoldState
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.apptive.easywine.presentation.Home.HomeScreen
import com.apptive.easywine.presentation.Login.LoginScreen
import com.apptive.easywine.presentation.Survey.SurveyScreen

fun NavGraphBuilder.easyWineGraph(
	navController: NavController,
	onClickDrawer: () -> Unit = {},
	upPress: () -> Unit = {}
) {
	composable(Screen.SplashScreen.route) {
		// Splash Screen
	}

	composable(Screen.LoginScreen.route) {
		LoginScreen(navController)
	}

	composable(Screen.HomeScreen.route) {
		HomeScreen(navController, onClickDrawer)
	}

	composable(Screen.SurveyScreen.route) {
		SurveyScreen(navController)
	}

	composable(Screen.StorageScreen.route) {
		// Storage Screen
	}
}
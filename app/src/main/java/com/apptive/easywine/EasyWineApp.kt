package com.apptive

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.apptive.easywine.presentation.navgation.Screen
import com.apptive.easywine.presentation.navgation.easyWineGraph
import com.apptive.easywine.ui.theme.EasyWineTheme

@Composable
fun EasyWineApp() {
	EasyWineTheme {
		Scaffold(
			scaffoldState = rememberScaffoldState(),
			bottomBar = {}
		) {
			var navController = rememberNavController()
			NavHost(
				navController = navController,
				startDestination = Screen.LoginScreen.route,
			) {
				easyWineGraph(
					navController = navController
				)
			}
			it
		}
	}
}
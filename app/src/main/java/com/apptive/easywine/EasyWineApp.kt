package com.apptive

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.apptive.easywine.presentation.components.NavigationDrawer
import com.apptive.easywine.presentation.navgation.Screen
import com.apptive.easywine.presentation.navgation.easyWineGraph
import com.apptive.easywine.ui.theme.EasyWineTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun EasyWineApp() {
	val scaffoldState = rememberScaffoldState()
	val scope = rememberCoroutineScope()

	EasyWineTheme {
		Scaffold(
			scaffoldState = scaffoldState,
			bottomBar = {},
			drawerContent = {
				NavigationDrawer(
					currentScreen = Screen.HomeScreen
				) {
					scope.launch {
						delay(timeMillis = 200)
						scaffoldState.drawerState.close()
					}
				}
			}
		) {
			var navController = rememberNavController()
			NavHost(
				navController = navController,
				startDestination = Screen.LoginScreen.route,
			) {
				easyWineGraph(
					navController = navController,
					onClickDrawer = {
						scope.launch {
							scaffoldState.drawerState.open()
						}
					}
				)
			}
			it
		}
	}
}
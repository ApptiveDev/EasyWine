package com.apptive

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.apptive.easywine.domain.util.RtlDrawerScaffold
import com.apptive.easywine.domain.util.rememberScaffoldState
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
    val navController = rememberNavController()
    var current =  navController.currentBackStackEntry?.destination?.route

    EasyWineTheme {
        RtlDrawerScaffold(
            scaffoldState = scaffoldState,
            bottomBar = {},
            drawerContent = {
                NavigationDrawer(
                    currentScreen = current ?: Screen.HomeScreen.route,
                ) {
                    scope.launch {
                        delay(timeMillis = 200)
                        navController.navigate(it)
                        scaffoldState.drawerState.close()
                    }

                }
            }
        ) {

            NavHost(
                navController = navController,
                startDestination = Screen.LoginScreen.route,
            ) {
                easyWineGraph(
                    navController = navController,
                    onClickDrawer = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                            Log.d(
                                "test",
                                "${navController.currentBackStackEntry?.destination?.route}"
                            )
                        }
                    },
                    upPress = {navController.navigateUp()}
                )
            }
            it
        }
    }
}
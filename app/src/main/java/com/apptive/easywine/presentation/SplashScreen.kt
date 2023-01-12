package com.apptive.easywine.presentation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.apptive.easywine.R
import com.apptive.easywine.data.repository.MemberRepositoryImpl
import com.apptive.easywine.domain.use_case.member.checkLogined
import com.apptive.easywine.domain.util.Resource
import com.apptive.easywine.domain.util.log
import com.apptive.easywine.presentation.navgation.Screen
import com.apptive.easywine.ui.theme.wine_button
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
	navController: NavController,
	viewModel: SplashViewModel = hiltViewModel(),
) {
	var startAnimation by remember { mutableStateOf(false) }
	val alphaAnim = animateFloatAsState(
		targetValue = if (startAnimation) 1f else 0f,
		animationSpec = tween(1000)
	)

	LaunchedEffect(key1 = true) {
		var nextScreen = ""

		if(viewModel.isLogined) nextScreen = Screen.HomeScreen.route
		else nextScreen = Screen.LoginScreen.route

		startAnimation = true

		// 화면 전환
		delay(1500L)
		navController.popBackStack()
		navController.navigate(nextScreen) {
			popUpTo(0)
		}
	}
	Splash(alpha = alphaAnim.value)
}

@Composable
private fun Splash(alpha: Float) {
	Column(
		horizontalAlignment = Alignment.CenterHorizontally,
		modifier = Modifier
			.background(Color.White)
			.fillMaxSize()
			.alpha(alpha = alpha)
	) {
		Text(
			text = "EASY WINE",
			color = wine_button,
			modifier = Modifier
				.padding(top = 140.dp)
				.height(95.dp)
		)
		Image(
			modifier = Modifier
				.size(98.dp, 96.dp)
				.clickable { },
			painter = painterResource(id = R.drawable.easywine_logo),
			contentDescription = null
		)
		Spacer(modifier = Modifier.height(57.dp))
	}
}
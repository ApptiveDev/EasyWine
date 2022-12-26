package com.apptive.easywine.presentation.Login

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import com.apptive.easywine.R
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.apptive.easywine.domain.util.log
import com.apptive.easywine.presentation.components.LogoTopBar
import com.apptive.easywine.presentation.navgation.Screen
import com.apptive.easywine.ui.theme.gray_button_before
import com.apptive.easywine.ui.theme.wine_button
import kotlinx.coroutines.flow.collectLatest

@Composable
fun LoginScreen(
	navController: NavController = rememberNavController(),
	viewModel: LoginViewModel = hiltViewModel(),
) {
	val context = LocalContext.current

	LaunchedEffect(key1 = true) {
		viewModel.eventFlow.collectLatest { event ->
			when(event) {
				is LoginViewModel.UiEvent.Error -> {
					"LOGIN ERROR!!".log()
					Toast.makeText(context, "LOGIN ERROR!!", Toast.LENGTH_SHORT).show()
				}
				is LoginViewModel.UiEvent.Login -> {
					"LOGIN SUCCESS!!".log()
					Toast.makeText(context, "LOGIN SUCCESS!!", Toast.LENGTH_SHORT).show()
					navController.navigate(Screen.HomeScreen.route) {
						popUpTo(0)
					}
				}
			}
		}
	}

	Column(
		horizontalAlignment = Alignment.CenterHorizontally,
		modifier = Modifier
			.fillMaxSize()
			.background(Color.White)
			.verticalScroll(rememberScrollState())
	) {
		LogoTopBar(title = "EASY WINE", fontSize = 24, color = wine_button)

		//Spacer(modifier = Modifier.height(38.dp))
		//ImageAdd()

		Spacer(modifier = Modifier.height(80.dp))

		BasicInfoBox(
			type = "Email",
			text = viewModel.userInfo.email,
			onValueChange = { viewModel.onEvent(LoginEvent.EnteredEmail(it)) },
			keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
		)

		Spacer(modifier = Modifier.height(30.dp))

		PasswordBox(
			type = "Password",
			text = viewModel.userInfo.pass,
			onValueChange = { viewModel.onEvent(LoginEvent.EnteredPassword(it)) },
		)

		Spacer(modifier = Modifier.height(10.dp))

		Row {
			Spacer(modifier = Modifier.width(189.dp))
			Text(
				modifier = Modifier.clickable { },
				text = "Forgot Password ?",
				fontSize = 14.sp,
				color = gray_button_before
			)
		}

		Spacer(modifier = Modifier.height(30.dp))

		LoginButton(
			Modifier, "Login", wine_button
		) { viewModel.onEvent(LoginEvent.Login) }

		Spacer(modifier = Modifier.height(80.dp))

		SocialLoginContent()

		Spacer(modifier = Modifier.height(30.dp))

		Row() {
			Text(
				text = "Don't have an account?", fontSize = 13.sp, color = gray_button_before
			)
			Text(
				modifier = Modifier.clickable { },
				text = "Sign up",
				fontSize = 13.sp,
				color = wine_button
			)
		}

		Spacer(modifier = Modifier.height(30.dp))
	}
}

@Composable
fun ImageAdd() {
	Box(
		modifier = Modifier
			.clip(RoundedCornerShape(50))
			.width(107.dp)
			.height(107.dp)
			.clickable { }) {
		Image(
			modifier = Modifier
				.size(107.dp, 107.dp)
				.clickable { },
			painter = painterResource(id = R.drawable.image_add_circle),
			contentDescription = null
		)
	}
}

@Preview
@Composable
fun PreviewSurveyQuestion() {
	ImageAdd()
}
















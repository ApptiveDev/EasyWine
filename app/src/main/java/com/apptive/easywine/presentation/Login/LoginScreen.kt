package com.apptive.easywine.presentation.Login

import android.widget.Space
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import com.apptive.easywine.R
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

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LoginScreen(
	navController: NavController = rememberNavController(),
	viewModel: LoginViewModel = hiltViewModel(),
) {
	val context = LocalContext.current
	var isSignUpMode by remember { mutableStateOf(false) }

	LaunchedEffect(key1 = true) {
		viewModel.eventFlow.collectLatest { event ->
			when (event) {
				is LoginViewModel.UiEvent.Error -> {
					Toast.makeText(context, event.message, Toast.LENGTH_SHORT).show()
				}
				is LoginViewModel.UiEvent.Login -> {
					"LOGIN SUCCESS!!".log()
					Toast.makeText(context, "LOGIN SUCCESS!!", Toast.LENGTH_SHORT).show()
					navController.navigate(Screen.HomeScreen.route) {
						popUpTo(0)
					}
				}
				is LoginViewModel.UiEvent.SignUp -> {
					isSignUpMode = true
				}
				LoginViewModel.UiEvent.CreateAccount -> {
					"CREATE ACCOUNT SUCCESS!!".log()
					Toast.makeText(context, "CREATE ACCOUNT SUCCESS!!", Toast.LENGTH_SHORT).show()
					isSignUpMode = false
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
		Spacer(modifier = Modifier.height(27.dp))
		Image(
			modifier = Modifier
				.size(98.dp, 96.dp)
				.clickable { },
			painter = painterResource(id = R.drawable.easywine_logo),
			contentDescription = null
		)
		Spacer(modifier = Modifier.height(57.dp))

		BasicInfoBox(
			width = 305.dp,
			height = 50.dp,
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

		if (isSignUpMode) {
			BasicInfoBox(
				width = 305.dp,
				height = 50.dp,
				type = "Name",
				text = viewModel.userInfo.name,
				onValueChange = { viewModel.onEvent(LoginEvent.EnteredName(it)) },
			)
			Spacer(modifier = Modifier.height(30.dp))
			Row {
				GenderBox() { viewModel.onEvent(LoginEvent.EnterGender(it)) }
				Spacer(modifier = Modifier.width(18.dp))
				BasicInfoBox(
					width = 118.dp,
					height = 50.dp,
					type = "Age",
					text = viewModel.userInfo.age.toString(),
					onValueChange = { viewModel.onEvent(LoginEvent.EnteredAge(it.toIntOrNull() ?: 0)) },
					keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
				)
			}
			Spacer(modifier = Modifier.height(30.dp))
		}


		LoginButton(
			modifier = Modifier,
			text = if (isSignUpMode) "Create Account" else "Login",
			color = wine_button
		) {
			if (isSignUpMode) viewModel.onEvent(LoginEvent.CreateAccount)
			else viewModel.onEvent(LoginEvent.Login)
		}

		Spacer(modifier = Modifier.height(80.dp))

		SocialLoginContent()

		Spacer(modifier = Modifier.height(30.dp))

		Row(
			verticalAlignment = Alignment.CenterVertically
		) {
			Surface(
				modifier = Modifier.padding(3.dp)
			) {
				Text(
					text =
					if (isSignUpMode) "Already have an account?"
					else "Don't have an account?",
					fontSize = 13.sp,
					color = gray_button_before
				)
			}

			Surface(
				onClick = { isSignUpMode = !isSignUpMode },
			) {
				Text(
					text = if (isSignUpMode) "Sign in" else "Sign up",
					fontSize = 13.sp,
					color = wine_button
				)
			}
		}

		Spacer(modifier = Modifier.height(30.dp))
	}
}

@Preview
@Composable
fun PreviewSurveyQuestion() {
	LoginScreen()
}

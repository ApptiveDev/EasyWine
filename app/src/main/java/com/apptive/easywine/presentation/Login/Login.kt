package com.apptive.easywine.presentation.Login

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.apptive.easywine.domain.util.log
import com.apptive.easywine.presentation.navgation.Screen
import kotlinx.coroutines.flow.collectLatest

@Composable
fun LoginScreen(
	navController: NavController,
	viewModel: LoginViewModel = hiltViewModel()
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
		verticalArrangement = Arrangement.Center,
		horizontalAlignment = Alignment.CenterHorizontally,
		modifier = Modifier.fillMaxSize()
	) {
		OutlinedTextField(value = viewModel.emailPw.value.email,
			onValueChange = { viewModel.onEvent(LoginEvent.EnteredEmail(it)) },
			keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
		)
		OutlinedTextField(value = viewModel.emailPw.value.pass,
			onValueChange = { viewModel.onEvent(LoginEvent.EnteredPassword(it)) },
			keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
		)
		Spacer(modifier = Modifier.size(150.dp))
		Button(onClick = { viewModel.onEvent(LoginEvent.Login) }) {
			Text("로그인")
		}
	}
}

@Preview
@Composable
fun PreviewLoginScreen() {
	LoginScreen(rememberNavController())
}
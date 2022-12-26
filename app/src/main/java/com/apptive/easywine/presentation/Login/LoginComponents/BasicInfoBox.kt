package com.apptive.easywine.presentation.Login

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apptive.easywine.ui.theme.gray_button_before

@Composable
fun BasicInfoBox(
    type: String,
    text: String,
    onValueChange: (String) -> Unit = {},
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
){
    Surface(
        elevation = 5.dp,
        shape = RoundedCornerShape(15)
    ) {
        TextField(
            modifier = Modifier
                .width(305.dp)
                .height(48.dp)
                .padding(0.dp),
            value = text,
            onValueChange = onValueChange,
            singleLine = true,
            placeholder = {Text(text = type, fontSize = 14.sp)},
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                cursorColor = Color.Black,
                placeholderColor = gray_button_before,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                backgroundColor = Color.White
            ),
            keyboardOptions = keyboardOptions,
        )
    }
}

@Composable
fun PasswordBox(
    type: String,
    text: String,
    onValueChange: (String) -> Unit = {},
){
    Surface(
        elevation = 5.dp,
        shape = RoundedCornerShape(15)
    ) {
        var passwordVisible by remember { mutableStateOf(false) }

        TextField(
            value = text,
            onValueChange = onValueChange,
            modifier = Modifier
                .width(305.dp)
                .height(48.dp)
                .padding(0.dp),
            singleLine = true,
            placeholder = {
                Text(text = type, fontSize = 14.sp)
            },
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                cursorColor = Color.Black,
                placeholderColor = gray_button_before,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                backgroundColor = Color.White
            ),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val image = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                val description = if (passwordVisible) "Hide password" else "Show password"

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = image, description)
                }
            },
        )
    }
}

@Preview
@Composable
fun PreviewLoginBox() {
//    val LoginViewMode = viewModel<LoginViewModel>()
//    IdBox(LoginViewMode)
}


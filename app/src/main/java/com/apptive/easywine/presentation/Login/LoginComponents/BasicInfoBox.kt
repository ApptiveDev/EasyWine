package com.apptive.easywine.presentation.Login

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apptive.easywine.enums.Side
import com.apptive.easywine.ui.theme.gray_button
import com.apptive.easywine.ui.theme.gray_button_before
import com.apptive.easywine.ui.theme.notosanskr
import com.apptive.easywine.ui.theme.wine_button

@Composable
fun BasicInfoBox(
    type: String,
    text: String,
    width: Dp,
    height: Dp,
    onValueChange: (String) -> Unit = {},
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
){
    Surface(
        elevation = 5.dp,
        shape = RoundedCornerShape(15)
    ) {
        TextField(
            modifier = Modifier
                .width(width)
                .height(height)
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
                .height(50.dp)
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

@Composable
fun GenderBox(
    setGender: (Boolean) -> Unit = {},
){
    var selected by remember { mutableStateOf(Side.LEFT)}

    GenderDividedButton(
        leftText = "Male",
        rightText = "Female",
        selected = selected,
        leftOnClick = {
            selected = Side.LEFT
            setGender(if(selected == Side.LEFT) true else false)
        },
        rightOnClick = {
            selected = Side.RIGHT
            setGender(if(selected == Side.LEFT) false else true)
        }
    )
}

@Composable
private fun GenderDividedButton(
    leftOnClick: () -> Unit = {},
    rightOnClick: () -> Unit = {},
    leftText: String = "",
    rightText: String = "",
    selected: Side = Side.LEFT
){
    Row(){
        GenderCusttomButton(
            modifier = Modifier
                .clip(RoundedCornerShape(15, 0, 0, 15)),
            selected = (selected == Side.LEFT),
            onClick = leftOnClick,
            text = leftText,
            shape = RoundedCornerShape(15, 0, 0, 15)
        )
        GenderCusttomButton(
            modifier = Modifier
                .clip(RoundedCornerShape(0, 15, 15, 0)),
            selected = (selected == Side.RIGHT),
            onClick = rightOnClick,
            text = rightText,
            shape = RoundedCornerShape(0, 15, 15, 0)
        )
    }
}

@Composable
fun GenderCusttomButton(
    modifier: Modifier = Modifier,
    selected: Boolean = true,
    text: String = "",
    shape: Shape,
    onClick: () -> Unit = {}
){
    val border = if (selected) wine_button else gray_button
    val textColor = if (selected) wine_button else gray_button

    Box(modifier = modifier
        .width(81.dp)
        .height(50.dp)
        .border(width = 1.dp, shape = shape, color = border)
        .clip(RoundedCornerShape(20))
        .background(color = Color.White)
        .clickable { onClick() },
        contentAlignment = Alignment.Center
    ){
        Text(
            fontFamily = notosanskr,
            text = text,
            color = textColor,
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview
@Composable
fun PreviewLoginBox() {
//    val LoginViewMode = viewModel<LoginViewModel>()
//    IdBox(LoginViewMode)
}


package com.apptive.easywine.presentation.Login

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import com.apptive.easywine.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.apptive.easywine.presentation.components.LogoTopBar
import com.apptive.easywine.presentation.components.SurveyQuestion
import com.apptive.easywine.ui.theme.gray_button_before
import com.apptive.easywine.ui.theme.wine_button

@Composable
fun Login(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ){
        val LoginViewMode = viewModel<LoginViewModel>()
        LogoTopBar(title = "EASY WINE", fontSize = 24, color = wine_button)
        Spacer(modifier = Modifier.height(38.dp))
        ImageAdd()
        Spacer(modifier = Modifier.height(80.dp))
        BasicInfoBox("ID", LoginViewMode.accountId)
        Spacer(modifier = Modifier.height(30.dp))
        PasswordBox("Password", LoginViewMode.accountPw)
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
        LoginButton(Modifier, "Login", wine_button, {})
        Spacer(modifier = Modifier.height(80.dp))
        SocialLoginContent()
        Spacer(modifier = Modifier.height(30.dp))
        Row(){
            Text(
                text = "Don't have an account?",
                fontSize = 13.sp,
                color = gray_button_before
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
fun ImageAdd(){
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .width(107.dp)
            .height(107.dp)
            .clickable { }
        ) {
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
















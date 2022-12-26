package com.apptive.easywine.presentation.Login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.apptive.easywine.presentation.components.LogoTopBar
import com.apptive.easywine.ui.theme.gray_button_before
import com.apptive.easywine.ui.theme.wine_button

//@Composable
//fun MemberShip(){
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.White)
//            .verticalScroll(rememberScrollState())
//    ){
//        val LoginViewMode = viewModel<LoginViewModel>()
//        LogoTopBar(title = "EASY WINE", fontSize = 24, color = wine_button)
//        Spacer(modifier = Modifier.height(90.dp))
//        BasicInfoBox("Name", LoginViewMode.accountName)
//        Spacer(modifier = Modifier.height(30.dp))
//        BasicInfoBox("ID", LoginViewMode.accountId)
//        Spacer(modifier = Modifier.height(30.dp))
//        PasswordBox("Password", LoginViewMode.accountPw)
//        Spacer(modifier = Modifier.height(30.dp))
//        BasicInfoBox("Email", LoginViewMode.accountEmail)
//        Spacer(modifier = Modifier.height(40.dp))
//        LoginButton(Modifier, "Create Account", wine_button, {})
//        Spacer(modifier = Modifier.height(80.dp))
//        SocialLoginContent()
//        Spacer(modifier = Modifier.height(30.dp))
//        Row(){
//            Text(
//                text = "Don't have an account?",
//                fontSize = 13.sp,
//                color = gray_button_before
//            )
//            Text(
//                modifier = Modifier.clickable { },
//                text = "Sign up",
//                fontSize = 13.sp,
//                color = wine_button
//            )
//        }
//        Spacer(modifier = Modifier.height(30.dp))
//    }
//}

@Preview
@Composable
fun PreviewMemberShip() {
//    MemberShip()
}


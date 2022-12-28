package com.apptive.easywine.presentation.Login

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults

import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apptive.easywine.ui.theme.notosanskr
import com.apptive.easywine.ui.theme.wine_button
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.apptive.easywine.R
import com.apptive.easywine.presentation.components.SurveyYesOrNo
import com.apptive.easywine.ui.theme.gray_button_before
import com.apptive.easywine.ui.theme.gray_line

@Composable
fun LoginButton(
    modifier: Modifier = Modifier,
    text: String,
    color: Color,
    onClick: () -> Unit = {},
) {
    TextButton(
        onClick = onClick,
        modifier = modifier
            .width(305.dp)
            .height(50.dp)
            .clip(RoundedCornerShape(15))
            .background(color = color)
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun SocialLoginButton(
    color: Color,
    onClick: () -> Unit,
    size: Dp,
    icon: Int
){
    TextButton(
        onClick = onClick,
        modifier = Modifier
        .width(75.dp)
        .height(50.dp),
        shape = RoundedCornerShape(15),
        colors = ButtonDefaults.buttonColors(color),
        elevation =  ButtonDefaults.elevation(2.dp),
    ) {
        Image(
            modifier = Modifier
            .size(size)
            .weight(2f),
            painter = painterResource(id = icon),
            contentDescription = null
        )
    }
}

@Composable
fun SocialLoginContent(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(
                modifier = Modifier
                    .width(84.dp)
                    .height(1.5.dp)
                    .background(gray_line)
            )
            Spacer(modifier = Modifier.width(15.dp))
            Text(
                fontFamily = notosanskr,
                text = "Or sign up with",
                color = gray_button_before,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.width(15.dp))
            Box(
                modifier = Modifier
                    .width(84.dp)
                    .height(1.5.dp)
                    .background(gray_line)
            )
        }
        Spacer(modifier = Modifier.height(13.dp))
        Row(){
            SocialLoginButton(Color.White, {},20.dp, R.drawable.google)
            Spacer(modifier = Modifier.width(30.dp))
            SocialLoginButton(Color.White, {},55.dp, R.drawable.kakao)
        }
    }
}
@Preview
@Composable
fun PreviewLoginButton() {
    Column {
        LoginButton(Modifier, "Login", wine_button, {})
        Spacer(modifier = Modifier.height(10.dp))
        LoginButton(Modifier, "Create Account", wine_button, {})
        Spacer(modifier = Modifier.height(10.dp))
        SocialLoginButton(Color.White, {},25.dp, R.drawable.google)
        Spacer(modifier = Modifier.height(10.dp))
        SocialLoginButton(Color.White, {},70.dp, R.drawable.kakao)
        Spacer(modifier = Modifier.height(10.dp))
        SocialLoginContent()
    }
}

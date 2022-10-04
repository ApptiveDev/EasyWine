package com.apptive.easywine.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apptive.easywine.R
import com.apptive.easywine.ui.theme.gray_button_before
import com.apptive.easywine.ui.theme.wine_button
import com.apptive.easywine.ui.theme.wine_main
import okhttp3.internal.wait
import androidx.compose.ui.graphics.Color as Color


@Composable
fun BeforeResultButton(){
    val shape = RoundedCornerShape(70.dp)
    Button(
        onClick = { /*TODO*/ },
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = gray_button_before
        ),
        modifier = Modifier
            .width(280.dp)
            .height(60.dp)
    ){
        Box(
            modifier = Modifier
                .width(266.dp)
                .height(50.dp)
                .border(
                    width = 1.dp,
                    color = Color.White,
                    shape = shape
                )
        ){
            Text(
                text = "오늘의 와인 확인하기",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
    }
}

@Composable
fun AfterResultButton(){
    val shape = RoundedCornerShape(70.dp)
    Button(
            onClick = { /*TODO*/ },
            shape = shape,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = wine_button
            ),
            modifier = Modifier
                .width(280.dp)
                .height(60.dp)
        ){
            Box(
                modifier = Modifier
                    .width(266.dp)
                    .height(50.dp)
                    .border(
                        width = 1.dp,
                        color = Color.White,
                        shape = shape
                    )
            ){
                Text(
                    text = "오늘의 와인 확인하기",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier
                        .align(Alignment.Center)

                )
            }

        }
}


@Composable
fun PreviousPage(){
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Transparent
            )
        ) {
            Row() {
                Image(
                    painterResource(id = R.drawable.page_previous),
                    contentDescription = "previous page button",
                    modifier = Modifier
                        .height(22.dp)
                        .width(22.dp)
                )
                Text(text = "이전으로 돌아가기",
                    color = gray_button_before,
                    fontSize = 15.sp)
            }

        }
    }


@Composable
fun NextPage(){
    Button(
        onClick = { /*TODO*/ },

        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent
        )
    ) {
        Row() {
            Text(text = "다음으로 넘어가기",
                color = gray_button_before,
                fontSize = 15.sp)
            Image(
                painterResource(id = R.drawable.page_next),
                contentDescription = "next page button",
                modifier = Modifier
                    .height(22.dp)
                    .width(22.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewResultButton(){
    Column {
        BeforeResultButton()
        AfterResultButton()
        PreviousPage()
        NextPage()
    }
}
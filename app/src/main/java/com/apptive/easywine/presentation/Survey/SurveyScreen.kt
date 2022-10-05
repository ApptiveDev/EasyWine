package com.apptive.easywine.presentation.Survey

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apptive.easywine.R
import com.apptive.easywine.presentation.components.*
import com.apptive.easywine.ui.theme.gray_button_before


@Composable
fun SurveyScreen(){
    val scrollState = rememberScrollState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        Box() {

            TextTopBar(title = "오늘의 와인 추천")

            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
                    .align(Alignment.TopStart)
                    .offset(x=15.dp, y=15.dp)
            ) {
                Icon(
                    painterResource(id = R.drawable.survey_arrow),
                    contentDescription = "previous page button",
                    modifier = Modifier
                        .width(42.dp)
                        .height(48.dp),
                    tint = Color.White
                )
            }

            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
                    .align(Alignment.TopEnd)
                    .offset(x=-15.dp, y=15.dp)
            ){
                Icon(
                    painterResource(id = R.drawable.survey_menu),
                    contentDescription = "menu page button",
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp),
                    tint = Color.White
                )
            }

        }
        Spacer(modifier = Modifier.size(30.dp))
        SurveyProgressBar(prog_percent = 0.7f)
        ///단계별 버튼
        ///중간에 들어갈 화면

        Box() {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row {
                    PageNav(isLeft = true)
                    Spacer(modifier = Modifier.size(30.dp))
                    PageNav(isLeft = false)
                }
                ResultButton(
                    text = "오늘의 와인 확인하기",
                    color = gray_button_before
                )
            }

        }

    }
}
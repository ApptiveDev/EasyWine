package com.apptive.easywine.presentation.Survey

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apptive.easywine.R
import com.apptive.easywine.presentation.components.*

@Preview
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

            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent),
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier
                    .height(60.dp)
                    .width(60.dp)
                    .align(Alignment.TopStart)
            ){
                Image(
                    painterResource(id = R.drawable.survey_arrow),
                    contentDescription = "previous page button",
                    modifier = Modifier
                        .width(40.dp)
                        .height(45.dp)
                )
            }

            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent),
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier
                    .height(60.dp)
                    .width(60.dp)
                    .align(Alignment.TopEnd)
            ){
                Image(
                    painterResource(id = R.drawable.survey_menu),
                    contentDescription = "menu page button",
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
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
                Row() {
                    PreviousPage()
                    Spacer(modifier = Modifier.size(30.dp))
                    NextPage()
                }
                BeforeResultButton()
            }

        }

    }
}
package com.apptive.easywine.presentation.Survey

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.apptive.easywine.presentation.Home.QCard
import com.apptive.easywine.presentation.components.*
import com.apptive.easywine.ui.theme.gray_button_before

@Composable
fun SurveyScreen(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color.White)
            //.fillMaxSize()
            //.verticalScroll(scrollState)
    ){
        TextTopBar(title = "오늘의 와인 추천",18)
        SurveyTopbar()
        Spacer(modifier = Modifier.height(30.dp))
        SurveyTitle("오늘의 와인을 위한 ","바디감 ","질문이에요.")
        Spacer(modifier = Modifier.height(30.dp))
        SurveyMainContent()
    }

}

@Composable
fun SurveyMainContent() {
    val scrollState = rememberScrollState()
    Column(){
        LazyColumn() {
            item { Spacer(Modifier.size(10.dp)) }
            repeat(5) {
                item { SurveyQuestion() }
            }
            item {
                SurveyBottomButton()
            }
        }
    }
}

@Composable
fun SurveyBottomButton(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(25.dp))
        Row {
            PageNav(isLeft = true)
            Spacer(modifier = Modifier.size(30.dp))
            PageNav(isLeft = false)
        }
        ResultButton(
            text = "오늘의 와인 확인하기",
            color = gray_button_before
        )
        Spacer(modifier = Modifier.height(50.dp))
    }
}

@Preview
@Composable
fun PreviewSurveyScreen() {
    SurveyScreen()
}

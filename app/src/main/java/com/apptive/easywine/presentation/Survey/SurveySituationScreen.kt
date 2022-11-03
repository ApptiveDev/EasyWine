package com.apptive.easywine.presentation.Survey
import SurveyMultipleCheck
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apptive.easywine.R
import com.apptive.easywine.presentation.Home.QCard
import com.apptive.easywine.presentation.components.*
import com.apptive.easywine.ui.theme.gray_button_before
import com.apptive.easywine.ui.theme.wine_button

@Composable
fun SurveySituationScreen(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color.White)
    ){
        SnackTopBar(title = "오늘의 와인 추천",18)
        SurveyTopbar()
        Spacer(modifier = Modifier.height(30.dp))
        SurveySituationMainContent()
    }

}

@Composable
fun SurveySituationMainContent() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        SurveyTitle("오늘의 와인을 위한 ","상황 ","질문이에요.")
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "최대 5개까지 선택 가능합니다.",
            color = gray_button_before,
            fontSize = 13.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Normal
        )
        Spacer(modifier = Modifier.height(40.dp))
    }
    SurveyMultipleCheck()
    Spacer(modifier = Modifier.height(40.dp))
    SurveySituaitonBottomButton()
}

@Composable
fun SurveySituaitonBottomButton(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(25.dp))
        Row {
            PageNav(isLeft = true)
            Spacer(modifier = Modifier.width(172.dp))
        }
        ResultButton(
            text = "오늘의 와인 확인하기",
            color = wine_button
        )
        Spacer(modifier = Modifier.height(50.dp))
    }
}

@Preview
@Composable
fun PreviewSurveyMultiScreen() {
    SurveySituationScreen()
}

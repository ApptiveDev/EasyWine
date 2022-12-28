package com.apptive.easywine.presentation.Survey

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.apptive.easywine.domain.model.Question
import com.apptive.easywine.enums.SurveyLevel
import com.apptive.easywine.presentation.components.*
import com.apptive.easywine.presentation.navgation.Screen
import com.apptive.easywine.ui.theme.gray_button_before
import com.apptive.easywine.ui.theme.wine_button

@Composable
fun SurveyYesOrNoScreen(
    navController: NavController = rememberNavController(),
    surveyViewModel: SurveyViewModel = hiltViewModel(),
    onClickDrawer: () -> Unit = {},
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .background(Color.White)
    ){
        SnackTopBar(title = "오늘의 와인 추천", fontSize = 18, onClickDrawer = onClickDrawer)
        SurveyYesOrNoMainContent(
            0.7F,
            SurveyLevel.MOOD,
            "오늘의 와인을 위한 ",
            "상황 ",
            "질문이에요.",
            surveyViewModel.questions2,
        )
        SurveyYesOrNoBottomButton()

    }
}

@Composable
fun SurveyYesOrNoMainContent(
    percent: Float,
    level: SurveyLevel,
    title_front: String,
    condition: String,
    title_back: String,
    question2: List<Question>,
    navController: NavController = rememberNavController(),
) {
}

@Composable
fun SurveyYesOrNoBottomButton(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(15.dp))
        Row {
            PageNav(isLeft = true)
            Spacer(modifier = Modifier.size(30.dp))
            PageNav(isLeft = false)
        }
        Spacer(modifier = Modifier.height(35.dp))
        ResultButton(
            text = "오늘의 와인 확인하기",
            color =  gray_button_before
        )
        Spacer(modifier = Modifier.height(50.dp))
    }
}


@Preview
@Composable
fun PreviewSurveyYesOrNoScreen() {
    SurveyYesOrNoScreen()
}

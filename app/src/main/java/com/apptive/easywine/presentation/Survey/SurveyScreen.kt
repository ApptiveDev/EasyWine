package com.apptive.easywine.presentation.Survey

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Button
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.apptive.easywine.domain.model.Question
import com.apptive.easywine.enums.SurveyLevel
import com.apptive.easywine.presentation.components.*
import com.apptive.easywine.ui.theme.gray_button_before
import kotlinx.coroutines.CoroutineScope

@Composable
fun SurveyScreen(
	navController: NavController = rememberNavController(),
	surveyViewModel: SurveyViewModel = hiltViewModel(),
	scaffoldState: ScaffoldState = rememberScaffoldState(),
	scope: CoroutineScope = rememberCoroutineScope()
) {
	Column(
		horizontalAlignment = Alignment.CenterHorizontally,
		modifier = Modifier
			.background(Color.White)
	) {
		SnackTopBar(title = "오늘의 와인 추천", fontSize = 18, scope = scope, scaffoldState = scaffoldState,)

		/* just for test 
		Button(
			onClick = { surveyViewModel.level = surveyViewModel.level.increaseLevel() },
			content = { Text("+") } )
		Button(
			onClick = { surveyViewModel.level = surveyViewModel.level.decreaseLevel() },
			content = { Text("+") } )
		*/

		SurveyMainContent(
            0.7F,
			surveyViewModel.level,
            "오늘의 와인을 위한 ",
            "바디감 ",
            "질문이에요.",
            surveyViewModel.questions1
        )
	}
}

@Composable
fun SurveyMainContent(
	percent: Float,
	level: SurveyLevel,
	title_front: String,
	condition: String,
	title_back: String,
	questions1: List<Question>,
) {
	val scrollState = rememberScrollState()
	Column() {
		LazyColumn(
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			item {
				SurveyTopbar(percent, level)
				Spacer(modifier = Modifier.height(30.dp))
				SurveyTitle(title_front, condition, title_back)
				Spacer(modifier = Modifier.height(30.dp))
			}
			item { Spacer(Modifier.size(10.dp)) }
			questions1.forEach {
				item {
					SurveyQuestion(
						questionContent = it.context,
						questionId = it.id,
					)
				}
			}
			item {
				SurveyBottomButton()
			}
		}
	}
}

@Composable
fun SurveyBottomButton() {
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

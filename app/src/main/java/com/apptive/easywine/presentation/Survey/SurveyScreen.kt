package com.apptive.easywine.presentation.Survey

import SurveyMultipleCheck
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.apptive.easywine.domain.model.Question
import com.apptive.easywine.domain.util.log
import com.apptive.easywine.enums.SurveyLevel
import com.apptive.easywine.presentation.components.*
import com.apptive.easywine.ui.theme.gray_button_before
import com.apptive.easywine.ui.theme.wine_button
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collectLatest

@Composable
fun SurveyScreen(
	navController: NavController = rememberNavController(),
	upPress: () -> Unit = {},
	surveyViewModel: SurveyViewModel = hiltViewModel(),
	onClickDrawer: () -> Unit = {},
	scope: CoroutineScope = rememberCoroutineScope()
) {
	Column(
		horizontalAlignment = Alignment.CenterHorizontally,
		modifier = Modifier
			.background(Color.White)
	) {
		SnackTopBar(title = "오늘의 와인 추천", fontSize = 18, onClickDrawer = onClickDrawer, upPress = upPress)

		SurveyMainContent(onClickSubmit = {navController.navigate("")})
	}
}

@Composable
fun SurveyMainContent(
	onClickSubmit :() -> Unit =  {},
	surveyViewModel: SurveyViewModel = hiltViewModel(),
) {
	val current = LocalContext.current

	LaunchedEffect(key1 = true) {
		surveyViewModel.eventFlow.collectLatest { event ->
			when (event) {
				is UiEvent.Error -> {
					Toast.makeText(current, event.message, Toast.LENGTH_SHORT).show()
				}
				is UiEvent.Submit -> {
					"LOGIN SUCCESS!!".log()
					Toast.makeText(current, "제출 성공!", Toast.LENGTH_SHORT).show()
					onClickSubmit()
				}
			}
		}
	}

	Column() {
		LazyColumn(
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			item {
				SurveyTopbar(surveyViewModel.level)
				Spacer(modifier = Modifier.height(30.dp))
				SurveyTitle("오늘의 와인을 위한 ", surveyViewModel.level.korText, "질문이에요.")
				Spacer(modifier = Modifier.height(30.dp))
			}
			item { Spacer(Modifier.size(10.dp)) }

			when (surveyViewModel.level) {
				SurveyLevel.FLAVOR -> {
					item { questionItem(surveyViewModel.questions1, surveyViewModel) }
				}
				SurveyLevel.MOOD -> {
					item { questionItem(surveyViewModel.questions2, surveyViewModel) }
				}
				SurveyLevel.ETC -> {
					item { questionItem(surveyViewModel.questions3, surveyViewModel) }
				}
			}

			item {
				SurveyBottomButton(
					onLeftClick = { surveyViewModel.level = surveyViewModel.level.decreaseLevel() },
					onRightClick = {
						surveyViewModel.level = surveyViewModel.level.increaseLevel()
					},
					onButtonClick = {
						if (
							surveyViewModel.inputData[0] == 0 ||
							surveyViewModel.inputData[1] == 0 ||
							surveyViewModel.inputData[2] == 0 ||
							surveyViewModel.inputData[3] == 0 ||
							surveyViewModel.inputData[4] == 0 ||
							surveyViewModel.inputData[5] == 0 ||
							surveyViewModel.inputData[6] == 0 ||
							surveyViewModel.inputData[7] == 0 ||
							surveyViewModel.inputData[8] == 0 ||
							surveyViewModel.inputData[9] == 0
						) {
							Toast.makeText(current, "설문을 모두 완료해주세요", Toast.LENGTH_SHORT).show()
							return@SurveyBottomButton
						}
						surveyViewModel.submitSurvey()
					},
					level = surveyViewModel.level
				)
			}
		}
	}
}

@Composable
fun questionItem(
	questions: List<Question>,
	viewModel: SurveyViewModel,
) {
	questions.forEach {
		if (it.answerFormat == 1) {
			SurveyQuestion(it) { degree ->
				viewModel.inputData[it.id.toInt() - 1] = degree
			}
		} else if (it.answerFormat == 2) {
			SurveyMultipleCheck(it) { idx ->
				viewModel.inputData[it.id.toInt() - 1] = idx
			}
			Spacer(modifier = Modifier.size(20.dp))
		}
	}
}

@Composable
fun SurveyBottomButton(
	onLeftClick: () -> Unit = {},
	onRightClick: () -> Unit = {},
	onButtonClick: () -> Unit = {},
	level: SurveyLevel,
) {
	Column(
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Spacer(modifier = Modifier.height(25.dp))
		Row(
			horizontalArrangement = Arrangement.SpaceBetween
		) {
			if (level.number != 1) PageNav(onClick = onLeftClick, isLeft = true) else Text("    ")
			if (level.number != 3) PageNav(onClick = onRightClick, isLeft = false) else Text("    ")
		}

		Spacer(modifier = Modifier.height(50.dp))

		ResultButton(
			text = "오늘의 와인 확인하기",
			color = if (level.number >= 3) wine_button else gray_button_before,
			onClick = onButtonClick
		)
		Spacer(modifier = Modifier.height(50.dp))
	}
}

@Preview
@Composable
fun PreviewSurveyScreen() {
	SurveyScreen()
}

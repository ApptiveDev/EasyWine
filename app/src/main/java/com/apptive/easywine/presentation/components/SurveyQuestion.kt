package com.apptive.easywine.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apptive.easywine.R
import com.apptive.easywine.enums.Degree
import com.apptive.easywine.ui.theme.wine_button
import com.apptive.easywine.ui.theme.gray_button_before

@Composable
fun SurveyQuestion(
	questionContent: String = "",
	questionId: Long = 0L,
) {
	Column(
		modifier = Modifier
			.fillMaxWidth()
//			.background(Color.White) // 추후 삭제
			.padding(vertical = 20.dp)
			.padding(horizontal = 23.dp)
			.wrapContentSize(Alignment.Center),
		horizontalAlignment = Alignment.CenterHorizontally,
	) {
		QuestionContainer("Q$questionId. $questionContent")
		RadioContainer()
		SideText("엷다", "부드럽다")
	}

}

@Composable
fun QuestionContainer(
	title: String,
	color: Color = gray_button_before
) {
	Row(
		modifier = Modifier.padding(bottom = 38.dp),
		verticalAlignment = Alignment.CenterVertically
	) {
		Text(
			text = title,
			fontFamily = FontFamily.SansSerif,
			fontSize = 15.sp,
			fontWeight = FontWeight(400),
			color = color
		)

		Spacer(modifier = Modifier.width(3.dp))

		// TODO 추후 IconButton
		Icon(
			painter = painterResource(id = R.drawable.circle_question),
			contentDescription = "help icon",
			modifier = Modifier.size(15.dp)
		)
	}
}


@Composable
private fun RadioContainer(
	modifier: Modifier = Modifier,
) {
	var selectedValue = remember { mutableStateOf(Degree.DG_NONE) }

	Row(
		modifier = Modifier
			.fillMaxWidth()
			.selectableGroup()
			.wrapContentHeight()
			.padding(bottom = 16.dp)
			.padding(horizontal = 20.dp),
		verticalAlignment = Alignment.CenterVertically,
		horizontalArrangement = Arrangement.SpaceBetween
	) {

		Degree.values().forEach { label ->
			if (Degree.DG_NONE != label) {

				// TODO - 별로 안어려우니 radio 버튼을 resource 로 쓰기보다는 코드로 구현해보도록 합시다!

				Icon(
					imageVector = if(selectedValue.value == label) Icons.Filled.CheckCircle else Icons.Outlined.Circle,
					contentDescription = null,
					tint = if (selectedValue.value == label) wine_button else gray_button_before,
					modifier = Modifier
						.size(label.radioSize)
						.selectable(
							selected = (selectedValue.value == label),
							onClick = { selectedValue.value = label},
							role = Role.RadioButton
						)
				)
//				Icon(
//					painter = painterResource(
//						id = if (selectedValue.value == label) R.drawable.check_circle else R.drawable.uncheck
//					),
//					contentDescription = null,
//					tint = if (selectedValue.value == label) Color(0xFFD65261) else Color(0xFF929292),
//					modifier = Modifier
//						.size(label.radioSize)
//						.selectable(
//							selected = (selectedValue.value == label),
//							onClick = { selectedValue.value = label },
//							role = Role.RadioButton
//						)
//				)
			}
		}
	}
}

@Composable
fun SideText(
	leftText: String,
	rightText: String,
	color: Color = gray_button_before
) {
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.padding(horizontal = 24.dp),
		horizontalArrangement = Arrangement.SpaceBetween
	) {
		Text(
			text = leftText,
			fontFamily = FontFamily.SansSerif,
			fontSize = 15.sp,
			fontWeight = FontWeight(400),
			color = color,
			textAlign = TextAlign.Start
		)
		Text(
			text = rightText,
			fontFamily = FontFamily.SansSerif,
			fontSize = 15.sp,
			fontWeight = FontWeight(400),
			color = color,
			textAlign = TextAlign.End
		)
	}
}


@Preview
@Composable
fun PreviewSurveyQuestion() {
	SurveyQuestion()
}

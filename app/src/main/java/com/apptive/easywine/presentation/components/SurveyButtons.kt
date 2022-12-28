package com.apptive.easywine.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apptive.easywine.R
import com.apptive.easywine.ui.theme.gray_button_before
import com.apptive.easywine.ui.theme.wine_button
import androidx.compose.ui.graphics.Color as Color


@Composable
fun ResultButton(
	text: String,
	color: Color,
	onClick: () -> Unit = {},
) {
	Button(
		onClick = onClick,
		colors = ButtonDefaults.buttonColors(
			backgroundColor = color
		),
		modifier = Modifier
			.width(280.dp)
			.height(60.dp),
		shape = RoundedCornerShape(70.dp)

	) {
		Box(
			modifier = Modifier
				.width(266.dp)
				.height(50.dp)
//				.border(
//					width = 1.dp,
//					color = Color.White,
//					shape = RoundedCornerShape(70.dp)
//				)
		) {
			Text(
				text = text,
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
fun PageNav(
	nextSurveyClick: () -> Unit = {},
	isLeft: Boolean = true
) {
	Button(
		onClick = nextSurveyClick,
		colors = ButtonDefaults.buttonColors(
			backgroundColor = Color.Transparent
		),
		elevation = ButtonDefaults.elevation(0.dp)
	) {
		Row() {
			if (!isLeft) PageNavText("다음으로 넘어가기")


			Image(
				painterResource(
					id = if (isLeft) R.drawable.page_previous else R.drawable.page_next
				),
				contentDescription = "page nav button",
				modifier = Modifier
					.height(22.dp)
					.width(22.dp)
			)

			if (isLeft) PageNavText("이전으로 돌아가기")
		}
	}
}

@Composable
fun PageNavText(
	text: String
) {
	Text(
		text = text,
		color = gray_button_before,
		fontSize = 15.sp
	)
}

@Preview
@Composable
fun PreviewResultButton() {
	Column {
		ResultButton(
			text = "오늘의 와인 확인하기",
			color = gray_button_before
		)
		ResultButton(
			text = "오늘의 와인 확인하기",
			color = wine_button
		)
		PageNav(isLeft = true)
		PageNav(isLeft = false)
	}
}
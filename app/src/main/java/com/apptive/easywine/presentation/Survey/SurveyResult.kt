package com.apptive.easywine.presentation.Survey

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.apptive.easywine.R
import com.apptive.easywine._const.NetworkConst.IMAGE_URL
import com.apptive.easywine.presentation.components.ResultButton
import com.apptive.easywine.ui.theme.wine_button

@Composable
fun SurveyResultContent(
	viewModel: SurveyViewModel,
	onClickHome: () -> Unit = {},
) {
	LazyColumn(
		horizontalAlignment = Alignment.CenterHorizontally,
		modifier = Modifier
			.background(Color.White)
	) {
		item {
			Row(
				verticalAlignment = Alignment.CenterVertically,
				modifier = Modifier
					.background(Color.White)
			) {

//				WinePageNav(isLeft = true)
				Spacer(Modifier.size(80.dp))

				AsyncImage(
					model = ImageRequest.Builder(LocalContext.current)
						.data(IMAGE_URL + "${viewModel.recommendedWine.id}")
						.crossfade(true)
						.build(),
					contentDescription = "wine image",
					placeholder = painterResource(id = R.drawable.wine_img),
					contentScale = ContentScale.Crop,
					modifier = Modifier
						.width(50.dp)
						.background(Color.White)
						.height(200.dp),
				)

				Spacer(Modifier.size(80.dp))
//				WinePageNav(isLeft = false)
			}
			Spacer(Modifier.size(20.dp))

			Heart(viewModel.recommendedWine._like) { viewModel.setWineLiked(it) }

			Spacer(Modifier.size(30.dp))
			Text(
				text = viewModel.recommendedWine.name,
				fontSize = 20.sp,
				fontWeight = FontWeight.Bold
			)
			Spacer(Modifier.size(35.dp))
			ResultRate(typeText = "바디", typeRate = viewModel.recommendedWine.body)
			Spacer(Modifier.size(8.dp))
			ResultRate(typeText = "산미", typeRate = viewModel.recommendedWine.acidity)
			Spacer(Modifier.size(8.dp))
			ResultRate(typeText = "당도", typeRate = viewModel.recommendedWine.sugar)
			Spacer(Modifier.size(8.dp))
			ResultRate(typeText = "타닌", typeRate = viewModel.recommendedWine.tannin)
			Spacer(Modifier.size(50.dp))
//        PageNum(totalPage = 3, currentPage = 1)
			ResultButton(
				text = "홈으로 돌아가기",
				color = wine_button,
				onClick = onClickHome
			)
			Spacer(modifier = Modifier.height(50.dp))
		}
	}
}

@Composable
fun WinePageNav(
	onClick: () -> Unit = {},
	isLeft: Boolean = true,
) {
	Button(
		onClick = onClick,
		colors = ButtonDefaults.buttonColors(
			backgroundColor = Color.Transparent
		),
		elevation = ButtonDefaults.elevation(0.dp)
	) {
		Row() {

			Image(
				painterResource(
					id = if (isLeft) R.drawable.single_arrow_left else R.drawable.single_arrow_right
				),
				contentDescription = "page nav button",
				modifier = Modifier
					.height(31.dp)
					.width(31.dp)
			)

		}
	}
}

@Composable
private fun Heart(
	clicked: Boolean,
	onClick: (Boolean) -> Unit = {},
) {
	var clickedd by remember { mutableStateOf(clicked) }
	Button(
		onClick = {
			clickedd = !clickedd
			onClick(clickedd)
		},
		colors = ButtonDefaults.buttonColors(
			backgroundColor = Color.Transparent
		),
		elevation = ButtonDefaults.elevation(0.dp)
	) {
		Image(
			painterResource(
				id = if (clickedd) R.drawable.heart_empty else R.drawable.heart_full
			),
			contentDescription = "page nav button",
			modifier = Modifier
				.height(47.dp)
				.width(47.dp)
		)
	}
}

@Composable
fun ResultRate(
	typeText: String,
	typeRate: Int,
) {
	Row(
		verticalAlignment = Alignment.CenterVertically,
		horizontalArrangement = Arrangement.SpaceBetween
	) {
		when (typeRate) {
			1 -> {
				Text(
					text = typeText,
					fontSize = 15.sp
				)
				Spacer(Modifier.size(27.dp))
				Image(
					painter = painterResource(id = R.drawable.rate_one),
					modifier = Modifier
						.height(37.dp)
						.width(221.dp),
					contentDescription = null
				)
			}
			2 -> {
				Text(
					text = typeText,
					fontSize = 15.sp
				)
				Spacer(Modifier.size(27.dp))
				Image(
					painter = painterResource(id = R.drawable.rate_two),
					modifier = Modifier
						.height(37.dp)
						.width(221.dp),
					contentDescription = null
				)
			}
			3 -> {
				Text(
					text = typeText,
					fontSize = 15.sp
				)
				Spacer(Modifier.size(27.dp))
				Image(
					painter = painterResource(id = R.drawable.rate_three),
					modifier = Modifier
						.height(37.dp)
						.width(221.dp),
					contentDescription = null
				)
			}
			4 -> {
				Text(
					text = typeText,
					fontSize = 15.sp
				)
				Spacer(Modifier.size(27.dp))
				Image(
					painter = painterResource(id = R.drawable.rate_four),
					modifier = Modifier
						.height(37.dp)
						.width(221.dp),
					contentDescription = null
				)
			}
			5 -> {
				Text(
					text = typeText,
					fontSize = 15.sp
				)
				Spacer(Modifier.size(27.dp))
				Image(
					painter = painterResource(id = R.drawable.rate_four),
					modifier = Modifier
						.height(37.dp)
						.width(221.dp),
					contentDescription = null
				)
			}
		}
	}
}

@Composable
fun PageNum(
	totalPage: Int,
	currentPage: Int,
) {
	var page: String = currentPage.toString() + "/" + totalPage.toString()
	Text(
		text = page,
		fontSize = 15.sp
	)
}
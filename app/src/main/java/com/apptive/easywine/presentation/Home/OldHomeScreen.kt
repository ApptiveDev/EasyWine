//package com.apptive.easywine.presentation.Home
//
//import androidx.compose.foundation.BorderStroke
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyRow
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.Card
//import androidx.compose.material.OutlinedButton
//import androidx.compose.material.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.apptive.easywine.R
//
//@Composable
//fun OldHomeScreen() {
//	Column(
//		modifier = Modifier.background(Color.White)
//	) {
//
//		TodayOffer()
//
//		SurveyRecommend()
//
//		Spacer(Modifier.size(20.dp))
//
//		OtherServices()
//	}
//}
//
//@Composable
//fun TodayOffer() {
//	Box(
//		modifier = Modifier
//			.fillMaxWidth()
//			.wrapContentHeight()
//	) {
//		Image(
//			painterResource(id = R.drawable.home_bg),
//			contentDescription = "home background image",
//			contentScale = ContentScale.FillWidth,
//			modifier = Modifier
//				.fillMaxWidth()
//				.align(Alignment.TopCenter)
//		)
//
//		Column(
//			modifier = Modifier
//				.fillMaxWidth()
//				.align(Alignment.TopStart)
//				.padding(top = 80.dp),
//			horizontalAlignment = Alignment.CenterHorizontally
//		) {
//			Text(
//				text = "Today's offer",
//				color = Color.White,
//				fontWeight = FontWeight.Bold,
//				fontSize = 20.sp
//			)
//			Text(
//				text = "한병의 와인에는 어쩌구 저쩌구..",
//				color = Color.White,
//				fontWeight = FontWeight.Bold,
//				fontSize = 14.sp
//			)
//		}
//	}
//}
//
//@Composable
//fun SurveyRecommend() {
//	Row(
//		Modifier.fillMaxWidth(),
//		horizontalArrangement = Arrangement.SpaceAround,
//		verticalAlignment = Alignment.CenterVertically
//	) {
//		Column(
//			verticalArrangement = Arrangement.Center,
//			horizontalAlignment = Alignment.CenterHorizontally
//		) {
//			Text(
//				text = "오늘의 와인 추천",
//				color = Color(0xFF55212E),
//				fontWeight = FontWeight.ExtraBold,
//				fontSize = 18.sp
//			)
//
//			Spacer(modifier = Modifier.size(15.dp))
//
//			OutlinedButton(
//				onClick = {
//					// TODO navigate to survey
//				},
//				border = BorderStroke(1.5.dp, Color(0xFF55212E)),
//				modifier = Modifier.width(130.dp)
//
//			) {
//				Text(
//					text = "start",
//					color = Color(0xFF55212E),
//					fontWeight = FontWeight.Bold,
//					fontSize = 18.sp
//				)
//			}
//		}
//
//		Image(
//			painterResource(id = R.drawable.placeholder_circle),
//			contentDescription = "placeholder circle image",
//			modifier = Modifier.size(100.dp)
//		)
//	}
//}
//
//@Composable
//fun OtherServices() {
//	Column(
//		modifier = Modifier
//			.fillMaxWidth()
//	) {
//		Row(
//			modifier = Modifier
//				.fillMaxWidth()
//				.padding(horizontal = 30.dp, vertical = 20.dp),
//			horizontalArrangement = Arrangement.SpaceBetween
//		) {
//			Text(
//				text = "Other Services",
//				color = Color(0xFF55212E),
//				fontWeight = FontWeight.Bold,
//				fontSize = 18.sp
//			)
//
//			Row() {
//				Text(
//					text = "more",
//					color = Color(0xFF929292),
//					fontWeight = FontWeight.Bold,
//					fontSize = 18.sp
//				)
//				Image(
//					painterResource(id = R.drawable.right_double_shift),
//					contentDescription = "placeholder circle image",
//					modifier = Modifier.size(25.dp)
//				)
//			}
//		}
//
//		LazyRow() {
//			item{ Spacer(modifier = Modifier.size(20.dp)) }
//
//			repeat(4) { item{QCard()} }
//		}
//	}
//}
//
//@Composable
//fun QCard(
//	content: @Composable () -> Unit = {}
//) {
//	Column(
//		modifier = Modifier
//			.padding(vertical = 20.dp, horizontal = 10.dp),
//		verticalArrangement = Arrangement.spacedBy(20.dp)
//	) {
//		Card(
//			border = BorderStroke(1.dp, Color(0xFFEAEAEA)),
//			modifier = Modifier.size(250.dp, 150.dp),
//			shape = RoundedCornerShape(12.dp)
//		) {
//			content
//		}
//
//		OutlinedButton(
//			onClick = {
//				// TODO navigate to something
//			},
//			border = BorderStroke(1.5.dp, Color(0xFF55212E)),
//			modifier = Modifier.width(100.dp)
//
//		) {
//			Text(
//				text = "바로가기",
//				color = Color(0xFF55212E),
//				fontWeight = FontWeight.Bold,
//				fontSize = 12.sp
//			)
//		}
//
//	}
//}
//
//@Preview(widthDp = 360, heightDp = 720)
//@Composable
//fun PreviewHomeScreen() {
//	OldHomeScreen()
//}
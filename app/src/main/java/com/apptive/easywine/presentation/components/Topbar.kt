package com.apptive.easywine.presentation.components

import android.graphics.Paint.Align
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apptive.easywine.ui.theme.*


@Composable
fun TopBar(
	content: @Composable BoxScope.() -> Unit = {}
) {
	Box(
		modifier = Modifier
			.fillMaxWidth()
			.wrapContentHeight(),
	) {
		content()
	}

}

@Composable
fun TextTopBar(
	title: String,
	fontSize: Int,
	color: Color = gray_button
) {
	TopBar {
		Column(
			modifier = Modifier
				.background(color = gray_background)
				.fillMaxWidth()
				.height(91.dp)
		) {
			Spacer(modifier = Modifier.height(20.dp))
			Box(
				modifier = Modifier
					.fillMaxWidth()
					.fillMaxHeight()
			) {
				Text(
					text = title,
					fontFamily = notosanskr,
					fontSize = fontSize.sp,
					fontWeight = FontWeight.Medium,
					color = color,
					modifier = Modifier
						.align(Alignment.BottomCenter)
						.padding(bottom = 6.dp)
				)
				IconButton(
					onClick = { /*TODO*/ },
					modifier = Modifier
						.align(Alignment.TopEnd)
						.padding(end = 22.dp)
				) {
					Icon(
						imageVector = Icons.Filled.Menu,
						contentDescription = "Menu",
						tint = gray_button_before,
						modifier = Modifier
							.size(43.dp)
					)
				}
			}
		}
	}
}

@Composable
fun SnackTopBar(
	title: String,
	fontSize: Int,
	color: Color = gray_button
){
	TopBar{
		Column(
			modifier = Modifier
				.background(color = gray_background)
				.fillMaxWidth()
				.height(91.dp)
		) {
			Spacer(modifier = Modifier.height(20.dp))
			Box(
				modifier = Modifier
					.fillMaxWidth()
					.fillMaxHeight()
			) {
				IconButton(
					onClick = { /*TODO*/ },
					modifier = Modifier
						.align(Alignment.TopStart)
						.padding(start = 20.dp)

				) {
					Icon(
						imageVector = Icons.Filled.KeyboardDoubleArrowLeft,
						contentDescription = "Menu",
						tint = gray_button_before,
						modifier = Modifier.size(45.dp)
					)
				}
				Text(
					text = title,
					fontFamily = notosanskr,
					fontSize = fontSize.sp,
					fontWeight = FontWeight.Medium,
					color = color,
					modifier = Modifier
						.align(Alignment.BottomCenter)
						.padding(bottom = 6.dp)
				)
				IconButton(
					onClick = { /*TODO*/ },
					modifier = Modifier
						.align(Alignment.TopEnd)
						.padding(end = 22.dp)
				) {
					Icon(
						imageVector = Icons.Filled.Menu,
						contentDescription = "Menu",
						tint = gray_button_before,
						modifier = Modifier
							.size(43.dp)
							.align(Alignment.TopEnd)
					)
				}
			}
		}
	}
}

@Composable
fun LogoTopBar(
	title: String,
	fontSize: Int,
	color: Color
){
	Column(
		horizontalAlignment = Alignment.CenterHorizontally,
	){
		Spacer(modifier = Modifier.height(55.dp))
		Text(
			text = title,
			fontFamily = notosanskr,
			fontSize = fontSize.sp,
			fontWeight = FontWeight(824),
			color = color,
			modifier = Modifier
		)
		Spacer(modifier = Modifier.height(10.dp))

	}
}

@Preview
@Composable
fun PreviewTopBar() {
	Column {
		TopBar()
		TextTopBar(title = "오늘의 와인 추천", 18)
		SnackTopBar(title = "오늘의 와인 추천", 18)
		LogoTopBar(title = "EASY WINE", fontSize = 24, color = wine_button)
	}

}
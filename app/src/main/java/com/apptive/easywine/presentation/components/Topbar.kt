package com.apptive.easywine.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.apptive.easywine.R


@Composable
fun TopBar(
	content: @Composable BoxScope.() -> Unit = {}
) {
	Box(
		modifier = Modifier
			.fillMaxWidth()
			.wrapContentHeight(),
	) {
		Image(
			painterResource(id = R.drawable.top_banner),
			contentDescription = "top bar image",
			contentScale = ContentScale.FillWidth,
			modifier = Modifier
				.fillMaxWidth()
				.align(Alignment.TopCenter)
		 )
		content()
	}

}

@Composable
fun TextTopBar(
	title: String,
	fontSize: Int,
	color: Color = Color.White
) {
	TopBar {
		Text(
			text = title,
			fontFamily = FontFamily.SansSerif,
			fontSize = fontSize.sp,
			fontWeight = FontWeight(824),
			color = color,
			modifier = Modifier
				.padding(bottom = 10.dp)
				.align(Alignment.BottomCenter)
		)
	}
}

@Composable
fun SnackTopBar(
	title: String,
	fontSize: Int,
	color: Color = Color.White
){
	TopBar{
		Column() {
			Spacer(modifier = Modifier.height(20.dp))
			Row(
				modifier = Modifier
					.fillMaxWidth()
					.wrapContentSize(Alignment.Center)
			) {
				IconButton(onClick = { /*TODO*/ }) {
					Icon(
						imageVector = Icons.Filled.KeyboardDoubleArrowLeft,
						contentDescription = "Menu",
						tint = Color.White,
						modifier = Modifier
							.size(45.dp)
					)
				}
				Spacer(modifier = Modifier.width(70.dp))
				Text(
					text = title,
					fontFamily = FontFamily.SansSerif,
					fontSize = fontSize.sp,
					fontWeight = FontWeight(824),
					color = color,
					modifier = Modifier
						.padding(top = 20.dp)
				)
				Spacer(modifier = Modifier.width(70.dp))
				IconButton(onClick = { /*TODO*/ }) {
					Icon(
						imageVector = Icons.Filled.Menu,
						contentDescription = "Menu",
						tint = Color.White,
						modifier = Modifier
							.size(43.dp)
					)
				}
			}
		}
	}
}

@Preview
@Composable
fun PreviewTopBar() {
	Column {
		TopBar()
		TextTopBar(title = "EASY WINE",27)
		SnackTopBar(title = "EASY WINE",27)
	}
}
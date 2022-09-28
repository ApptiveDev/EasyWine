package com.apptive.easywine.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
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
	color: Color = Color.White
) {
	TopBar {
		Text(
			text = title,
			fontFamily = FontFamily.SansSerif,
			fontSize = 27.sp,
			fontWeight = FontWeight(824),
			color = color,
			modifier = Modifier
				.padding(bottom = 10.dp)
				.align(Alignment.BottomCenter)
		)
	}
}

@Preview
@Composable
fun PreviewTopBar() {
	Column {
		TopBar()
		TextTopBar(title = "EASY WINE")
	}
	
}
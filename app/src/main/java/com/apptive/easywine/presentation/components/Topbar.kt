package com.apptive.easywine.presentation.components

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apptive.easywine.ui.theme.gray_button
import com.apptive.easywine.ui.theme.gray_button_before
import com.apptive.easywine.ui.theme.notosanskr


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
			modifier = Modifier.align(Alignment.TopEnd)
		) {
			Spacer(modifier = Modifier.height(20.dp))
			Row(
				modifier = Modifier
					.padding(end = 9.dp)
					.fillMaxWidth()
					.wrapContentSize(Alignment.TopEnd)
			) {
				Text(
					text = title,
					fontFamily = notosanskr,
					fontSize = fontSize.sp,
					fontWeight = FontWeight.Medium,
					color = color,
					modifier = Modifier
						.padding(top = 20.dp)
				)
				Spacer(modifier = Modifier.width(70.dp))
				IconButton(onClick = { /*TODO*/ }) {
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
						tint = gray_button_before,
						modifier = Modifier
							.size(45.dp)
					)
				}
				Spacer(modifier = Modifier.width(70.dp))
				Text(
					text = title,
					fontFamily = notosanskr,
					fontSize = fontSize.sp,
					fontWeight = FontWeight.Medium,
					color = color,
					modifier = Modifier
						.padding(top = 20.dp)
				)
				Spacer(modifier = Modifier.width(70.dp))
				IconButton(onClick = { /*TODO*/ }) {
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

@Preview
@Composable
fun PreviewTopBar() {
	Column {
		TopBar()
		TextTopBar(title = "EASY WINE", 27)
		SnackTopBar(title = "EASY WINE", 27)
	}

}
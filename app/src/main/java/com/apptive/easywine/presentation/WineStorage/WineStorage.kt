package com.apptive.easywine.presentation.Home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.apptive.easywine.R
import com.apptive.easywine.domain.model.StorageWine
import com.apptive.easywine.enums.Side
import com.apptive.easywine.enums.StorageWineInfo.Companion.fromCountryName
import com.apptive.easywine.presentation.Survey.SurveyResultContent
import com.apptive.easywine.presentation.WineStorage.WineStorageViewModel
import com.apptive.easywine.presentation.components.*
import com.apptive.easywine.ui.theme.storage_background


@Composable
fun WineStorage(
	navController: NavController = rememberNavController(),
	upPress: () -> Unit = {},
	onClickDrawer: () -> Unit = {},
	viewModel: WineStorageViewModel = hiltViewModel(),
) {

	Column() {
		var selected by remember { mutableStateOf(Side.LEFT) }
		LazyColumn(
			modifier = Modifier
				.fillMaxSize()
				.background(storage_background)
		) {
			item {
				SnackTopBar(title = "와인창고", 18, onClickDrawer = onClickDrawer)
				Column(
					modifier = Modifier
						.fillMaxWidth()
						.height(120.dp)
						.background(color = Color.White)
						.wrapContentSize(Alignment.Center)
				) {
					Spacer(modifier = Modifier.height(45.dp))

					Row(horizontalArrangement = Arrangement.Center) {
						StorageDividedButton(
							leftText = "전체보기",
							rightText = "좋아요만 보기",
							selected = selected,
							leftOnClick = {
								selected = Side.LEFT
								viewModel.getWineList()
							},
							rightOnClick = {
								selected = Side.RIGHT
								viewModel.getLikedWineList()
							}
						)
					}


					Spacer(modifier = Modifier.height(30.dp))
				}
				Spacer(Modifier.height(15.dp))
			}


			if (selected == Side.LEFT) {
				viewModel.wineList.forEach {
					item { ShowWineList(it = it) }
				}
			} else {
				viewModel.wineLikedList.forEach {
					item { ShowWineList(it = it) }
				}
			}
		}
	}
}

@Composable
fun ShowWineList(
	it: StorageWine,
) {
	Row(horizontalArrangement = Arrangement.Start) {

		var date = it.localDate.split("-")
		var time = it.localTime.split(":")

		StorageDate(
			month = date[1],
			day = date[2],
			hour = time[0],
			minute = time[1]
		)
	}

	StorageWineList(
		wine_id = it.id,
		winename = it.name,
		variety = it.variety,
		country = it.country,
		countryFlag = fromCountryName(it.country)?.nationalFlag ?: R.drawable.italy
	)

	Spacer(modifier = Modifier.height(15.dp))
}

@Preview
@Composable
fun PreviewWineStorage() {
	WineStorage()
}
package com.apptive.easywine.presentation.Home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.apptive.easywine.R
import com.apptive.easywine.enums.Side
import com.apptive.easywine.presentation.Survey.SurveyResultContent
import com.apptive.easywine.presentation.components.*
import com.apptive.easywine.presentation.viewmodel.DegreeViewModel
import com.apptive.easywine.ui.theme.gray_background
import com.apptive.easywine.ui.theme.storage_background
import kotlinx.coroutines.CoroutineScope


@Composable
fun WineStorage(
    navController: NavController = rememberNavController(),
    upPress: () -> Unit = {},
    onClickDrawer: () -> Unit = {}
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
                ){
                    Spacer(modifier = Modifier.height(45.dp))
                    Row(horizontalArrangement = Arrangement.Center) {
                        StorageDividedButton(
                            leftText = "전체보기",
                            rightText = "좋아요만 보기",
                            selected = selected,
                            leftOnClick = { selected = Side.LEFT },
                            rightOnClick = { selected = Side.RIGHT }
                        )
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                }
                Spacer(Modifier.height(15.dp))
            }
            if (selected == Side.LEFT) {
                items(10) {
                    Row(horizontalArrangement = Arrangement.Start){
                        StorageDate(
                            month = "12",
                            day = "28",
                            hour = "20",
                            minute = "24"
                        )
                    }

                    StorageWineList(
                        wine_id = R.drawable.pascua_sweet_rose_wine,
                        winename = "플라네타, 샤르도네",
                        variety = "샤르도네",
                        country = "이탈리아",
                        countryFlag = R.drawable.italy
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                }
            }

            else{


            }


//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,
//        modifier = Modifier
//            .fillMaxSize()
//            .background(storage_background)
//            .verticalScroll(rememberScrollState())
//    ){
//        SnackTopBar(title = "와인창고",18, onClickDrawer = onClickDrawer)
//        StorageButtonContent()
//        StorageDate("11/01")
//        Spacer(Modifier.height(20.dp))
//        StorageWineList(R.drawable.pascua_sweet_rose_wine,"파스쿠아 스윗 로제", "피노바앙코, 샤르도네", "이탈리아", R.drawable.italy)
//        Spacer(Modifier.height(15.dp))
//        StorageWineList(R.drawable.villa_jolanda_moscato_dasti,"빌라 욜란다 모스카토 다스티", "모스카토", "이탈리아", R.drawable.italy)
//        Spacer(Modifier.height(50.dp))
//
//        StorageDate("11/03")
//        Spacer(Modifier.height(20.dp))
//        StorageWineList(R.drawable.pascua_sweet_rose_wine,"파스쿠아 스윗 로제", "피노바앙코, 샤르도네", "이탈리아", R.drawable.italy)
//        Spacer(Modifier.height(15.dp))
//        StorageWineList(R.drawable.pascua_sweet_rose_wine,"파스쿠아 스윗 로제", "피노바앙코, 샤르도네", "이탈리아", R.drawable.italy)
//        Spacer(Modifier.height(15.dp))
//        StorageWineList(R.drawable.villa_jolanda_moscato_dasti,"빌라 욜란다 모스카토 다스티", "모스카토", "이탈리아", R.drawable.italy)
//        Spacer(Modifier.height(15.dp))
//
//    }

        }
    }
}

@Preview
@Composable
fun PreviewWineStorage(){
    WineStorage()
}
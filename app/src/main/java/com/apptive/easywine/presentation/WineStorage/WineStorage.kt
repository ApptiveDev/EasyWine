package com.apptive.easywine.presentation.Home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apptive.easywine.R
import com.apptive.easywine.presentation.Survey.SurveyResultContent
import com.apptive.easywine.presentation.components.SnackTopBar
import com.apptive.easywine.presentation.components.StorageButtonContent
import com.apptive.easywine.presentation.components.StorageDate
import com.apptive.easywine.presentation.components.StorageWineList
import com.apptive.easywine.presentation.viewmodel.DegreeViewModel
import com.apptive.easywine.ui.theme.gray_background
import com.apptive.easywine.ui.theme.storage_background
import kotlinx.coroutines.CoroutineScope


@Preview
@Composable
fun SurveyResult(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    scope: CoroutineScope = rememberCoroutineScope()
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(storage_background)
            .verticalScroll(rememberScrollState())
    ){
        SnackTopBar(title = "와인창고",18,scope = scope, scaffoldState = scaffoldState,)
        StorageButtonContent()
        StorageDate("11/01")
        Spacer(Modifier.height(20.dp))
        StorageWineList(R.drawable.pascua_sweet_rose_wine,"파스쿠아 스윗 로제", "피노바앙코, 샤르도네", "이탈리아", R.drawable.italy)
        Spacer(Modifier.height(15.dp))
        StorageWineList(R.drawable.villa_jolanda_moscato_dasti,"빌라 욜란다 모스카토 다스티", "모스카토", "이탈리아", R.drawable.italy)
        Spacer(Modifier.height(50.dp))

        StorageDate("11/03")
        Spacer(Modifier.height(20.dp))
        StorageWineList(R.drawable.pascua_sweet_rose_wine,"파스쿠아 스윗 로제", "피노바앙코, 샤르도네", "이탈리아", R.drawable.italy)
        Spacer(Modifier.height(15.dp))
        StorageWineList(R.drawable.pascua_sweet_rose_wine,"파스쿠아 스윗 로제", "피노바앙코, 샤르도네", "이탈리아", R.drawable.italy)
        Spacer(Modifier.height(15.dp))
        StorageWineList(R.drawable.villa_jolanda_moscato_dasti,"빌라 욜란다 모스카토 다스티", "모스카토", "이탈리아", R.drawable.italy)
        Spacer(Modifier.height(15.dp))

    }

}

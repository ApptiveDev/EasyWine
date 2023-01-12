package com.apptive.easywine.presentation.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apptive.easywine.presentation.navgation.Screen
import com.apptive.easywine.ui.theme.*


@Composable
fun NavigationDrawer(
    currentScreen: String,
    itemClick: (String) -> Unit
) {

    val menuList = listOf(
        NavigationDrawerItem(
            isSelected = currentScreen == Screen.HomeScreen.route,
            title = "홈",
            route = Screen.HomeScreen.route
        ),
        NavigationDrawerItem(
            isSelected = currentScreen == Screen.SurveyScreen.route,
            title = "오늘의 와인 추천",
            route = Screen.SurveyScreen.route
        ),
        NavigationDrawerItem(
            isSelected = currentScreen == Screen.StorageScreen.route,
            title = "나만의 와인 창고",
            route = Screen.StorageScreen.route
        ),
    )
    
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = gray_background),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        items(menuList) { item ->
            DrawerBody(item, {itemClick(item.route)})
        }
    }
}

data class NavigationDrawerItem(
    val isSelected: Boolean,
    val title: String,
    val route: String,
)

@Composable
private fun DrawerBody(
    item: NavigationDrawerItem,
    itemClick: () -> Unit,
) {
    val texColor = if (item.isSelected) Color.White else gray_button_before
    val backgroundColor = if (item.isSelected) gray_button_before else Color.Transparent

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        color = backgroundColor,
        shape = MaterialTheme.shapes.small
    ) {
        Row(
            modifier = Modifier
                .clickable { itemClick() }
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = item.title,
                fontFamily = notosanskr,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                color = texColor,
                modifier = Modifier
                    .padding(start = 35.dp)
            )
        }
    }
}
package com.apptive.easywine.presentation.components

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
    currentScreen: Screen,
    itemClick: (String) -> Unit
) {
    val menuList = createDrawerItem(currentScreen)
    
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = gray_background),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        items(menuList) { item ->
            DrawerBody(item, itemClick)
        }
    }
}

@Composable
private fun createDrawerItem(currentScreen: Screen) = listOf(
    NavigationDrawerItem(
        isSelected = currentScreen == Screen.HomeScreen,
        title = "홈"
    ),
    NavigationDrawerItem(
        isSelected = currentScreen == Screen.SurveyScreen,
        title = "오늘의 와인 추천"
    ),
    NavigationDrawerItem(
        isSelected = currentScreen == Screen.StorageScreen,
        title = "나만의 와인 창고"
    ),
)

data class NavigationDrawerItem(
    val isSelected: Boolean,
    val title: String
)

@Composable
private fun DrawerBody(
    item: NavigationDrawerItem,
    itemClick: (String) -> Unit,
) {
    NavigationMenuItem(item = item) {
        itemClick(item.title)
    }
}

@Composable
fun NavigationMenuItem(
    item: NavigationDrawerItem,
    itemClick: () -> Unit
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
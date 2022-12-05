package com.apptive.easywine.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apptive.easywine.ui.theme.gray_button
import com.apptive.easywine.ui.theme.notosanskr

@Composable
fun StorageDate(
    date: String
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(color = Color.White),
        shape = RectangleShape,
        elevation = 3.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(color = Color.White),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = date,
                fontFamily = notosanskr,
                fontSize = 15.sp
            )
            Spacer(modifier = Modifier.width(3.dp))
            Text(
                text = "추천받은 와인",
                fontFamily = notosanskr,
                fontSize = 15.sp
            )
        }
    }
}

@Preview
@Composable
fun PreviewStorageDate() {
    StorageDate("11/01")
}


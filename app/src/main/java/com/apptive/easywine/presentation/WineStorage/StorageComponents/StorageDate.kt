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
    month: String,
    day : String,
    hour: String,
    minute: String
){
    Row(
        modifier = Modifier.height(35.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = month + "/" + day,
            fontFamily = notosanskr,
            fontSize = 15.sp
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = hour + ":" + minute,
            fontFamily = notosanskr,
            fontSize = 15.sp
        )
    }
}

@Preview
@Composable
fun PreviewStorageDate() {
    StorageDate("11", "01", "13", "57")
}


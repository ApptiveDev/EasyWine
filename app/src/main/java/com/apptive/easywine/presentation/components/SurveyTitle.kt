package com.apptive.easywine.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.apptive.easywine.ui.theme.gray_button
import com.apptive.easywine.ui.theme.gray_button_before
import com.apptive.easywine.ui.theme.gray_text
import com.apptive.easywine.ui.theme.wine_button

@Composable
fun SurveyTitle(
    title_front: String,
    condition: String,
    title_back: String
){
    Row(){
        Text(
            text = title_front,
            color = gray_text,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = condition,
            color = wine_button,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = title_back,
            color = gray_text,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )
    }

}

@Preview
@Composable
    fun PreviewSurveyTitle() {
    SurveyTitle("오늘의 와인을 위한 ","바디감 ","질문이에요.")
}
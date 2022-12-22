package com.apptive.easywine.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apptive.easywine.enums.Side
import com.apptive.easywine.presentation.viewmodel.YesOrNoButtonViewModel
import com.apptive.easywine.presentation.viewmodel.interfaces.IYesOrNoButtonViewModel
import com.apptive.easywine.ui.theme.notosanskr
import com.apptive.easywine.ui.theme.wine_button
import com.apptive.easywine.ui.theme.wine_button_alpha75

@Composable
fun SurveyYesOrNo(
    question: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
//			.background(Color.White) // 추후 삭제
            .padding(vertical = 20.dp)
            .padding(horizontal = 35.dp)
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        YesOrNoQuestion(question)
        YesOrNoButton(YesOrNoViewMode = YesOrNoButtonViewModel())
    }

}

@Composable
fun YesOrNoQuestion(
    title: String,
    color: Color = Color.Black
) {
    Column() {
        Text(
            text = title,
            fontFamily = FontFamily.SansSerif,
            fontSize = 15.sp,
            fontWeight = FontWeight(450),
            color = color
        )
        Spacer(modifier = Modifier.height(22.dp))
    }
}

@Composable
fun YesOrNoButton(
    YesOrNoViewMode: IYesOrNoButtonViewModel
){
    var selected = YesOrNoViewMode.isYes

    YesOrNoDividedButton(
        leftText = "예",
        rightText = "아니요",
        selected = selected.value,
        leftOnClick = { selected.value = Side.LEFT },
        rightOnClick = { selected.value = Side.RIGHT }
    )
}

@Composable
private fun YesOrNoDividedButton(
    leftOnClick: () -> Unit = {},
    rightOnClick: () -> Unit = {},
    leftText: String = "",
    rightText: String = "",
    selected: Side = Side.LEFT
){
    Row(){
        YesOrNoCusttomButton(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp, 0.dp, 0.dp, 8.dp)),
            selected = (selected == Side.LEFT),
            onClick = leftOnClick,
            text = leftText,
            shape = RoundedCornerShape(8.dp, 0.dp, 0.dp, 8.dp)
        )
        YesOrNoCusttomButton(
            modifier = Modifier
                .clip(RoundedCornerShape(0.dp, 8.dp, 8.dp, 0.dp)),
            selected = (selected == Side.RIGHT),
            onClick = rightOnClick,
            text = rightText,
            shape = RoundedCornerShape(0.dp, 8.dp, 8.dp, 0.dp)
        )
    }
}


@Composable
fun YesOrNoCusttomButton(
    modifier: Modifier = Modifier,
    selected: Boolean = true,
    text: String = "",
    shape: Shape,
    onClick: () -> Unit = {}
){
    val textColor = if (selected) Color.White else wine_button
    val boxColor = if (selected) wine_button_alpha75 else Color.White

    Box(modifier = modifier
        .width(130.dp)
        .height(40.dp)
        .border(width = 1.dp, shape = shape, color = wine_button)
        .background(color = boxColor)
        .clickable { onClick() },
        contentAlignment = Alignment.Center
    ){
        Text(
            fontFamily = notosanskr,
            text = text,
            color = textColor,
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview
@Composable
fun PreviewSurveyYesOrNo() {
    SurveyYesOrNo("Q1. 집에서 간단하게 마실 수 있는 와인을 원해요.")
}

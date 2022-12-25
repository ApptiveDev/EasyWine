package com.apptive.easywine.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.apptive.easywine.enums.Side
import com.apptive.easywine.enums.SurveyLevel
import com.apptive.easywine.presentation.Login.LoginViewModel
import com.apptive.easywine.presentation.WineStorage.IWineStorageViewModel
import com.apptive.easywine.presentation.WineStorage.WineStorageViewModel
import com.apptive.easywine.presentation.viewmodel.DegreeViewModel
import com.apptive.easywine.presentation.viewmodel.interfaces.IDegreeViewModel
import com.apptive.easywine.ui.theme.gray_button
import com.apptive.easywine.ui.theme.notosanskr
import com.apptive.easywine.ui.theme.wine_button

@Composable
fun StorageButtonContent(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(color = Color.White)
            .wrapContentSize(Alignment.Center),
        verticalAlignment = Alignment.CenterVertically
    ){
        val StorageViewMode = viewModel<WineStorageViewModel>()
        StorageButton(StorageViewMode)
    }
}
@Composable
fun StorageButton(
    StorageViewMode: WineStorageViewModel
){
    var selected = StorageViewMode.isAll

    StorageDividedButton(
        leftText = "전체보기",
        rightText = "좋아요만 보기",
        selected = selected.value,
        leftOnClick = { selected.value = Side.LEFT },
        rightOnClick = { selected.value = Side.RIGHT }
    )
}

@Composable
private fun StorageDividedButton(
    leftOnClick: () -> Unit = {},
    rightOnClick: () -> Unit = {},
    leftText: String = "",
    rightText: String = "",
    selected: Side = Side.LEFT
){
    Row(){
        StorageCusttomButton(
            modifier = Modifier
                .clip(RoundedCornerShape(13.dp, 0.dp, 0.dp, 13.dp)),
            selected = (selected == Side.LEFT),
            onClick = leftOnClick,
            text = leftText,
            shape = RoundedCornerShape(13.dp, 0.dp, 0.dp, 13.dp)
        )
        Spacer(modifier = Modifier.width(23.dp))
        StorageCusttomButton(
            modifier = Modifier
                .clip(RoundedCornerShape(0.dp, 13.dp, 13.dp, 0.dp)),
            selected = (selected == Side.RIGHT),
            onClick = rightOnClick,
            text = rightText,
            shape = RoundedCornerShape(0.dp, 13.dp, 13.dp, 0.dp)
        )
    }
}


@Composable
fun StorageCusttomButton(
    modifier: Modifier = Modifier,
    selected: Boolean = true,
    text: String = "",
    shape: Shape,
    onClick: () -> Unit = {}
){
    val border = if (selected) wine_button else gray_button
    val textColor = if (selected) wine_button else gray_button

    Box(modifier = modifier
        .width(130.dp)
        .height(40.dp)
        .border(width = 1.dp, shape = shape, color = border)
        .clip(RoundedCornerShape(20))
        .background(color = Color.White)
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
fun PreviewStorageButtons() {
   StorageButtonContent()
}
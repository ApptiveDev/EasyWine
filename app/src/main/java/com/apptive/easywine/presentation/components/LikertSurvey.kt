package com.apptive.easywine.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apptive.easywine.R
import com.apptive.easywine.enums.Degree

@Composable
fun LikertSurvey(
) {
    RoomCreateContent {
        question("Q1. 어느 정도의 당도를 원하세요?  ")
        answer()
        SideState("엷다","부드럽다")
    }

}

@Composable
private fun RoomCreateContent(
    content: @Composable() (ColumnScope.() -> Unit)
) {
    Box(
        modifier = Modifier
            .height(200.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            content = content
        )
    }
}


@Composable
fun question(
    title: String,
    color: Color = Color(91,91,91)
) {
    Column(){
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = title,
                fontFamily = FontFamily.SansSerif,
                fontSize = 15.sp,
                fontWeight = FontWeight(400),
                color = color
            )
            Spacer(modifier = Modifier.width(3.dp))
            Icon(painter = painterResource(id = R.drawable.circle_question),
                contentDescription = null,
            modifier = Modifier.size(15.dp)
            )
        }
        Spacer(modifier = Modifier.height(38.dp))
    }
}


@Composable
private fun answer(
    modifier: Modifier = Modifier
) {
    var selectedValue = remember { mutableStateOf<Degree>(Degree.None) }
    Column() {
        Row(
            modifier = Modifier
                .selectableGroup()
            ,verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Spacer(modifier = Modifier.width(23.dp))
            Degree.values().forEach { label ->
                if (Degree.None != label) {
                    Row(
                        modifier = Modifier
                            .selectable(
                                selected = (selectedValue.value == label),
                                onClick = { selectedValue.value = label },
                                role = Role.RadioButton
                            ),
                    ) {
                        Icon(
                            painter = painterResource(
                                id = if (selectedValue.value == label) R.drawable.check_circle_kit
                                else R.drawable.uncheck
                            ), contentDescription = null,
                            tint = if(selectedValue.value == label) Color(214, 82, 97) else Color(146, 146, 146),
                            modifier = if (label == Degree.dg1 || label == Degree.dg5) Modifier.size(
                                41.dp
                            )
                            else if (label == Degree.dg2 || label == Degree.dg4) Modifier.size(33.dp)
                            else Modifier.size(23.dp)

                        )
                        Spacer(modifier = Modifier.width(23.dp))


                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}


@Composable
fun SideState(
    leftState: String,
    rightState: String,
    color: Color = Color(91,91,91)
){
    Row(
        modifier = Modifier
            .width(272.dp)
            .height(20.dp)
    ){
        Spacer(modifier = Modifier.width(5.dp))
        Row(
            modifier = Modifier
                .width(136.dp)
                .height(20.dp)
        ){
            Text(
                text = leftState,
                fontFamily = FontFamily.SansSerif,
                fontSize = 15.sp,
                fontWeight = FontWeight(400),
                color = color,
                textAlign = TextAlign.Start
            )
        }
        Row(
            modifier = Modifier
                .width(136.dp)
                .height(20.dp),
            horizontalArrangement = Arrangement.End
        ){
            Text(
                text = rightState,
                fontFamily = FontFamily.SansSerif,
                fontSize = 15.sp,
                fontWeight = FontWeight(400),
                color = color,
                textAlign = TextAlign.End
            )
        }
    }
}


@Preview
@Composable
fun PreviewHome() {
    LikertSurvey()
}

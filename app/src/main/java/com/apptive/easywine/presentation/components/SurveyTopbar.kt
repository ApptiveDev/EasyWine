package com.apptive.easywine.presentation.components


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apptive.easywine.R
import com.apptive.easywine.ui.theme.*

@Composable
fun SurveyProgressBar(prog_percent : Float){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "응답 진행률",
            color = gray_button,
            fontSize = 15.sp,
            fontWeight = FontWeight.ExtraBold
        )
        LinearProgressIndicator(
            progress = prog_percent,
            modifier = Modifier
                .width(195.dp)
                .height(6.dp)
                .clip(shape = RoundedCornerShape(30.dp)),
            backgroundColor = progressbar_before,
            color = wine_main
        )
        Text(
            text = (prog_percent * 100).toInt().toString() + "%",
            fontSize = 13.sp,
            color = wine_main
        )
    }
}

@Composable
fun SurveyCategory(
    number: Int,
    state: String, ///done,now,yet 세 가지로 분류
    textKor: String,
    textEng: String
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (state){
            "done" -> {
                SurveyCategoryCircle(number = number, color = wine_main, state = state)
                Spacer(modifier = Modifier.size(4.dp))
                SurveyCategoryText(firstLine = textKor, secondLine = textEng, firstColor = gray_text, secondColor = gray_button_before)
            }
            "now" -> {
                SurveyCategoryCircle(number = number, color = wine_button, state = state)
                Spacer(modifier = Modifier.size(4.dp))
                SurveyCategoryText(firstLine = textKor, secondLine = textEng, firstColor = wine_main, secondColor = wine_main)
            }
            "yet" -> {
                SurveyCategoryCircle(number = number, color = gray_button_before, state = state)
                Spacer(modifier = Modifier.size(4.dp))
                SurveyCategoryText(firstLine = textKor, secondLine = textEng, firstColor = gray_button_before, secondColor = gray_button_before)
            }
        }
    }

}

@Composable
fun SurveyCategoryCircle(
    number: Int,
    color: Color,
    state: String
){
    if (state == "now") {
        Box(
            modifier = Modifier
                .width(24.dp)
                .height(24.dp)
                .clip(CircleShape)
                .background(color = color)
        ){
            Text(
                text = number.toString(),
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
    } else {
        Box(
            modifier = Modifier
                .width(24.dp)
                .height(24.dp)
                .border(
                    width = 1.dp,
                    color = color,
                    shape = CircleShape
                )
        ){
            if (state == "done") {
                Image(
                    painterResource(id = R.drawable.check_icon),
                    contentDescription = "is done",
                    modifier = Modifier
                        .height(8.6.dp)
                        .width(10.7.dp)
                        .align(Alignment.Center)
                        .background(Color.Transparent)
                )
            } else {
                Text(
                    text = number.toString(),
                    color = color,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
    }

    }
}

@Composable
fun SurveyCategoryText(
    firstLine: String,
    secondLine: String,
    firstColor: Color,
    secondColor: Color
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = firstLine,
            color = firstColor,
            fontSize = 14.sp
        )
        Text(
            text = secondLine,
            color = secondColor.copy(alpha = 0.5f),
            fontSize = 14.sp
        )
    }
}

@Composable
fun SurveyLine(
    color: Color
){
    Canvas(
        modifier = Modifier
            .width(24.dp)
            .height(24.dp)
    ){
        val canvasWidth = size.width
        drawLine(
            start = Offset(x = 0f, y = 0f),
            end = Offset(x = canvasWidth, y = 0f),
            strokeWidth = 2F,
            color = color
        )
    }
}

@Composable
fun BottomShadow(
    alpha: Int = 255,
    height: Dp = 8.dp
) {
    Box(
        modifier = Modifier
        .fillMaxWidth()
        .height(height)
        .background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    gray_shadow,
                    Color.Transparent
                )
            )
        )
    )
}

@Composable
fun SurveyTopbar() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(20.dp) )
        SurveyProgressBar(prog_percent = 0.7f)
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            SurveyCategory(number = 1, state = "done", textKor = "맛", textEng = "flavor")
            SurveyLine(color = wine_main)
            SurveyCategory(number = 2, state = "now", textKor = "바디감", textEng = "body")
            SurveyLine(color = gray_button_before)
            SurveyCategory(number = 3, state = "yet", textKor = "상황", textEng = "mood")
        }
        Spacer(modifier = Modifier.height(25.dp))
        BottomShadow(alpha = 255, height = 8.dp)
    }
}

@Preview
@Composable
fun PreviewSurveyTopbar(){
    Column {
        SurveyTopbar()
    }
}


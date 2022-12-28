package com.apptive.easywine.presentation.Survey

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.apptive.easywine.R
import com.apptive.easywine.presentation.components.SnackTopBar
import kotlinx.coroutines.CoroutineScope


@Preview
@Composable
fun SurveyResult(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    onClickDrawer: () -> Unit = {},
    scope: CoroutineScope = rememberCoroutineScope(),
    upPress: () -> Unit = {},
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        SnackTopBar(title = "오늘의 와인 확인하기",18, onClickDrawer = onClickDrawer, upPress = upPress)
        Spacer(Modifier.size(90.dp))
        SurveyResultContent()
    }

}

@Composable
fun SurveyResultContent(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color.White)
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(Color.White)
        ){
            WinePageNav(isLeft = true)
            Spacer(Modifier.size(80.dp))
            Image(
                painterResource(id = R.drawable.wine_img),
                modifier = Modifier
                    .width(50.dp)
                    .background(Color.White)
                    .height(200.dp),
                contentDescription = "wine image"
            )
            Spacer(Modifier.size(80.dp))
            WinePageNav(isLeft = false)
        }
        Spacer(Modifier.size(20.dp))
        Heart()
        Spacer(Modifier.size(30.dp))
        Text(
            text = "파스쿠아 스윗로제",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.size(35.dp))
        ResultRate(typeText = "바디", typeRate = 2)
        Spacer(Modifier.size(8.dp))
        ResultRate(typeText = "산미", typeRate = 3)
        Spacer(Modifier.size(8.dp))
        ResultRate(typeText = "당도", typeRate = 5)
        Spacer(Modifier.size(8.dp))
        ResultRate(typeText = "타닌", typeRate = 1)
        Spacer(Modifier.size(50.dp))
        PageNum(totalPage = 3, currentPage = 1)
    }
}

@Composable
fun WinePageNav(
    onClick: () -> Unit = {},
    isLeft: Boolean = true
){
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent
        ),
        elevation = ButtonDefaults.elevation(0.dp)
    ) {
        Row() {

            Image(
                painterResource(
                    id = if (isLeft) R.drawable.single_arrow_left else R.drawable.single_arrow_right
                ),
                contentDescription = "page nav button",
                modifier = Modifier
                    .height(31.dp)
                    .width(31.dp)
            )

        }
    }
}

@Composable
private fun Heart(){
    val clicked = remember { mutableStateOf(true) }
    Button(
        onClick = { clicked.value = !clicked.value },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent
        ),
        elevation = ButtonDefaults.elevation(0.dp)
    ) {
        Image(
            painterResource(
                id = if (clicked.value) R.drawable.heart_empty else R.drawable.heart_full
            ),
            contentDescription = "page nav button",
            modifier = Modifier
                .height(47.dp)
                .width(47.dp)
        )
    }
}

@Composable
fun ResultRate(
    typeText : String,
    typeRate : Int
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        when (typeRate) {
            1 -> {
                Text(
                    text = typeText,
                    fontSize = 15.sp
                )
                Spacer(Modifier.size(27.dp))
                Image(
                    painter = painterResource(id = R.drawable.rate_one),
                    modifier = Modifier
                        .height(37.dp)
                        .width(221.dp),
                    contentDescription = null
                )
            }
            2 -> {
                Text(
                    text = typeText,
                    fontSize = 15.sp
                )
                Spacer(Modifier.size(27.dp))
                Image(
                    painter = painterResource(id = R.drawable.rate_two),
                    modifier = Modifier
                        .height(37.dp)
                        .width(221.dp),
                    contentDescription = null
                )
            }
            3 -> {
                Text(
                    text = typeText,
                    fontSize = 15.sp
                )
                Spacer(Modifier.size(27.dp))
                Image(
                    painter = painterResource(id = R.drawable.rate_three),
                    modifier = Modifier
                        .height(37.dp)
                        .width(221.dp),
                    contentDescription = null
                )
            }
            4 -> {
                Text(
                    text = typeText,
                    fontSize = 15.sp
                )
                Spacer(Modifier.size(27.dp))
                Image(
                    painter = painterResource(id = R.drawable.rate_four),
                    modifier = Modifier
                        .height(37.dp)
                        .width(221.dp),
                    contentDescription = null
                )
            }
            5 -> {
                Text(
                    text = typeText,
                    fontSize = 15.sp
                )
                Spacer(Modifier.size(27.dp))
                Image(
                    painter = painterResource(id = R.drawable.rate_four),
                    modifier = Modifier
                        .height(37.dp)
                        .width(221.dp),
                    contentDescription = null
                )
            }
        }
    }
}

@Composable
fun PageNum(
    totalPage : Int,
    currentPage : Int
){
    var page: String = currentPage.toString() + "/" + totalPage.toString()
    Text(
        text = page,
        fontSize = 15.sp
    )
}
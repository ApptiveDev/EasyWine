package com.apptive.easywine.presentation.Home


import android.widget.Toast
import androidx.annotation.RestrictTo
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.apptive.easywine.R
import com.apptive.easywine.domain.util.log
import com.apptive.easywine.presentation.components.TextTopBar
import com.apptive.easywine.presentation.navgation.Screen
import com.apptive.easywine.ui.theme.*
import kotlinx.coroutines.CoroutineScope

@Composable
fun HomeScreen(
    navController: NavController = rememberNavController(),
    onClickDrawer: () -> Unit = {},
    scrollState: ScrollState = rememberScrollState(),
    scope: CoroutineScope = rememberCoroutineScope()

) {

//    val scrollState = rememberScrollState()
//    val scaffoldState = rememberScaffoldState()
//    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        TextTopBar(title = "EASY WINE", fontSize = 27, scope = scope, onClickDrawer = onClickDrawer)
        HomeMainBanner()
        StartAndOtherServices(
            onSurveyClick = {navController.navigate(Screen.SurveyScreen.route)},
            onWineStorageClick = {navController.navigate(Screen.StorageScreen.route)}
        )
    }


}

@Composable
fun HomeMainBanner() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painterResource(id = R.drawable.wine_banner_image),
            contentDescription = "",
            modifier = Modifier
                .size(375.dp)
        )
    }
}


@Composable
fun StartAndOtherServices(
    onSurveyClick : () -> Unit,
    onWineStorageClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(370.dp)
                .padding(top = 45.dp)
                .clip(RoundedCornerShape(25.dp, 25.dp, 0.dp, 0.dp))
                .background(white_gray),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.size(33.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp)
            ) {
                Text(
                    text = "Other Services",
                    color = gray_button_before,
                    fontFamily = notosanskr,
                    fontWeight = FontWeight.Normal,
                    fontSize = 15.sp
                )
            }
            Spacer(Modifier.size(15.dp))
            QCard("와인 창고", "현재까지 추천받은 와인들") {
                onWineStorageClick()
            }
            Spacer(Modifier.size(20.dp))
            val context  = LocalContext.current
            QCard("와인 잡지", "와인에 대한 어떤 것"){
                Toast.makeText(context, "서비스 준비 중입니다.", Toast.LENGTH_SHORT).show()
            }
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(end = 36.dp)
        ) {
            Text(
                text = "오늘의 추천 와인은?",
                color = wine_main,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier
                    .align(Alignment.TopCenter)
            )
            Spacer(modifier = Modifier.size(2.dp))
            Box(modifier = Modifier
                .size(170.dp, 90.dp)
                .align(Alignment.BottomCenter), contentAlignment = Alignment.Center){
                Button(
                    onClick = onSurveyClick,
                    modifier = Modifier
                        .size(167.dp, 39.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = wine_button,
                    ),
                    shape = RoundedCornerShape(20.dp)
                ) {}
                Text(
                    text = "start",
                    fontSize = 20.sp,
                    fontFamily = notosanskr,
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold
                )
            }

        }
    }
}

@Composable
fun QCard(
    title: String,
    textContent: String,
    onButtonClick: () -> Unit = {},
) {
    Button(
        onClick = onButtonClick,
        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
        elevation = ButtonDefaults.elevation(0.dp),
        modifier = Modifier
            .height(85.dp)
            .width(344.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(white_gray)
            ){
                when (title) {
                    "와인 창고" ->
                        Icon(
                            painter = painterResource(id = R.drawable.wine_storage_icon),
                            contentDescription = "",
                            tint = wine_main,
                            modifier = Modifier.size(45.dp)
                        )
                    "와인 잡지" ->
                        Icon(
                            painter = painterResource(id = R.drawable.wine_magazine_icon),
                            contentDescription = "",
                            tint = wine_main,
                            modifier = Modifier.size(32.dp)
                        )
                }
            }
            Box(
                modifier = Modifier
                    .width(207.dp)
                    .padding(start = 16.dp)
            ) {
                Text(
                    text = title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(500),
                    fontFamily = notosanskr,
                    modifier = Modifier
                            .padding(bottom = 33.dp)
                )
                Text(
                    text = textContent,
                    fontSize = 12.sp,
                    fontWeight = FontWeight(500),
                    fontFamily = notosanskr,
                    color = gray_button_before,
                    modifier = Modifier
                        .padding(top = 35.dp)
                )
            }
            Image(
                painterResource(id = R.drawable.single_arrow_qcard),
                contentDescription = "",
                modifier = Modifier
                    .padding(start = 27.dp)
                    .width(7.dp)
                    .height(22.dp),
            )
        }
    }
}


@Preview
@Composable
fun PreviewHome() {
    HomeScreen()
}
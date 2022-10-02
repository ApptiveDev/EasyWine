//package com.apptive.easywine.presentation.components
//
//import androidx.compose.foundation.BorderStroke
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.selection.selectable
//import androidx.compose.foundation.selection.toggleable
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.*
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.draw.scale
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.semantics.Role
//import androidx.compose.ui.text.font.FontFamily
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.apptive.easywine.enums.Degree
//
//import com.apptive.easywine.presentation.Home.HomeScreen
//import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
//
//@Composable
//fun LikertSurvey(
//) {
//    RoomCreateContent {
//        question("Q1. 어느 정도의 당도를 원하세요?  ")
//        answer()
//        SideState("엷다","부드럽다")
//    }
//
//}
//
//@Composable
//private fun RoomCreateContent(
//    content: @Composable() (ColumnScope.() -> Unit)
//) {
//    Box(
//        modifier = Modifier
//            .height(200.dp)
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .wrapContentSize(Alignment.Center),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            content = content
//        )
//    }
//}
//
//
//@Composable
//fun question(
//    title: String,
//    color: Color = Color.Black
//) {
//    Column(){
//        Text(
//            text = title,
//            fontFamily = FontFamily.SansSerif,
//            fontSize = 17.sp,
//            fontWeight = FontWeight(400),
//            color = color
//        )
//        Spacer(modifier = Modifier.height(36.dp))
//    }
//}
//
//
//@Composable
//fun basicCircle(
//    modifier: Modifier = Modifier,
//    selected: Boolean = false,
//    onClick: () -> Unit = {}
//) {
//    RadioButton(
//        selected,
//        onClick,
//        colors = RadioButtonDefaults.colors(Color(214, 82, 97)),
//        modifier = modifier
//    )
//}
//
//@Composable
//private fun answer(
//    modifier: Modifier = Modifier
//) {
//    var selectedValue = remember { mutableStateOf<Degree>(Degree.None) }
//    Column(){
//        Row(
//            verticalAlignment = Alignment.CenterVertically
//        ){
//            basicCircle(
//                modifier.scale(2.3F,2.3F),
//                selected = selectedValue.value == Degree.dg1,
//                onClick = {selectedValue.value = Degree.dg1}
//            )
//            Spacer(modifier = Modifier.width(16.dp))
//            basicCircle(
//                modifier.scale(1.8F,1.8F),
//                selected = selectedValue.value == Degree.dg2,
//                onClick = {selectedValue.value = Degree.dg2}
//            )
//            Spacer(modifier = Modifier.width(12.dp))
//            basicCircle(
//                modifier.scale(1.5F,1.5F),
//                selected = selectedValue.value == Degree.dg3,
//                onClick = {selectedValue.value = Degree.dg3}
//            )
//            Spacer(modifier = Modifier.width(12.dp))
//            basicCircle(
//                modifier.scale(1.8F,1.8F),
//                selected = selectedValue.value == Degree.dg4,
//                onClick = {selectedValue.value = Degree.dg4}
//            )
//            Spacer(modifier = Modifier.width(16.dp))
//            basicCircle(
//                modifier.scale(2.3F,2.3F),
//                selected = selectedValue.value == Degree.dg5,
//                onClick = {selectedValue.value = Degree.dg5}
//            )
//        }
//        Spacer(modifier = Modifier.height(12.dp))
//    }
//
//}
//
//@Composable
//fun SideState(
//    leftState: String,
//    rightState: String,
//    color: Color = Color.Black
//){
//    Row(
//        modifier = Modifier
//            .width(295.dp)
//            .height(20.dp)
//    ){
//        Spacer(modifier = Modifier.width(5.dp))
//        Row(
//            modifier = Modifier
//                .width(145.dp)
//                .height(20.dp)
//        ){
//            Text(
//                text = leftState,
//                fontFamily = FontFamily.SansSerif,
//                fontSize = 15.sp,
//                fontWeight = FontWeight(400),
//                color = color,
//                textAlign = TextAlign.Start
//            )
//        }
//        Row(
//            modifier = Modifier
//                .width(145.dp)
//                .height(20.dp),
//            horizontalArrangement = Arrangement.End
//        ){
//            Text(
//                text = rightState,
//                fontFamily = FontFamily.SansSerif,
//                fontSize = 15.sp,
//                fontWeight = FontWeight(400),
//                color = color,
//                textAlign = TextAlign.End
//            )
//        }
//    }
//}
//
//
//@Preview
//@Composable
//fun PreviewHome() {
//    LikertSurvey()
//}

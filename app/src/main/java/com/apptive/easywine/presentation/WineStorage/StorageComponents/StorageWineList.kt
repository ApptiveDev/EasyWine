package com.apptive.easywine.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apptive.easywine.R
import com.apptive.easywine.ui.theme.gray_button
import com.apptive.easywine.ui.theme.gray_button_before


@Composable
fun StorageWineList(
    wine_id: Int,
    winename: String,
    wine_info: String,
    country: String,
    country_id: Int,
    onClick: () -> Unit = {}
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp)
            .clip(shape = RoundedCornerShape(15.dp))
            .background(color = Color.White)
        .clickable {onClick()},
        contentAlignment = Alignment.Center
    ){
        Row(
            modifier = Modifier.fillMaxWidth()
        ){
            Spacer(modifier = Modifier.width(45.dp))
            Image(
                painterResource(id = wine_id),
                modifier = Modifier
                    .width(21.dp)
                    .height(79.dp),
                contentDescription = "wine_id"
            )
            Spacer(modifier = Modifier.width(32.dp))
            Column(){
                Text(
                    text = winename,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = gray_button
                )
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    text = wine_info,
                    fontSize = 13.sp,
                    color = gray_button_before
                )
                Spacer(modifier = Modifier.height(12.dp))
                Row(){
                    Image(
                        painterResource(id = country_id),
                        modifier = Modifier
                            .width(25.dp)
                            .height(17.dp),
                        contentDescription = "country_id"
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(
                        text = country,
                        fontSize = 13.sp,
                        color = gray_button_before
                    )
                }

            }
        }
    }


}


@Preview
@Composable
fun PreviewStorageWineList() {
    Column(){
        StorageWineList(R.drawable.pascua_sweet_rose_wine,"파스쿠아 스윗 로제", "피노바앙코, 샤르도네", "이탈리아", R.drawable.italy)
        Spacer(modifier = Modifier.height(10.dp))
        StorageWineList(R.drawable.villa_jolanda_moscato_dasti,"빌라 욜란다 모스카토 다스티", "모스카토", "이탈리아", R.drawable.italy)
    }
}


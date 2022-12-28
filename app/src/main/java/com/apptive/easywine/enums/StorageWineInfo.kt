package com.apptive.easywine.enums

import com.apptive.easywine.R

enum class StorageWineInfo (
    val country: String,
    val nationalFlag: Int
    ){
    Italia("이탈리아", R.drawable.italy),
    France("프랑스", R.drawable.france),
    Spain("스페인", R.drawable.spain),
    Chile("칠레", R.drawable.chile),
    Australia("호주", R.drawable.australia),
    USA("미국", R.drawable.usa),
    Korea("대한민국", R.drawable.korea),
    Japan("일본", R.drawable.japan),
    Argentina("아르헨티나", R.drawable.argentina)
}
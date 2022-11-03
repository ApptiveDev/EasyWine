package com.apptive.easywine.presentation.viewmodel.mock

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf

class MultiCheckButtonViewModel {
    private val isButtonChecked = mutableStateListOf<Boolean>()

     val ischecked: List<Boolean> = isButtonChecked
     fun setIsChecked(
         buttonNo: Int,
         ischecked: Boolean
     ){
         isButtonChecked[buttonNo] = ischecked
     }
    fun initIsChecked(
        buttonNum: Int
    ){
       for (i: Int in 1..buttonNum){
           isButtonChecked.add(false)
       }
    }
}


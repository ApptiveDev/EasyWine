package com.apptive.easywine.presentation.viewmodel.mock

import androidx.compose.runtime.mutableStateListOf

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


package com.apptive.easywine.presentation.Login

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf

interface ILoginViewModel {
    val accountName: MutableState<String>
    val accountId: MutableState<String>
    val accountPw: MutableState<String>
    val accountEmail: MutableState<String>
}
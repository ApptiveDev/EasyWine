package com.apptive.easywine.presentation.Login

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel(),
    ILoginViewModel {
    override val accountName: MutableState<String> = mutableStateOf("")
    override val accountId: MutableState<String> = mutableStateOf("")
    override val accountPw: MutableState<String> = mutableStateOf("")
    override val accountEmail: MutableState<String> = mutableStateOf("")
}
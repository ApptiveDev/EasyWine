package com.apptive.easywine.presentation.Login

import com.apptive.easywine.enums.Side

sealed class LoginEvent {
    data class EnteredEmail(val value: String): LoginEvent()
    data class EnteredPassword(val value: String): LoginEvent()
    data class EnteredName(val value: String): LoginEvent()
    data class EnteredAge(val value: Int): LoginEvent()
    data class EnterGender(val value: Boolean) : LoginEvent()

    object Login: LoginEvent()
    object CreateAccount: LoginEvent()
}
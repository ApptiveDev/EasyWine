package com.apptive.easywine.presentation.Login

sealed class LoginEvent {
    data class EnteredEmail(val value: String): LoginEvent()
    data class EnteredPassword(val value: String): LoginEvent()
    object Login: LoginEvent()
}
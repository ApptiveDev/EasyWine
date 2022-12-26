package com.apptive.easywine.presentation.Login

sealed class LoginEvent {
    data class EnteredEmail(val value: String): LoginEvent()
    data class EnteredPassword(val value: String): LoginEvent()
    data class EnteredName(val value: String): LoginEvent()
    data class EnteredAge(val value: Int): LoginEvent()
    data class EnteredGender(val value: String): LoginEvent()

    object Login: LoginEvent()
    object CreateAccount: LoginEvent()
}
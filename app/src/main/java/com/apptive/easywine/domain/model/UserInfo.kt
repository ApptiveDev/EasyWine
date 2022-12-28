package com.apptive.easywine.domain.model

import com.apptive.easywine.enums.Side

data class UserInfo(
    var email: String = "",
    var pass: String = "",
    var name: String = "",
    var gender: Int = 0,
    var age: Int = 0,
)

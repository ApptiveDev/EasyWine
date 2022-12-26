package com.apptive.easywine.domain.model

data class UserInfo(
	var email : String = "",
	var pass : String = "",
	var name : String = "",
	var gender : Int = 0,
	var age : Int = 0,
)

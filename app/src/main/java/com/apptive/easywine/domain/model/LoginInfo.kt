package com.apptive.easywine.domain.model

data class LoginInfo(
	var email : String = "",
	var pass : String = "",
	var token : String = "",
	var name : String = "",
	var gender : Int = 0,
	var age : Int = 0,
)

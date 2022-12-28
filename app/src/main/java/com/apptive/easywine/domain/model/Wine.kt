package com.apptive.easywine.domain.model

data class Wine(
	var id: Int = 0,
	var name: String = "",
	var sugar : Int = 0,
	var tannin : Int = 0,
	var body : Int = 0,
	var acidity : Int = 0,
	var flavor : String = "",
	var food : String = "",
	var variety : String = "",
	var country : String = "",
	var type : String = "",
	var alcohol : String = ""
)

package com.apptive.easywine.enums

enum class SurveyLevel (
	val number: Int,
	val korText: String,
	val engText: String,
){
	FLAVOR(1, "맛", "flavor"),
	MOOD(2, "상황", "mood"),
	ETC(3, "기타", "etc")
}
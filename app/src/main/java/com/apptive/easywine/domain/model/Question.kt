package com.apptive.easywine.domain.model

data class Question(
	var id : Long = 0L,
	var category: Int = 0,
	var answerFormat: Int = 0,
	var context: String = "",
	var question_option : List<String> = emptyList()
)
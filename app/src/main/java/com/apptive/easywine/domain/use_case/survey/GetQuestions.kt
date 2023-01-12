package com.apptive.easywine.domain.use_case.survey

import javax.inject.Inject


data class GetQuestions @Inject constructor(
	val getQuestion1: GetQuestion1,
	val getQuestion2: GetQuestion2,
	val getQuestion3: GetQuestion3,
)

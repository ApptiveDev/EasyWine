package com.apptive.easywine.enums

enum class SurveyLevel (
	val number: Int,
	val korText: String,
	val engText: String,
){
	FLAVOR(1, "맛", "flavor"),
	MOOD(2, "상황", "mood"),
	ETC(3, "기타", "etc");

	fun increaseLevel(): SurveyLevel {
		return when(this) {
			FLAVOR -> MOOD
			MOOD -> ETC
			else -> ETC
		}
	}
	fun decreaseLevel(): SurveyLevel {
		return when(this) {
			MOOD -> FLAVOR
			ETC -> MOOD
			else -> FLAVOR
		}
	}

	fun stateCalculator(level: SurveyLevel): SurveyState {
		val result = this.number - level.number
		return when {
			result >  0 -> SurveyState.DONE
			result <  0 -> SurveyState.YET
			else -> SurveyState.NOW
		}
	}
}
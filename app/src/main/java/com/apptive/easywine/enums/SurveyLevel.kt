package com.apptive.easywine.enums

enum class SurveyLevel (
	val number: Int,
	val korText: String,
	val engText: String,
	val percent: Float,
){
	FLAVOR(1, "맛", "flavor", 0.2F),
	MOOD(2, "상황", "mood", 0.5F),
	ETC(3, "기타", "etc", 0.8F);

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
package com.apptive.easywine.enums

import androidx.compose.ui.graphics.Color
import com.apptive.easywine.ui.theme.gray_button_before
import com.apptive.easywine.ui.theme.gray_text
import com.apptive.easywine.ui.theme.wine_button
import com.apptive.easywine.ui.theme.wine_main

enum class SurveyState(
	val circleColor: Color,
	val textColor: Color,
) {
	YET(gray_button_before, gray_button_before),
	NOW(wine_button, wine_main),
	DONE(wine_main, gray_text),
}

package com.apptive.easywine.enums

import androidx.annotation.DrawableRes
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class Degree(
        val value: Int?,
        val radioSize: Dp
) {
//        0,41,33,23,33,41
        DG_NONE(0, 0.dp),
        DG_1(1, 53.dp),
        DG_2(2, 44.dp),
        DG_3(3, 35.dp),
        DG_4(4, 44.dp),
        DG_5(5, 53.dp),
}

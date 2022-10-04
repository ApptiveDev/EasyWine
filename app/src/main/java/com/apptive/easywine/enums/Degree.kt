package com.apptive.easywine.enums

import androidx.annotation.DrawableRes
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class Degree(
        val value: Int?,
        val radioSize: Dp
) {
        DG_NONE(0, 0.dp),
        DG_1(1, 41.dp),
        DG_2(2, 33.dp),
        DG_3(3, 23.dp),
        DG_4(4, 33.dp),
        DG_5(5, 41.dp),
}

package com.apptive.easywine.presentation.viewmodel.interfaces

import androidx.compose.runtime.MutableState
import com.apptive.easywine.enums.Degree
import com.apptive.easywine.enums.Side

interface IDegreeViewModel {
    var toDegree: MutableState<Degree>
}
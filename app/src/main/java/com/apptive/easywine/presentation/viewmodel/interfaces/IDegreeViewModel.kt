package com.apptive.easywine.presentation.viewmodel.interfaces

import androidx.compose.runtime.MutableState
import com.apptive.easywine.enums.Degree

interface IDegreeViewModel {
    var toDegree: MutableState<Degree>
}
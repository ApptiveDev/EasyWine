package com.apptive.easywine.presentation.viewmodel.mock

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.apptive.easywine.enums.Degree
import com.apptive.easywine.presentation.viewmodel.interfaces.IDegreeViewModel

class DegreeViewModel: ViewModel(),
    IDegreeViewModel {
    override var toDegree: MutableState<Degree> = mutableStateOf(Degree.DG_NONE)
}
package com.apptive.easywine.presentation.viewmodel.interfaces

import androidx.compose.runtime.MutableState
import com.apptive.easywine.enums.Side

interface IYesOrNoButtonViewModel {
    var isYes: MutableState<Side>
}

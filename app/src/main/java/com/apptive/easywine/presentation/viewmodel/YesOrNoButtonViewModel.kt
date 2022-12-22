package com.apptive.easywine.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.apptive.easywine.enums.Side
import com.apptive.easywine.presentation.viewmodel.interfaces.IYesOrNoButtonViewModel

class YesOrNoButtonViewModel: ViewModel(),
    IYesOrNoButtonViewModel {
    override var isYes: MutableState<Side> = mutableStateOf(Side.LEFT)
}
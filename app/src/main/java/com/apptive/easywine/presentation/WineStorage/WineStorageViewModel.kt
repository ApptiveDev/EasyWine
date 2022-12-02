package com.apptive.easywine.presentation.WineStorage

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.apptive.easywine.enums.Side

class WineStorageViewModel: ViewModel(),
    IWineStorageViewModel {
    override var isAll: MutableState<Side> = mutableStateOf(Side.LEFT)
}
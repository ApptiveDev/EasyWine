package com.apptive.easywine.presentation.WineStorage

import androidx.compose.runtime.MutableState
import com.apptive.easywine.enums.Side

interface IWineStorageViewModel {
    var isAll: MutableState<Side>
}
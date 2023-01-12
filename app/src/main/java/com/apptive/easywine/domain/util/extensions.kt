package com.apptive.easywine.domain.util

import android.util.Log

fun String.log(header: String = "EasyWine") {
    Log.d(header, this)
}
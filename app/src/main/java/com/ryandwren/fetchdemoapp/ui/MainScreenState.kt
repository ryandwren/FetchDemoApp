package com.ryandwren.fetchdemoapp.ui

import androidx.compose.runtime.mutableStateOf
import com.ryandwren.fetchdemoapp.data.HireItem

class MainScreenState {
    val isRequestInProgress = mutableStateOf(false)

    val hireList = mutableStateOf(emptyList<HireItem>())
}
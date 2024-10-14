package com.ryandwren.fetchdemoapp.ui

import androidx.lifecycle.ViewModel
import com.ryandwren.fetchdemoapp.data.repositories.FetchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val fetchRepository: FetchRepository
): ViewModel() {
    val state = MainScreenState()

    init {

    }
}
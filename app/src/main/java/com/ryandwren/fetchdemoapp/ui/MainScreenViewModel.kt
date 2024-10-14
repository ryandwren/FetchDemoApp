package com.ryandwren.fetchdemoapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ryandwren.fetchdemoapp.data.repositories.FetchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val fetchRepository: FetchRepository
): ViewModel() {
    val state = MainScreenState()

    init {
        getHireItems()
    }

    private fun getHireItems(){
        viewModelScope.launch {
            fetchRepository.getHireList()
                .onStart { state.isRequestInProgress.value = true }
                .onCompletion { state.isRequestInProgress.value = false }
                .collect{
                    state.hireList.replaceAll { it }
                }
        }
    }
}
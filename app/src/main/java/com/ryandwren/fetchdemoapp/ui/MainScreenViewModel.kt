package com.ryandwren.fetchdemoapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ryandwren.fetchdemoapp.data.HireItem
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
                .collect{ it ->
                    val sortedHireList = it
                        .filterNot { it.name.isNullOrEmpty() }
                        .sortedWith(compareBy(HireItem::listId, HireItem::id))
                    //Sort by listId, then id instead of listId, then name because name as a string will place "4" before "300".
                    //We could get a substring of name removing "item " then converting and sorting that. But would be wasted effort.
                    //In a real world scenario id has likely been provided separately by the backend for this exact sorting need.
                    //Or if name is indeed meant to be a sorted by value discuss with Product. Discuss user expectations, and possible name formats.
                    state.hireList.value = sortedHireList
                }
        }
    }
}
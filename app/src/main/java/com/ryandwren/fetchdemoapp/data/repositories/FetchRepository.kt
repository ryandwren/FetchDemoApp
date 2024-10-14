package com.ryandwren.fetchdemoapp.data.repositories

import com.ryandwren.fetchdemoapp.data.HireItem
import kotlinx.coroutines.flow.Flow

interface FetchRepository {
    suspend fun getHireList(): Flow<List<HireItem>>
}
package com.ryandwren.fetchdemoapp.data.repositories

import com.ryandwren.fetchdemoapp.data.FetchAPI
import com.ryandwren.fetchdemoapp.data.HireItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FetchRepositoryImpl @Inject constructor(
    private val api: FetchAPI
): FetchRepository {
    override suspend fun getHireList(): Flow<List<HireItem>> {
        return flow {
            emit(
                api.getHiringList()
            )
        }
    }

}
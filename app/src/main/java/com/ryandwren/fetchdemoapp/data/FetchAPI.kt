package com.ryandwren.fetchdemoapp.data

import retrofit2.http.GET
import retrofit2.http.Headers

interface FetchAPI {
    @GET("/hiring")
    @Headers("Content-Type: application/json")
    suspend fun getHiringList():List<HireItem>
}
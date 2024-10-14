package com.ryandwren.fetchdemoapp.data

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
object ApiModule {

    val baseUrl = "https://fetch-hiring.s3.amazonaws.com"

    @Provides
    @Singleton
    fun provideRetrofitBuilder(client: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
            .client(client)
    }

    fun provideFetchApi(retrofit: Retrofit.Builder){
        retrofit
            .baseUrl(baseUrl)
            .build()
            .create(FetchAPI::class.java)
    }

}
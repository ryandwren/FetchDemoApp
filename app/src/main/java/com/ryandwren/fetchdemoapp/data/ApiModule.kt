package com.ryandwren.fetchdemoapp.data

import com.ryandwren.fetchdemoapp.data.repositories.FetchRepository
import com.ryandwren.fetchdemoapp.data.repositories.FetchRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    val baseUrl = "https://fetch-hiring.s3.amazonaws.com"

    @Provides
    @Singleton
    fun provideRetrofitBuilder(): Retrofit.Builder {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().build())
    }

    @Provides
    @Singleton
    fun provideFetchApi(retrofit: Retrofit.Builder): FetchAPI {
        return retrofit
            .baseUrl(baseUrl)
            .build()
            .create(FetchAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideFetchRepository(api: FetchAPI): FetchRepository{
        return FetchRepositoryImpl(api)
    }

}
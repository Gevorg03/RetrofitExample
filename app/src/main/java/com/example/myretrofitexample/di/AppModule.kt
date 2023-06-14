package com.example.myretrofitexample.di

import com.example.myretrofitexample.api.ApiCountry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun getBaseUrl(): String = "https://raw.githubusercontent.com/"

    @Singleton
    @Provides
    fun getRetrofitServiceInstance(retrofit: Retrofit): ApiCountry {
        return retrofit.create(ApiCountry::class.java)
    }

    @Singleton
    @Provides
    fun getRetrofitInstance(url: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
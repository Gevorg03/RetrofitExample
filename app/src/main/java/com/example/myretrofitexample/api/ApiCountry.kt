package com.example.myretrofitexample.api

import com.example.myretrofitexample.model.Country
import retrofit2.http.GET

interface ApiCountry {

    @GET("atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json")
    suspend fun getAllCountries(): List<Country>
}
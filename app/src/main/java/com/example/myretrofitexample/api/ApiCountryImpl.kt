package com.example.myretrofitexample.api

import com.example.myretrofitexample.model.Country
import javax.inject.Inject

class ApiCountryImpl @Inject constructor(private val apiService: ApiCountry) {
    suspend fun getCountries(): List<Country> = apiService.getAllCountries()
}
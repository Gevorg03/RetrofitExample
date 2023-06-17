package com.example.myretrofitexample.repository

import com.example.myretrofitexample.api.ApiCountry
import com.example.myretrofitexample.model.Country
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CountryRepository @Inject constructor(private val api: ApiCountry) {
    fun getCountries(): Flow<List<Country>> = flow {
        emit(api.getAllCountries())
    }.flowOn(Dispatchers.IO)
}

package com.example.myretrofitexample.repository

import com.example.myretrofitexample.api.ApiCountryImpl
import com.example.myretrofitexample.model.Country
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CountryRepository @Inject constructor(private val api: ApiCountryImpl) {

    fun getCountries(): Flow<List<Country>> = flow {
        emit(api.getCountries())
    }.flowOn(Dispatchers.IO)
}

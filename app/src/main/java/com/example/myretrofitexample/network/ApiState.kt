package com.example.myretrofitexample.network

import com.example.myretrofitexample.model.Country

sealed class ApiState {
    class Failure(val msg:Throwable) : ApiState()
    class Success(val data:List<Country>) : ApiState()
    object Empty : ApiState()
}
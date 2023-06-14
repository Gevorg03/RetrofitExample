package com.example.myretrofitexample.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myretrofitexample.network.ApiState
import com.example.myretrofitexample.repository.CountryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel
@Inject constructor(
    private val repository: CountryRepository
) : ViewModel() {
    private val _country: MutableStateFlow<ApiState> =
        MutableStateFlow(ApiState.Empty)

    val country: StateFlow<ApiState>
        get() = _country

    init {
        getAllCountries()
    }

    private fun getAllCountries() = viewModelScope.launch {
        repository.getCountries()
            .catch { e ->
                _country.value = ApiState.Failure(e)
            }.collect { data ->
                _country.value = ApiState.Success(data)
            }
    }
}

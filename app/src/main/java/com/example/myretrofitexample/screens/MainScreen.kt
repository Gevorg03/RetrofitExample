package com.example.myretrofitexample.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myretrofitexample.model.Country
import com.example.myretrofitexample.network.ApiState
import com.example.myretrofitexample.ui.theme.LightPink
import com.example.myretrofitexample.ui.theme.Pink
import com.example.myretrofitexample.ui.theme.PurpleGrey40
import com.example.myretrofitexample.viewModel.MainActivityViewModel

@Composable
fun HomeScreen(viewModel: MainActivityViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PurpleGrey40)
    ) {
        val apiState = viewModel.country.collectAsState().value
        var country: List<Country> = listOf()

        when (apiState) {
            is ApiState.Failure -> {
                Log.d("main", "onCreate: ${apiState.msg}")
            }

            is ApiState.Success -> {
                country = apiState.data
            }

            else -> {}
        }

        CountrySection(country = country)
    }
}

@Composable
fun CountrySection(
    country: List<Country>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
            modifier = Modifier
                .fillMaxHeight()
        ) {
            items(country.size) { element ->
                CountryItem(country[element])
            }
        }
    }
}

@Composable
fun CountryItem(
    country: Country
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .padding(top = 10.dp, start = 10.dp)
        ) {
            Text(
                text = country.name,
                style = MaterialTheme.typography.headlineMedium,
                color = Pink,
                fontSize = 35.sp,
            )

            Spacer(
                modifier = Modifier
                    .height(10.dp)
            )

            Text(
                text = country.capital,
                style = MaterialTheme.typography.headlineMedium,
                color = LightPink,
                fontSize = 25.sp,
                modifier = Modifier
                    .padding(start = 5.dp)
            )
        }
    }
}

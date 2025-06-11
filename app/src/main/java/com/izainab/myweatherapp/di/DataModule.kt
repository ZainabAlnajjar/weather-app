package com.izainab.myweatherapp.di

import com.izainab.myweatherapp.data.googleServiceLocationDataSource.GoogleServiceLocationImp
import com.izainab.myweatherapp.data.meteoAPIDataSource.WeatherRepositoryImp
import com.izainab.myweatherapp.domain.repositories.WeatherRepository
import com.izainab.myweatherapp.domain.services.LocationService
import com.izainab.myweatherapp.presentation.viewmodel.WeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataModule = module {

    single<WeatherRepository> { WeatherRepositoryImp() }
    single<LocationService> { GoogleServiceLocationImp(get(), get()) }
}
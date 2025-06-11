package com.izainab.myweatherapp.di

import android.location.Geocoder
import com.google.android.gms.location.LocationServices
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import java.util.Locale


val appModule = module {
    single { LocationServices.getFusedLocationProviderClient(androidContext()) }
    single { Geocoder(androidContext(), Locale.getDefault()) }
}
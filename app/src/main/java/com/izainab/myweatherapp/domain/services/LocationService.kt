package com.izainab.myweatherapp.domain.services

import com.izainab.myweatherapp.domain.entities.Location

interface LocationService {
    suspend fun getCurrentLocation(): Location
}
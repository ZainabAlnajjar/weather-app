package com.izainab.myweatherapp.domain.exceptions

class LocationFailureException(message: String = "Failed to get location") : Exception(message)

class DataFailureException(message: String = "Data failure exception") : Exception(message)

package com.androidtest.forcast.data.network.api

import com.androidtest.forcast.data.response.ForecastResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TimelineApi: BaseApi {
    @GET("/weather/forecast/")
    suspend fun getForecast(@Query("location") location: String) : ForecastResponse
}
package com.androidtest.forcast.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_values")
data class WeatherValues (
    @PrimaryKey(autoGenerate = true)
    val idValue: Int = 0,
    val temperatureAvg: Double?,
    val temperatureMax: Double?,
    val temperatureMin: Double?,
    val humidityAvg: Double?,
    val humidityMax: Double?,
    val humidityMin: Double?
)

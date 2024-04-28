package com.androidtest.forcast.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.androidtest.forcast.data.entity.WeatherValues

@Dao
interface WeatherValuesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveWeatherValues(weatherValue : WeatherValues)

    @Query("SELECT * FROM weather_values")
    suspend fun getAllWeatherValues(): List<WeatherValues>
}
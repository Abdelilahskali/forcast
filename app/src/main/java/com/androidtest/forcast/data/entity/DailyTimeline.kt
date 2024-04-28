package com.androidtest.forcast.data.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "daily_timeline")
data class DailyTimeline(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val time: String?,
    @Embedded val values: WeatherValues
    )

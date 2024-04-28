package com.androidtest.forcast.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.androidtest.forcast.data.entity.DailyTimeline
import com.androidtest.forcast.data.entity.WeatherValues

@Database(
    entities = [ DailyTimeline::class, WeatherValues::class],
    version = 1
)

abstract class AppDatabase() : RoomDatabase() {
    abstract fun getDailyTimelineDao(): DailyTimelineDao
    abstract  fun getWeatherValuesDao(): WeatherValuesDao
    companion object {

        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "app-weather"
            ).build()
    }
}
package com.androidtest.forcast.data.repository

import com.androidtest.forcast.data.db.AppDatabase
import com.androidtest.forcast.data.network.api.TimelineApi
import javax.inject.Inject

class ForecastRepository @Inject constructor(
    private val api: TimelineApi,
    private val db: AppDatabase
): BaseRepository(api) {

    suspend fun getForecast(location: String) = safeApiCall {
        api.getForecast(location)
    }
    suspend fun getDailyTimelineFromLocal() = db.getDailyTimelineDao().getAllDailyTimeline()
}
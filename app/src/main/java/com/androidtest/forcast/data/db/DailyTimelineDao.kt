package com.androidtest.forcast.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.androidtest.forcast.data.entity.DailyTimeline

@Dao
interface DailyTimelineDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAllTimelines(timelines : List<DailyTimeline>)

    @Query("SELECT * FROM daily_timeline")
    suspend fun getAllDailyTimeline(): List<DailyTimeline>
}
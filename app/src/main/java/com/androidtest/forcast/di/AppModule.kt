package com.androidtest.forcast.di

import android.content.Context
import com.androidtest.forcast.data.db.AppDatabase
import com.androidtest.forcast.data.network.api.TimelineApi
import com.androidtest.forcast.data.network.remote.RemoteDataSource
import com.androidtest.forcast.data.repository.ForecastRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideRemoteDataSource(): RemoteDataSource {
        return RemoteDataSource()
    }

    @Singleton
    @Provides
    fun provideTimelineApi(
        remoteDataSource: RemoteDataSource,
    ): TimelineApi {
        return remoteDataSource.buildApi(TimelineApi::class.java)
    }

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase(context)
    }

    @Provides
    fun provideTimelineRepository(
        timelineApi: TimelineApi,
        db: AppDatabase
    ): ForecastRepository {
        return ForecastRepository(timelineApi, db)
    }

}
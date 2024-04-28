package com.androidtest.forcast.data.repository

import com.androidtest.forcast.data.network.api.BaseApi
import com.androidtest.forcast.data.network.remote.SafeApiCall

abstract class BaseRepository(private val api: BaseApi) : SafeApiCall
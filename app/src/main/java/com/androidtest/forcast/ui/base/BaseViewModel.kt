package com.androidtest.forcast.ui.base

import androidx.lifecycle.ViewModel
import com.androidtest.forcast.data.repository.BaseRepository

abstract class BaseViewModel(
    private val repository: BaseRepository
) : ViewModel()
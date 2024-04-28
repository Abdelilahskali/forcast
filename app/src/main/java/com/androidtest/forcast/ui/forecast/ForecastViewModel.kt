package com.androidtest.forcast.ui.forecast

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.androidtest.forcast.data.network.remote.Resource
import com.androidtest.forcast.data.repository.ForecastRepository
import com.androidtest.forcast.data.response.ForecastResponse
import com.androidtest.forcast.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(
    private val repository: ForecastRepository
): BaseViewModel(repository) {

    private val _forecastResponse: MutableLiveData<Resource<ForecastResponse>> = MutableLiveData()
    val forecastResponse: LiveData<Resource<ForecastResponse>>
        get() = _forecastResponse

    fun getForecast(location: String) = viewModelScope.launch {
        _forecastResponse.value = Resource.Loading
        _forecastResponse.value = repository.getForecast(location)
    }
}
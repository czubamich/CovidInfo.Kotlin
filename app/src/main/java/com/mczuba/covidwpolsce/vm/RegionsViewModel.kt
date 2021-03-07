package com.mczuba.covidwpolsce.vm

import android.app.Application
import androidx.lifecycle.*
import com.mczuba.covidwpolsce.api.CovidDataProvider
import com.mczuba.covidwpolsce.data.Country
import com.mczuba.covidwpolsce.data.CountryHistory
import com.mczuba.covidwpolsce.data.RegionHistory
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class RegionsViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = CovidDataProvider
    val country = repository.country
    val regions = repository.regions

    private var _regionsSummary = MutableLiveData<List<RegionHistory>>()
    val regionsSummary: LiveData<List<RegionHistory>> = _regionsSummary

    val latestUpdate = Transformations.map(regionsSummary)
    {
        SimpleDateFormat("hh:mm, d.MM.yyy").format(it.first().timestamp)
    }

    val latestDate = Transformations.map(regionsSummary)
    {
        SimpleDateFormat("d MMMM yyy").format(it.first().date)
    }

    init { updateData() }
    fun updateData() {
        viewModelScope.launch {
            country.value?.let {
                val a = repository.getRegionSummary(it)
                _regionsSummary.postValue(a)
            }
        }
    }
}
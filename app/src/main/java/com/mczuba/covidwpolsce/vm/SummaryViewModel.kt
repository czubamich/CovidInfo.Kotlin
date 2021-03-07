package com.mczuba.covidwpolsce.vm

import android.app.Application
import androidx.lifecycle.*
import com.anychart.AnyChart
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.anychart.charts.Cartesian
import com.mczuba.covidwpolsce.api.CovidDataProvider
import com.mczuba.covidwpolsce.data.Country
import com.mczuba.covidwpolsce.data.CountryHistory
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.MutableList
import kotlin.collections.first


class SummaryViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = CovidDataProvider
    val country = repository.country
    val regions = repository.regions

    private var _entry = MutableLiveData<CountryHistory>(
        CountryHistory(
            Date(),
            "PL",
            Date(),
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0
        )
    )
    val entry: LiveData<CountryHistory> = _entry
    val _data = MutableLiveData(listOf<CountryHistory>())
    val data: LiveData<List<CountryHistory>> = _data

    val latestDate = Transformations.map(entry)
    {
        SimpleDateFormat("d MMMM yyy").format(it.date)
    }

    val latestUpdate = Transformations.map(entry)
    {
        SimpleDateFormat("hh:mm, d.MM.yyy").format(it.timestamp)
    }

    init {
        viewModelScope.launch {
            country.value?.let {
                val cc = repository.getCountryHistoryToday(it).first()
                _entry.postValue(cc)

                val ch = repository.getCountryHistory(it)
                _data.postValue(ch)
            }
        }
    }
}
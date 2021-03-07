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
import com.mczuba.covidwpolsce.data.Region
import com.mczuba.covidwpolsce.data.RegionHistory
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.MutableList
import kotlin.collections.first


class RegionDetailViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = CovidDataProvider
    val country = repository.country
    val regions = repository.regions
    var region = MutableLiveData<Region>()

    private var _entry = MutableLiveData<RegionHistory>(
        RegionHistory(
            Date(),
            "..",
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
    val entry: LiveData<RegionHistory> = _entry
    val _data = MutableLiveData(listOf<RegionHistory>())
    val data: LiveData<List<RegionHistory>> = _data

    val latestDate = Transformations.map(entry)
    {
        SimpleDateFormat("d MMMM yyy").format(it.date)
    }

    val latestUpdate = Transformations.map(entry)
    {
        SimpleDateFormat("hh:mm, d.MM.yyy").format(it.timestamp)
    }

    fun initFor(regId: String) {
        regions.value?.find { it -> it.regionId==regId }?.run {
            region.value = this
            region.postValue(this)

            val reg = this
            viewModelScope.launch {
                val cc = repository.getRegionHistoryToday(reg).first()
                _entry.postValue(cc)

                val ch = repository.getRegionHistory(reg)
                _data.postValue(ch)
            }
        }
    }
}
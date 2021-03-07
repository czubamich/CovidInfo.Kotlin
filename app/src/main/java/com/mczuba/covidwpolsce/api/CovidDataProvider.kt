package com.mczuba.covidwpolsce.api

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.mczuba.covidwpolsce.data.Country
import com.mczuba.covidwpolsce.data.Region
import kotlinx.coroutines.Dispatchers
import org.joda.time.DateTime
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import java.util.*

object CovidDataProvider {
    private val api: RestApi = RestApi()

    var _country = MutableLiveData<Country>()
    val country: LiveData<Country> = _country

    var _regions = MutableLiveData<List<Region>>()
    val regions: LiveData<List<Region>> = _regions

    suspend fun init() {
        try {
            val retrievedCountry = api.getCountries()?.find { x -> x.countryId == "PL" };
            val retrievedRegions = api.getRegions().filter { x -> x.countryId == "PL" }.also { it.forEach{ it.country = retrievedCountry } }

            _country.value = retrievedCountry
            _regions.value = retrievedRegions
        }
        catch(e: Exception)
        {
            e.toString()
        }
    }

    suspend fun getCountryList() = api.getCountries()
    suspend fun getRegionsList() = api.getRegions().also{ it.forEach { it.country = _country.value} }

    suspend fun getCountryHistory(country: Country)
            = api.getCountryHistory(country).onEach { x -> x.country = _country.value}
    suspend fun getCountryHistoryToday(country: Country)
            = api.getCountryHistoryToday(country).onEach { x -> x.country = _country.value}
    suspend fun getCountryHistorySince(country: Country, date: DateTime)
            = api.getCountryHistorySince(country, date).onEach { x -> x.country = _country.value}

    suspend fun getRegionHistory(region: Region)
            = api.getRegionHistory(region).onEach { it.region = _regions.value?.find{ x -> x.regionId == it.regionId } }
    suspend fun getRegionHistoryToday(region: Region)
            = api.getRegionHistoryToday(region).onEach { it.region = _regions.value?.find{ x -> x.regionId == it.regionId } }
    suspend fun getRegionHistorySince(region: Region, date: DateTime)
            = api.getRegionHistorySince(region, date).onEach { it.region = _regions.value?.find{ x -> x.regionId == it.regionId } }
    suspend fun getRegionSummary(country: Country)
            = api.getRegionSummary(country).onEach { it.region = _regions.value?.find{ x -> x.regionId == it.regionId } }

    suspend fun getNewsPage(page: Int) = api.getNewsPage(page).onEach { x -> x.country = _country.value}
    suspend fun getNewsPageCount() = api.getNewsPageCount()
}
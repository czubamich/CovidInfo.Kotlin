package com.mczuba.covidwpolsce.api

import com.google.gson.GsonBuilder
import com.mczuba.covidwpolsce.data.Country
import com.mczuba.covidwpolsce.data.CountryNews
import com.mczuba.covidwpolsce.data.Region
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.*


class RestApi {
    private val dtf = DateTimeFormat.forPattern("yyyy-MM-dd")
    private val covidApi: CovidApi
    init {
        val gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create()
        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:44341/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        covidApi = retrofit.create(CovidApi::class.java)
    }

    suspend fun getRegions() = covidApi.getRegions()
    suspend fun getCountries() = covidApi.getCountries()

    suspend fun getCountryHistory(country: Country) = covidApi.getCountryHistory(country.countryId)
    suspend fun getCountryHistoryToday(country: Country) = covidApi.getCountryHistoryToday(country.countryId)
    suspend fun getCountryHistorySince(country: Country, date: DateTime) = covidApi.getCountryHistorySince(country.countryId, dtf.print(date))

    suspend fun getRegionSummary(country: Country)
            = covidApi.getRegionSummary( country.countryId )
    suspend fun getRegionHistory(region: Region)
            = covidApi.getRegionHistory( region.countryId, region.regionId )
    suspend fun getRegionHistoryToday(region: Region)
            = covidApi.getRegionHistoryToday( region.countryId, region.regionId )
    suspend fun getRegionHistorySince(region: Region, date: DateTime)
            = covidApi.getRegionHistorySince( region.countryId, region.regionId, dtf.print(date) )

    suspend fun getNewsPage(page: Int) = covidApi.getNewsPage(page.toString())
    suspend fun getNewsPageCount() = covidApi.getNewsPageCount()
}
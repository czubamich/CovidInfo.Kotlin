package com.mczuba.covidwpolsce.api

import com.mczuba.covidwpolsce.data.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.*

interface CovidApi {
    @GET("country/pl/news/{page}")
    suspend fun getNewsPage(@Path(value = "page") page: String) : List<CountryNews>;

    @GET("country/pl/news/pages")
    suspend fun getNewsPageCount() : Int

    @GET("region/pl/list")
    suspend fun getRegions() : List<Region>;

    @GET("country/list")
    suspend fun getCountries() : List<Country>;

    @GET("country/{countryId}")
    suspend fun getCountryHistory(@Path(value = "countryId") countryId: String) : List<CountryHistory>;

    @GET("country/{countryId}/today")
    suspend fun getCountryHistoryToday(@Path(value = "countryId") countryId: String) : List<CountryHistory>;

    @GET("country/{countryId}/since/{date}")
    suspend fun getCountryHistorySince(@Path(value = "countryId") countryId: String, @Path(value = "date") date: String) : List<CountryHistory>;

    @GET("region/{countryId}/{regionId}")
    suspend fun getRegionHistory(@Path(value = "countryId") countryId: String,
                                 @Path(value = "regionId") regionId: String)
            : List<RegionHistory>;

    @GET("region/{countryId}/{regionId}/today")
    suspend fun getRegionHistoryToday(
        @Path(value = "countryId") countryId: String,
        @Path(value = "regionId") regionId: String)
            : List<RegionHistory>;

    @GET("region/{countryId}/{regionId}/since/{date}")
    suspend fun getRegionHistorySince(
        @Path(value = "countryId") countryId: String,
        @Path(value = "regionId") regionId: String,
        @Path(value = "date") date: String
    )   : List<RegionHistory>

    @GET("region/{countryId}/summary")
    suspend fun getRegionSummary( @Path(value = "countryId") countryId: String ) : List<RegionHistory>;
}
package com.mczuba.covidwpolsce.data

import com.google.gson.annotations.SerializedName

data class Region (
@SerializedName("RegionID")
var regionId: String = "",

@SerializedName("CountryID")
var countryId: String = "",

@SerializedName("RegionName")
var name: String = ""
) {
    var country: Country? = null
}
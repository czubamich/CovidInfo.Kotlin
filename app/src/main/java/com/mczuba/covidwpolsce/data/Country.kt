package com.mczuba.covidwpolsce.data

import com.google.gson.annotations.SerializedName
import java.util.*

data class Country (
    @SerializedName("CountryID")
    var countryId: String = "",
    @SerializedName("CountryName")
    var name: String = "",
    @SerializedName("LocalisedName")
    var localName: String = ""
) {}
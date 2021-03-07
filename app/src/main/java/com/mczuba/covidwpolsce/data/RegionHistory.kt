package com.mczuba.covidwpolsce.data

import com.google.gson.annotations.SerializedName
import java.util.*

data class RegionHistory (
@SerializedName("Date")
var date: Date,

@SerializedName("RegionID")
var regionId: String,

@SerializedName("Timestamp")
var timestamp: Date,

@SerializedName("TotalCases")
var cases: Int?,

@SerializedName("NewCases")
var newCases: Int?,

@SerializedName("TotalRecoveries")
var recovered: Int?,

@SerializedName("NewRecoveries")
var newRecovered: Int?,

@SerializedName("TotalDeaths")
var deaths: Int?,

@SerializedName("NewDeaths")
var newDeaths: Int?,

@SerializedName("TotalTests")
var tests: Int?,

@SerializedName("NewTests")
var newTests: Int?,

@SerializedName("ActiveCases")
var active: Int?
) {
    var region: Region? = null
}
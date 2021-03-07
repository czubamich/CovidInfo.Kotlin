package com.mczuba.covidwpolsce.data

import com.google.gson.annotations.SerializedName
import java.util.*

data class CountryNews (
    @SerializedName("Timestamp")
    var timestamp: Date,
    @SerializedName("CountryID")
    var countryId: String,
    @SerializedName("Topic")
    var topic: String,
    @SerializedName("Content")
    var content: String,
    @SerializedName("Author")
    var author: Author
) {
    var country: Country? = null

    data class Author (
        @SerializedName("Name")
        var name: String,
        @SerializedName("DateJoined")
        var dateJoined: Date
    ) {}
}
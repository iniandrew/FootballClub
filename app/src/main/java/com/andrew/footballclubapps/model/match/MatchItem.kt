package com.andrew.footballclubapps.model.match

import com.google.gson.annotations.SerializedName

data class MatchItem(
    @SerializedName("idEvent")
    val idEvent: Int? = null,

    @SerializedName("strEvent")
    val eventName: String? = null,

    @SerializedName("strHomeTeam")
    val homeTeam: String? = null,

    @SerializedName("strAwayTeam")
    val awayTeam: String? = null,

    @SerializedName("intHomeScore")
    val homeScore: Int? = null,

    @SerializedName("intAwayScore")
    val awayScore: Int? = null,

    @SerializedName("dateEvent")
    val dateEvent: String? = null
)
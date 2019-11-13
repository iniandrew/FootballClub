package com.andrew.footballclubapps.model.match

import com.google.gson.annotations.SerializedName

data class MatchResponse(
    @SerializedName("events")
    val result: List<MatchItem>
)
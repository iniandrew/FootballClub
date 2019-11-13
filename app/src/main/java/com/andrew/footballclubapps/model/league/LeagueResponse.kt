package com.andrew.footballclubapps.model.league

import com.google.gson.annotations.SerializedName

data class LeagueResponse(
    @SerializedName("leagues")
    val results: MutableList<LeagueItem>
)
package com.andrew.footballclubapps.model.league

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LeagueItem(
    @SerializedName("idLeague")
    val leagueId: Int? = null,

    @SerializedName("strBadge")
    val leagueBadge: String? = null,

    @SerializedName("strLeague")
    var leagueName: String? = null,

    @SerializedName("strDescriptionEN")
    var leagueDescription: String? = null,

    @SerializedName("strBanner")
    val leagueBanner: String? = null
) : Parcelable
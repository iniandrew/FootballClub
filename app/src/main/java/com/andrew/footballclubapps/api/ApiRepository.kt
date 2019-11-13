package com.andrew.footballclubapps.api

import com.andrew.footballclubapps.BuildConfig

class ApiRepository {
    companion object {
        const val LEAGUE_DETAIL = BuildConfig.BASE_URL + "api/v1/json/{api_key}/lookupleague.php?id={leagueId}"
        const val PREVIOUS_MATCH = BuildConfig.BASE_URL + "api/v1/json/{api_key}/eventspastleague.php?id={leagueId}"
        const val NEXT_MATCH = BuildConfig.BASE_URL + "api/v1/json/{api_key}/eventsnextleague.php?id={leagueId}"
    }
}
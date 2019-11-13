package com.andrew.footballclubapps.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andrew.footballclubapps.BuildConfig
import com.andrew.footballclubapps.api.ApiRepository
import com.andrew.footballclubapps.model.league.LeagueResponse
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener

class LeagueDetailViewModel : ViewModel(){

    private val leagueDetail = MutableLiveData<LeagueResponse>()

     fun setLeagueDetail(id: Int) {
        AndroidNetworking.get(ApiRepository.LEAGUE_DETAIL)
            .addPathParameter("api_key", BuildConfig.TSDB_API_KEY)
            .addPathParameter("leagueId", id.toString())
            .setPriority(Priority.IMMEDIATE)
            .build()
            .getAsObject(LeagueResponse::class.java, object : ParsedRequestListener<LeagueResponse> {
                override fun onResponse(response: LeagueResponse) {
                    response.let {
                        leagueDetail.postValue(it)
                    }
                }

                override fun onError(anError: ANError) {
                    Log.d("ERROR", "onError: ", anError)
                    error("Error ${anError.errorBody}")
                }
            })
    }

    fun getLeagueDetail(): LiveData<LeagueResponse> {
        return leagueDetail
    }
}

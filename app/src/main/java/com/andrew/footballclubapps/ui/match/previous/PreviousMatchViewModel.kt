package com.andrew.footballclubapps.ui.match.previous

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andrew.footballclubapps.BuildConfig
import com.andrew.footballclubapps.api.ApiRepository
import com.andrew.footballclubapps.model.match.MatchResponse
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener

class PreviousMatchViewModel : ViewModel() {

    private val previousMatch = MutableLiveData<MatchResponse>()

        fun setPreviousMatch(id: Int?) {
            AndroidNetworking.get(ApiRepository.PREVIOUS_MATCH)
                .addPathParameter("api_key", BuildConfig.TSDB_API_KEY)
                .addPathParameter("leagueId", id.toString())
                .setPriority(Priority.IMMEDIATE)
                .build()
                .getAsObject(MatchResponse::class.java, object :
                    ParsedRequestListener<MatchResponse> {
                    override fun onResponse(response: MatchResponse) {
                        response.let {
                            previousMatch.postValue(it)
                        }
                    }

                    override fun onError(anError: ANError) {
                        Log.d("ERROR", "onError: ", anError)
                        error("Error ${anError.errorBody}")
                    }
                })
        }


        fun getPreviousMatch(): LiveData<MatchResponse> = previousMatch
}
package com.andrew.footballclubapps.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.andrew.footballclubapps.R
import com.andrew.footballclubapps.model.league.LeagueItem
import com.andrew.footballclubapps.model.league.LeagueResponse
import com.andrew.footballclubapps.showLoading
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_league_detail.*

class LeagueDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_LEAGUE_ID = "extra_league_id"
    }
    private lateinit var viewModel: LeagueDetailViewModel

    private val getLeague = Observer<LeagueResponse> { league ->
        if (league != null) {
            for (item in league.results) {
                setLeagueItem(item)
                supportActionBar?.title = item.leagueName
            }
            showLoading(true, progress_bar)
        }
        showLoading(false, progress_bar)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league_detail)

        loadLeagueDetail()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun loadLeagueDetail() {
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(LeagueDetailViewModel::class.java)
        viewModel.getLeagueDetail().observe(this, getLeague)
        viewModel.setLeagueDetail(intent.getIntExtra(EXTRA_LEAGUE_ID, 0))
    }


    private fun setLeagueItem(league: LeagueItem) {
        Glide.with(this)
            .load(league.leagueBadge)
            .into(img_league_badge)
        tv_league_name.text = league.leagueName
        tv_description_detail.text = league.leagueDescription
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

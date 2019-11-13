package com.andrew.footballclubapps.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andrew.footballclubapps.R
import com.andrew.footballclubapps.ui.league.LeagueFragment
import com.andrew.footballclubapps.ui.match.previous.PreviousMatchFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_league -> {
                    loadLeagueFragment()
                }
                R.id.navigation_match -> {
                    loadMatchFragment()
                }
            }
            true
        }

        if (savedInstanceState == null) {
            bottom_navigation.selectedItemId = R.id.navigation_league
        }
    }

    private fun loadLeagueFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, LeagueFragment()).commit()
    }

    private fun loadMatchFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container,
                PreviousMatchFragment()
            ).commit()
    }


}

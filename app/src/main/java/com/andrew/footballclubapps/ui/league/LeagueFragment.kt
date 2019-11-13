package com.andrew.footballclubapps.ui.league

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.andrew.footballclubapps.R
import com.andrew.footballclubapps.model.league.LeagueItem
import com.andrew.footballclubapps.ui.detail.LeagueDetailActivity
import kotlinx.android.synthetic.main.fragment_league.*

/**
 * A simple [Fragment] subclass.
 */
class LeagueFragment : Fragment() {

    private var leagueList: MutableList<LeagueItem> = mutableListOf()
    private lateinit var rvLeague: RecyclerView
    private lateinit var adapter: LeagueAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_league, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        initData()
    }

    private fun setupRecyclerView() {
        rvLeague = rv_league
        rvLeague.layoutManager = GridLayoutManager(context, 2)
        rvLeague.setHasFixedSize(true)

        adapter = LeagueAdapter {data ->
            val intent = Intent(requireContext(), LeagueDetailActivity::class.java)
            intent.putExtra(LeagueDetailActivity.EXTRA_LEAGUE_ID, data.leagueId)
            startActivity(intent)
        }
        adapter.setData(leagueList)
        rvLeague.adapter = adapter
    }

    private fun initData() {
        val leagueId = resources.getIntArray(R.array.league_id)
        val dataBadge = resources.getStringArray(R.array.league_badge)
        val dataName = resources.getStringArray(R.array.league_name)

        for (i in dataName.indices) {
            leagueList.add(
                LeagueItem(
                    leagueId[i],
                    dataBadge[i],
                    dataName[i]
                )
            )
        }
    }

}

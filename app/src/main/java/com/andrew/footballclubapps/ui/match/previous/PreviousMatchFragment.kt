package com.andrew.footballclubapps.ui.match.previous


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.andrew.footballclubapps.R
import com.andrew.footballclubapps.model.match.MatchResponse
import com.andrew.footballclubapps.showLoading
import kotlinx.android.synthetic.main.fragment_previous_match.*

/**
 * A simple [Fragment] subclass.
 */
class PreviousMatchFragment : Fragment() {

    private lateinit var viewModel: PreviousMatchViewModel
    private lateinit var adapter: PreviousMatchAdapter

    private val getPreviousMatch =
        Observer<MatchResponse> { previousMatch ->
            if (previousMatch != null) {
                adapter.setData(previousMatch.result)
                showLoading(true, progress_bar)
            }
        showLoading(false, progress_bar)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_previous_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        loadLeagueDetail()
    }

    private fun setupRecyclerView() {
        rvPreviousMatch.layoutManager = LinearLayoutManager(context)
        rvPreviousMatch.setHasFixedSize(true)
        adapter = PreviousMatchAdapter {
            Log.i("info", it.awayTeam.toString())
        }
        rvPreviousMatch.adapter = adapter
    }

    private fun loadLeagueDetail() {
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(PreviousMatchViewModel::class.java)
        viewModel.getPreviousMatch().observe(viewLifecycleOwner, getPreviousMatch)
        viewModel.setPreviousMatch(4328)
    }

}

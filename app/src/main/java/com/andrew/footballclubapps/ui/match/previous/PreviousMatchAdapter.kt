package com.andrew.footballclubapps.ui.match.previous

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andrew.footballclubapps.R
import com.andrew.footballclubapps.model.match.MatchItem
import kotlinx.android.synthetic.main.match_item.view.*

class PreviousMatchAdapter(private val listener: (MatchItem) -> Unit) : RecyclerView.Adapter<PreviousMatchAdapter.PreviousMatchViewHolder>() {

    private var matchs: List<MatchItem> = listOf()

    fun setData(items: List<MatchItem>) {
        matchs = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreviousMatchViewHolder {
        return PreviousMatchViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.match_item, parent, false)
        )
    }

    override fun getItemCount(): Int = matchs.size

    override fun onBindViewHolder(holder: PreviousMatchViewHolder, position: Int) {
        holder.bindItem(matchs[position], listener)
    }

    inner class PreviousMatchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(items: MatchItem, listener: (MatchItem) -> Unit) {
            with(itemView) {
                tv_date_event.text = items.dateEvent
                tv_home_score.text = items.homeScore.toString()
                tv_home_team.text = items.homeTeam
                tv_away_score.text = items.awayScore.toString()
                tv_away_team.text = items.awayTeam
            }
        }
    }
}
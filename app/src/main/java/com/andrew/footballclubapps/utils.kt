package com.andrew.footballclubapps

import android.view.View
import android.widget.ProgressBar
import java.text.SimpleDateFormat
import java.util.*

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun showLoading(state: Boolean, progressBar: ProgressBar) {
    if (state) {
        progressBar.visible()
    } else {
        progressBar.gone()
    }
}

fun toGMTFormat(date: String, time: String): Date? {
    val formatter = SimpleDateFormat("dd/MM/yy HH:mm:ss")
    formatter.timeZone = TimeZone.getTimeZone("UTC")
    val dateTime = "$date $time"
    return formatter.parse(dateTime)
}
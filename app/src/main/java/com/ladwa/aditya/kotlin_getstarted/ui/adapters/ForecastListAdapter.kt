package com.ladwa.aditya.kotlin_getstarted.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.ladwa.aditya.kotlin_getstarted.domain.model.DomainClasses

/**
 *
 * Created by Aditya on 17-Jan-17.
 */
class ForecastListAdapter(val weekForecast: DomainClasses.ForecastList) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    override fun getItemCount(): Int = weekForecast.dailyForecast.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent?.context))
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        with(weekForecast.dailyForecast[position]) {
            holder!!.textView.text = "$date - $description - $high/$low"
        }
    }

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}
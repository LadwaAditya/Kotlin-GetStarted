package com.ladwa.aditya.kotlin_getstarted.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.ladwa.aditya.kotlin_getstarted.R
import com.ladwa.aditya.kotlin_getstarted.domain.model.Forecast
import com.ladwa.aditya.kotlin_getstarted.domain.model.ForecastList
import com.ladwa.aditya.kotlin_getstarted.ui.utils.ctx
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

/**
 *
 * Created by Aditya on 17-Jan-17.
 */
class ForecastListAdapter(val weekForecast: ForecastList,
                          val itemClick: (Forecast) -> Unit) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun getItemCount(): Int = weekForecast.size()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindForecast(weekForecast[position])
    }

    class ViewHolder(view: View,
                     val itemClick: (Forecast) -> Unit)
        : RecyclerView.ViewHolder(view) {
        private val iconView: ImageView
        private val dateView: TextView
        private val descriptionView: TextView
        private val maxTemperatureView: TextView
        private val minTemperatureView: TextView

        init {
            iconView = view.find(R.id.icon)
            dateView = view.find(R.id.date)
            descriptionView = view.find(R.id.description)
            maxTemperatureView = view.find(R.id.maxTemperature)
            minTemperatureView = view.find(R.id.minTemperature)
        }

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.ctx).load(iconUrl).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxTemperatureView.text = "${high.toString()}º"
                minTemperatureView.text = "${low.toString()}º"
                itemView.setOnClickListener { itemClick(this) }

            }
        }
    }


    interface OnItemClickListener {
        operator fun invoke(forecast: Forecast)
    }
}
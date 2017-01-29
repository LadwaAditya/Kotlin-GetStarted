package com.ladwa.aditya.kotlin_getstarted.domain

import com.ladwa.aditya.kotlin_getstarted.ForecastRequest
import java.text.DateFormat
import java.util.*
import com.ladwa.aditya.kotlin_getstarted.ForecastRequest.Forecast as ModelForecast

/**
 *
 * Created by Aditya on 26-Jan-17.
 */
class ForecastDataMapper {

    fun convertFromdataModel(forecast: ForecastRequest.ForecastResult): ForecastRequest.ForecastList {
        return ForecastRequest.ForecastList(
                forecast.city.name, forecast.city.country, convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list: List<ForecastRequest.Forecast>): List<ModelForecast> {
        return list.map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: ForecastRequest.Forecast): ModelForecast {
        return ModelForecast(forecast.date, forecast.description, forecast.high,
                forecast.low)
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }
}
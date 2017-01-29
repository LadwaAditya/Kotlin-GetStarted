package com.ladwa.aditya.kotlin_getstarted.domain

import com.ladwa.aditya.kotlin_getstarted.ForecastRequest
import java.text.DateFormat
import java.util.*
import com.ladwa.aditya.kotlin_getstarted.domain.DomainClasses.Forecast as ModelForecast

/**
 * Created by aditya on 29/1/17.
 */
class ForecastDataMapper {
    fun convertFromDataModel(forecast: ForecastRequest.ForecastResult): DomainClasses.ForecastList {
        return DomainClasses.ForecastList(forecast.city.name, forecast.city.country,
                convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list: List<ForecastRequest.Forecast>):
            List<ModelForecast> {
        return list.map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: ForecastRequest.Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt),
                forecast.weather[0].description, forecast.temp.max.toInt(),
                forecast.temp.min.toInt())
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM,
                Locale.getDefault())
        return df.format(date * 1000)
    }
}
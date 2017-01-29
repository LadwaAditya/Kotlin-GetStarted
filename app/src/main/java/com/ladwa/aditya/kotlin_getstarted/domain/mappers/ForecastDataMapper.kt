package com.ladwa.aditya.kotlin_getstarted.domain.mappers

import com.ladwa.aditya.kotlin_getstarted.data.Forecast
import com.ladwa.aditya.kotlin_getstarted.data.ForecastResult
import com.ladwa.aditya.kotlin_getstarted.domain.model.ForecastList
import java.text.DateFormat
import java.util.*
import com.ladwa.aditya.kotlin_getstarted.domain.model.Forecast as ModelForecast

/**
 *
 * Created by aditya on 29/1/17.
 */
class ForecastDataMapper {
    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(forecast.city.name, forecast.city.country,
                convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>):
            List<ModelForecast> {
        return list.map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt),
                forecast.weather[0].description, forecast.temp.max.toInt(),
                forecast.temp.min.toInt(), generateIconUrl(forecast.weather[0].icon))
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM,
                Locale.getDefault())
        return df.format(date * 1000)
    }

    private fun generateIconUrl(iconCode: String): String = "http://openweathermap.org/img/w/$iconCode.png"
}
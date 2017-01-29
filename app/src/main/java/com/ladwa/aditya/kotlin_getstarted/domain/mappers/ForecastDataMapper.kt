package com.ladwa.aditya.kotlin_getstarted.domain.mappers

import com.ladwa.aditya.kotlin_getstarted.data.Forecast
import com.ladwa.aditya.kotlin_getstarted.data.ForecastResult
import com.ladwa.aditya.kotlin_getstarted.domain.model.DomainClasses
import java.text.DateFormat
import java.util.*
import com.ladwa.aditya.kotlin_getstarted.domain.model.DomainClasses.Forecast as ModelForecast

/**
 *
 * Created by aditya on 29/1/17.
 */
class ForecastDataMapper {
    fun convertFromDataModel(forecast: ForecastResult): DomainClasses.ForecastList {
        return DomainClasses.ForecastList(forecast.city.name, forecast.city.country,
                convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>):
            List<DomainClasses.Forecast> {
        return list.map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): DomainClasses.Forecast {
        return DomainClasses.Forecast(convertDate(forecast.dt),
                forecast.weather[0].description, forecast.temp.max.toInt(),
                forecast.temp.min.toInt())
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM,
                Locale.getDefault())
        return df.format(date * 1000)
    }
}
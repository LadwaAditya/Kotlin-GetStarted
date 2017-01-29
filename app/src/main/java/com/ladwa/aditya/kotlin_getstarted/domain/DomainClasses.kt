package com.ladwa.aditya.kotlin_getstarted.domain

/**
 * Created by aditya on 29/1/17.
 */
class DomainClasses {
    data class ForecastList(val city: String, val country: String,
                            val dailyForecast: List<Forecast>)

    data class Forecast(val date: String, val description: String, val high: Int,
                        val low: Int)
}
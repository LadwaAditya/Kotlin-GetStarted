package com.ladwa.aditya.kotlin_getstarted.domain

import com.ladwa.aditya.kotlin_getstarted.data.ForecastRequest

/**
 * Created by aditya on 29/1/17.
 */
class RequestForecastCommand(val zipCode: String) : Command<DomainClasses.ForecastList> {
    override fun execute(): DomainClasses.ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }

}
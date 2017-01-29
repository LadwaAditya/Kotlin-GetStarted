package com.ladwa.aditya.kotlin_getstarted.domain.commands

import com.ladwa.aditya.kotlin_getstarted.data.ForecastRequest
import com.ladwa.aditya.kotlin_getstarted.domain.mappers.ForecastDataMapper
import com.ladwa.aditya.kotlin_getstarted.domain.model.DomainClasses

/**
 * Created by aditya on 29/1/17.
 */
class RequestForecastCommand(val zipCode: String) : Command<DomainClasses.ForecastList> {
    override fun execute(): DomainClasses.ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }

}
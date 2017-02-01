package com.ladwa.aditya.kotlin_getstarted.domain.commands

import com.ladwa.aditya.kotlin_getstarted.data.ForecastRequest
import com.ladwa.aditya.kotlin_getstarted.domain.mappers.ForecastDataMapper
import com.ladwa.aditya.kotlin_getstarted.domain.model.ForecastList

/**
 *
 * Created by aditya on 29/1/17.
 */
class RequestForecastCommand(private val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }

}
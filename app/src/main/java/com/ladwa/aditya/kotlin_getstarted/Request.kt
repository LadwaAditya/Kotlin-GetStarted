package com.ladwa.aditya.kotlin_getstarted

import android.util.Log
import java.net.URL
import java.util.*

/**
 *
 * Created by Aditya on 20-Jan-17.
 */
class Request(val url: String) {

    fun run() {
        val forcastJson = URL(url).readText()
        Log.d(javaClass.simpleName, forcastJson)
    }

    data class Forecast(val date: Date, val temperature: Float, val details: String)
}
package com.ladwa.aditya.kotlin_getstarted

import android.app.Application

/**
 * Application file
 * Created by Aditya on 1/2/17.
 */
class App : Application() {

    companion object {
        private var instance: Application? = null
        fun instance() = instance!!
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
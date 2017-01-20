package com.ladwa.aditya.kotlin_getstarted

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread
import java.util.*
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
    private val items = listOf<String>(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7"
    )

    val url = "http://api.openweathermap.org/data/2.5/forecast/city?id=524901&APPID=1111111111"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val foreCastList = findViewById(R.id.list) as RecyclerView
        foreCastList.layoutManager = LinearLayoutManager(this)
        foreCastList.adapter = ForecastListAdapter(items)




        fun Context.myToast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
            Toast.makeText(this, message, duration).show()
        }

        myToast("Hello")
    }
}

package com.ladwa.aditya.kotlin_getstarted

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val foreCastList = findViewById(R.id.list) as RecyclerView
        foreCastList.layoutManager = LinearLayoutManager(this)
        foreCastList.adapter = ForecastListAdapter(items)

        val i: Int = 2
        val d: Double = i.toDouble()

        val c: Char = 'c'
        val num: Int = c.toInt()



    }
}

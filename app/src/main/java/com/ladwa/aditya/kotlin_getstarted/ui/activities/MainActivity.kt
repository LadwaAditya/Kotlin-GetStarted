package com.ladwa.aditya.kotlin_getstarted.ui.activities

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import com.ladwa.aditya.kotlin_getstarted.R
import com.ladwa.aditya.kotlin_getstarted.domain.commands.RequestForecastCommand
import com.ladwa.aditya.kotlin_getstarted.ui.adapters.ForecastListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        forecastList.layoutManager = LinearLayoutManager(this)
        forecastList.setHasFixedSize(true)
        doAsync {
            val result = RequestForecastCommand("94043").execute()
            uiThread {
                forecastList.adapter = ForecastListAdapter(result) { toast(it.date) }
                Log.d("Tag", "Received data")
            }
        }


        fun Context.myToast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
            Toast.makeText(this, message, duration).show()
        }

        myToast("Hello")
    }
}

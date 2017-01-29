package com.ladwa.aditya.kotlin_getstarted

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.ladwa.aditya.kotlin_getstarted.domain.RequestForecastCommand
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val foreCastList = findViewById(R.id.list) as RecyclerView
        foreCastList.layoutManager = LinearLayoutManager(this)
        foreCastList.setHasFixedSize(true)
        doAsync {
            val result = RequestForecastCommand("94043").execute()
            uiThread {
                foreCastList.adapter = ForecastListAdapter(result)
                Log.d("Tag", "Received data")
            }
        }


        fun Context.myToast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
            Toast.makeText(this, message, duration).show()
        }

        myToast("Hello")
    }
}

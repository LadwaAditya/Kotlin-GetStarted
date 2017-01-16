package com.ladwa.aditya.kotlin_getstarted

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textHello.text = "Hello Kotlin"

        fun toast(string: String, length: Int = Toast.LENGTH_SHORT) {
            Toast.makeText(this, string, length).show()
        }

        fun toast(string: String, length: Int = Toast.LENGTH_SHORT, tag: String = MainActivity::class.java.simpleName) {
            Toast.makeText(this, "[$tag] [$string]", length).show()
        }
    }

    open class Animal(name: String)

    class Person(name: String, surname: String) : Animal("Dog") {
        init {
            Log.d("TAG", "Init")
        }

        fun add(x: Int, y: Int): Int {
            return x + y
        }

        fun subtract(x: Int, y: Int) = x - y
    }
}

package ru.example.mynewapplication

import android.app.Application

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Dap.init(this)
    }
}
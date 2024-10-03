package com.example.testhh1.app

import android.app.Application
import com.example.testhh1.di.components.AppComponent
import com.example.testhh1.di.components.DaggerAppComponent

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(this)
    }

    companion object {
        lateinit var appComponent: AppComponent
            private set
    }
}
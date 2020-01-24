package com.example.myapplication.application

import android.app.Application
import com.example.myapplication.networkmodule.networkmodule
import com.example.myapplication.networkmodule.statemodule
import org.koin.android.ext.android.startKoin


class KoinApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(networkmodule, statemodule))
        //  setProperty("staging_url", "http://10.95.21.14:6065/api/Service/VirtualPackCreation/")
    }
}
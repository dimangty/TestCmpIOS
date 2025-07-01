package com.example.testcmp.android

import android.app.Application
import com.example.testcmp.sharedModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(sharedModule)
        }
    }
}
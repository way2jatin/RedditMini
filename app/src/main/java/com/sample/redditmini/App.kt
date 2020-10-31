package com.sample.redditmini

import android.app.Application
import com.sample.redditmini.di.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        //Koin Module initialization
        startKoin {
            androidContext(this@App)
            modules(listOf(viewModelModule))
        }

    }
}
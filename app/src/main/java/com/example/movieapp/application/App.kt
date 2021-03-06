package com.example.movieapp.application

import android.app.Application
import com.example.movieapp.di.Di
import org.koin.android.ext.koin.androidContext

import org.koin.core.context.startKoin


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(Di.mainModule)
        }
    }

    init {
        instance = this
    }

//    val databaseService: Database by lazy { Database.createDatabase(applicationContext) }


    companion object {
        lateinit var instance: App
            private set
    }
}

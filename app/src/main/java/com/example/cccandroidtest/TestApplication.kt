package com.example.cccandroidtest

import android.app.Application
import com.example.cccandroidtest.dagger.AppComponent
import com.example.cccandroidtest.dagger.DaggerAppComponent

class TestApplication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .bind(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent
    }

    companion object {
        private var instance: TestApplication? = null

        fun appComponent(): AppComponent = instance!!.appComponent
    }
}
package com.example.cccandroidtest.utils

import android.util.Log
import com.example.cccandroidtest.BuildConfig

interface MyLogger {

    fun log(obj: Any?) {
        if (BuildConfig.DEBUG) {
            Log.d("Mylog${javaClass.name}", obj.toString())
        }
    }

    fun log(obj: Any?, ex: Throwable) {
        if (BuildConfig.DEBUG) {
            Log.d("Mylog${javaClass.name}", obj.toString(), ex)
        }
    }
}
package com.subhag.inshortsclone

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NewsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d(LOG_TAG,"")
    }

    companion object {

        var LOG_TAG: String = NewsApplication::class.java.simpleName

    }

}
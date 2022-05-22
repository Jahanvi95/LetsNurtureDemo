package com.example.demoapplication.service

import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication


class MyApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: MyApplication
            private set

        val context: Context
            get() = instance.applicationContext
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(base) //not this use base. MultiDex.install(this); this will lead to some error in some prelolipop device.
    }


//    override fun attachBaseContext(newBase: Context?) {
//        super.attachBaseContext(
//            LocaleHelper.onAttach(newBase!!,
//            newBase.customPrefs().getString(AppConstants.PREFERECENCE_UTILLS.LANGUAGE, "").toString()
//        ))
//
//    }

}
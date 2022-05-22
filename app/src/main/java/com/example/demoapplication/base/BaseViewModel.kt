package com.glowdubai_staff.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.glowdubai_staff.base.PreferenceHelper.customPrefs


abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {

    var token = ""

    val prefs by lazy {
        application.customPrefs()
    }



}

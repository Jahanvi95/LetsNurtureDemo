package com.example.demoapplication.base

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding


abstract class BaseBindingActivity<T> : BaseActivity() where T : ViewDataBinding {

    protected abstract val layoutId: Int
    protected lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.layoutDirection = View.LAYOUT_DIRECTION_LTR

        binding = DataBindingUtil.setContentView(this, layoutId)
        initView()
        //generateFcmToken()
    }

    protected abstract fun initView()

    /* fun generateFcmToken(): String {
         FirebaseMessaging.getInstance().token.addOnCompleteListener {
             if (!it.isSuccessful) {
                 Log.w("Glow_Dubai", "Fetching FCM registration token failed", it.exception!!)
                 return@addOnCompleteListener
             }
             // Get new FCM registration token
             token = it.result.toString()
             prefs.put(AppConstants.PREFERECENCE_UTILLS.DEVICE_TOKEN, token)
         }
         return token
     }*/

    override fun onDestroy() {
        super.onDestroy()
        Log.e("data", "data")
        viewModelStore.clear()

    }


}

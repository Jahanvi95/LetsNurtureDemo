package com.example.demoapplication.base


import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.example.demoapplication.R
import com.glowdubai_staff.base.PreferenceHelper.customPrefs
import com.glowdubai_staff.service.NetworkViewModel
import com.glowdubai_staff.service.ProgressUtils


abstract class BaseActivity : AppCompatActivity() {

    lateinit var prefs: SharedPreferences

    var token = ""
    private val networkViewModel: NetworkViewModel by lazy {
        ViewModelProvider(this)[NetworkViewModel::class.java]
    }
    var onCreateNetwork = false
    var mProgressUtil: ProgressUtils? = null
    var notificationCount: MutableLiveData<Int> = MutableLiveData(0)


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prefs = customPrefs()

        networkViewModel.enableNetworkListener(this)
        listenNetworkState()
        initProgress()



    }


    /**
     * Set Status bar color
     */
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun addStatusBarColor() {
        val window: Window = window
// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
// finally change the color
        window.statusBarColor = ContextCompat.getColor(this, R.color.black)

    }


    private fun initProgress() {
        if (mProgressUtil == null)
            mProgressUtil = ProgressUtils(lifecycle, this)
    }

    fun showProgress(
        isCancelable: Boolean = false,
        message: String = "",
        mainMessage: String = "",
    ) {
        runOnUiThread {
            initProgress()
            mProgressUtil?.show(isCancelable, message, mainMessage)
        }
    }

    fun hideProgress() {
        runOnUiThread {
            initProgress()
            mProgressUtil?.hide()
        }
    }

    private fun listenNetworkState() {
        networkViewModel.networkLiveData.observe(this,
            { t ->
                if (!t!!) {
                    onNetWorkChange(t)
                }
            })
    }

    /**
     * on network change this method will call
     */
    abstract fun onNetWorkChange(onNetworkChange: Boolean)


    fun setFullScreen(isFull: Boolean = false) {
        if (isFull) {

            this.window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
    }


    override fun onPause() {
        super.onPause()
        networkViewModel.disableNetworkListener(this)
    }




//    open fun initToolbar(
//        textName: AppCompatTextView = findViewById(R.id.txtHome),
//        name: String = "",
//        isImgBack: Boolean = false,
//        imageBack: AppCompatImageView? = findViewById(R.id.imgBack),
//        isImgDrawer: Boolean = false,
//        ImgDrawer: AppCompatImageView? = findViewById(R.id.imgDrawer),
//        isNotification: Boolean = true,
//        ImgNotification: ConstraintLayout? = findViewById(R.id.layoutNotification)
//        ) {
//        textName.text = name
//        imageBack?.visibilityGone(isImgBack)
//        ImgDrawer?.visibilityGone(isImgDrawer)
//        ImgNotification?.visibilityGone(isNotification)
//        imageBack!!.setOnClickListener {
//            onBackPressed()
//        }
//    }


}
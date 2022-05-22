package com.glowdubai_staff.service

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.example.demoapplication.R
import com.example.demoapplication.service.CustomProgressDialog
import com.example.demoapplication.utills.ResourceUtils.getDimen
import com.example.demoapplication.utills.isAlive


class ProgressUtils : LifecycleObserver {

    private val mContext: Context?
    private var mProgressDialog: CustomProgressDialog? = null

    constructor(lifecycle: Lifecycle, context: Context) {
        mContext = context
        // Starts lifecycle observation
        lifecycle.addObserver(this)
    }

    constructor(m_Context: Context) {
        this.mContext = m_Context
    }

    // Progress bar initialise.
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun init() {
        if (null == mProgressDialog && mContext != null) {
            mProgressDialog = CustomProgressDialog(mContext)
        }
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        remove()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        try {
            remove()
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    // Destroy Progress Dialog
    fun remove() {
        if (mProgressDialog == null)
            return
        mProgressDialog?.let {
            if (it.isShowing)
                hide()
        }
        mProgressDialog = null
    }

    // Show Progress Dialog
    @JvmOverloads
    fun show(isCancel: Boolean = false, message: String = "", mainMessage: String = "") {
        if (mContext == null || !mContext.isAlive()) return
        if (mProgressDialog == null)
            init()
        //val view: View = getActivity(mContext)!!.getLayoutInflater().inflate(R.layout.layout_progress, null)
        mProgressDialog!!.window!!.decorView.setBackgroundResource(android.R.color.transparent)
        //mProgressDialog!!.setView(view)
        mProgressDialog!!.window!!.setLayout(
            getDimen(R.dimen._160sdp).toInt(),
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        mProgressDialog?.setTitle(null)
        mProgressDialog?.setCancelable(isCancel)
        mProgressDialog?.setDisplayMessages()
        val dialogLayout = LayoutInflater.from(mContext).inflate(R.layout.layout_progress, null)
        mProgressDialog!!.setContentView(dialogLayout)
        mProgressDialog!!.show()


    }

    /**
     * Hide Progress dialog
     */
    fun hide() {
        if (mProgressDialog == null)
            return
        mProgressDialog?.let {
            if (it.isShowing)
                it.dismiss()
        }
    }

}

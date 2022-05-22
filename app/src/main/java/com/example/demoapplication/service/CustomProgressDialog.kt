package com.example.demoapplication.service

import android.app.Dialog
import android.content.Context


class CustomProgressDialog(context: Context) : Dialog(context) {

    var secondaryMessage: String? = ""
        set(value) {
            field = showProgressMessage(value)
        }

    private fun showProgressMessage(value: String?): String? {
        /* if (message.isNullOrEmpty() || message.isNullOrBlank()) {
            message = ""
            txtsave?.visibility = View.GONE
        } else {
            txtsave?.visibility = View.VISIBLE
        }
        txtsave?.text = message*/
        return value?.trim()
    }

    var primaryMessage: String? = ""
        set(value) {
            field = showMainMessage(value)
        }

    /*private fun fetchAccentColor(): Int {
        val typedValue = TypedValue()

        val a = context.obtainStyledAttributes(typedValue.data, intArrayOf(R.color.window_background))
        val color = a.getColor(0, 0)

        a.recycle()

        return color
    }*/

    private fun showMainMessage(value: String?): String {
      /*  var message = value?.trim()
        if (message.isNullOrBlank()) {
            message = context.getString(R.string.str_processing)
        }*/
      //  txtProgress?.text = message
        return ""
    }

    fun setDisplayMessages() {
        showProgressMessage(secondaryMessage)
        showMainMessage(primaryMessage)
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        //window!!.requestFeature(Window.FEATURE_PROGRESS)
//       // setContentView(R.layout.layout_progress)
//    }

    override fun hide() {
        clearMessage()
        super.hide()
    }

    private fun clearMessage() {
        secondaryMessage = ""
        primaryMessage = ""
    }

    override fun dismiss() {
        clearMessage()
        super.dismiss()
    }

}

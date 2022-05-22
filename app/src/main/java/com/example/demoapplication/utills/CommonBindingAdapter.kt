package com.example.demoapplication.utills

import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.webkit.WebView
import android.widget.CompoundButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.demoapplication.R

import com.google.android.material.textfield.TextInputEditText

import java.text.SimpleDateFormat
import java.util.*

object CommonBindingAdapter {

    @BindingAdapter(value = ["inputFormat", "outputFormat", "inputDate"], requireAll = false)
    @JvmStatic
    fun AppCompatTextView.getFormattedDate(
        inputFormat: String = "yyyy-MM-dd",
        outputFormat: String,
        inputDate: String,
    ) {

        val inputFormat = inputFormat
        var outputFormat = outputFormat
        if (outputFormat == "") {
            outputFormat =
                "EEEE d 'de' MMMM 'del' yyyy" // if inputFormat = "", set a default output format.
        }
        var parsed: Date? = null
        var outputDate = ""
        val dfInput = SimpleDateFormat(inputFormat, Locale.UK)
        val dfOutput = SimpleDateFormat(outputFormat, Locale.UK)
        try {
            parsed = dfInput.parse(inputDate)
            outputDate = dfOutput.format(parsed).replace(".", "")
        } catch (e: Exception) {
            Log.e(
                "formattedDateFromString",
                "Exception in formate Date From string(): " + e.message
            )
            e.printStackTrace()
        }
        this.text = outputDate

    }


    @BindingAdapter("roundedImageUrl")
    @JvmStatic
    fun bindRecyclerViewAdapter(view: AppCompatImageView, imageUrl: String?) {
        if (imageUrl != null) {
            // If we don't do this, you'll see the old image appear briefly
            // before it's replaced with the current image
//            Glide.with(view.context).load(imageUrl).placeholder(R.drawable.app_icon)
//                .apply(RequestOptions.circleCropTransform())
//                .into(view);
        } else {
//            Glide.with(view.context).load(R.drawable.app_icon).placeholder(R.drawable.app_icon)
//                .apply(RequestOptions.circleCropTransform())
//                .into(view);
        }
    }


    @BindingAdapter("imageUrl")
    @JvmStatic
    fun loadImage(view: AppCompatImageView, url: String?) {
        if (!url.isNullOrEmpty()) {
            //  Glide.with(view.context).load(url).placeholder(R.drawable.app_icon).into(view)
        }
    }

    @BindingAdapter("imageRoundUrl")
    @JvmStatic
    fun loadRoundImage(view: AppCompatImageView, url: String?) {
        if (!url.isNullOrEmpty()) {
            Glide.with(view.context).load(url)
                .apply(RequestOptions.circleCropTransform())
                .into(view)
        }
    }


    @BindingAdapter("setReyclerViewAdapter")
    @JvmStatic
    fun bindRecyclerViewAdapter(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<*>?) {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
        recyclerView.adapter = adapter
    }

    @BindingAdapter(value = ["text"], requireAll = false)
    @JvmStatic
    fun AppCompatTextView.setText(data: String) {
        if (data.isNotEmpty()) {
            this.text = data
        } else {
            this.text = this.context.getString(R.string.str_n_a)
        }
    }


    @BindingAdapter("setReyclerViewGridAdapter")
    @JvmStatic
    fun bindRecyclerViewGridAdapter(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<*>?) {
        val spanCount = 2
        val spacing = 15
        val includeEdge = true
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(recyclerView.context, 2)
        recyclerView.adapter = adapter
    }


    interface OnUserCheckedChangeListener {
        fun onUserCheckChange(view: CompoundButton, isChecked: Boolean)
    }

    @BindingAdapter("setMarquee")
    @JvmStatic
    fun setMarquee(view: AppCompatTextView, direction: Integer) {

        view.isSelected = true
        view.ellipsize = TextUtils.TruncateAt.MARQUEE
        view.marqueeRepeatLimit = -1
        view.isSingleLine = true
        view.isSelected = true

    }


    @BindingAdapter("onUserCheckedChange")
    @JvmStatic
    fun setUserCheckedChangeListener(view: CompoundButton, listener: OnUserCheckedChangeListener?) {
        if (listener == null) {
            view.setOnClickListener(null)
        } else {
            view.setOnClickListener {

            }
        }
    }


    @BindingAdapter("requestFocusValidation")
    @JvmStatic
    fun requestFocus(editText: TextInputEditText, requestFocus: Boolean) {
        if (requestFocus) {
            editText.requestFocus()
        }
    }

    @BindingAdapter("emailTextChangedListener")
    @JvmStatic
    fun onTextChanged(et: TextInputEditText, data: String) {
        et.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                val result: String = data
                if (result.isNotEmpty() && result.contains(" ")) {
                    et.setText(et.text.toString().replace(" ", ""))
                    et.setSelection(et.text!!.length)
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable) {}
        })

    }

    /**
     * @param recyclerView  RecyclerView to bind to RecyclerViewScrollCallback
     * @param visibleThreshold  The minimum number of items to have below your current scroll position before loading more.
     * @param resetLoadingState  Reset endless scroll listener when performing a new search
     * @param onScrolledListener    OnScrolledListener for RecyclerView scrolled
     */
    @JvmStatic
    @BindingAdapter(
        value = *arrayOf(
            "visibleThreshold",/* "resetLoadingState",*/
            "onScrolledToBottom"
        ), requireAll = false
    )
    fun setRecyclerViewScrollCallback(
        recyclerView: RecyclerView, visibleThreshold: Int,/* resetLoadingState: Boolean,*/
        onScrolledListener: EndlessRecyclerViewScrollListener.OnScrolledListener
    ) {

        val callback = EndlessRecyclerViewScrollListener
            .Builder(recyclerView.layoutManager!!)
            .visibleThreshold(10)
            .onScrolledListener(onScrolledListener)
            //  .resetLoadingState(resetLoadingState)
            .build()

        recyclerView.clearOnScrollListeners()
        recyclerView.addOnScrollListener(callback)
    }


    @BindingAdapter("emailSetOnEditorActionListener")
    @JvmStatic
    fun onEditListener(et: TextInputEditText, data: String) {
        et.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                val result: String = data
                if (result.isNotEmpty() && result.last().toString() != ",") {
                    et.setText(data.trim() + ",")
                    et.setSelection(et.text!!.length)
                }
                true
            } else {
                false
            }
        }

    }

    @JvmStatic
    @BindingAdapter("visibleGoneMainView")
    fun showHideMainView(view: View, show: Boolean) {
        view.visibility = if (show) View.VISIBLE else View.INVISIBLE
    }

    @JvmStatic
    @BindingAdapter("visibleGoneNoData")
    fun showHideNoData(view: View, show: Boolean) {
        view.visibility = if (show) View.VISIBLE else View.GONE
    }


    @BindingAdapter("loadUrl")
    @JvmStatic
    fun WebView.setUrl(url: String) {
        this.loadUrl(url)
    }

    interface OnSoundChangeListener {
        fun onSoundChange(view: View)
    }


}



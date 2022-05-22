package com.glowdubai_staff.base

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.AutoCompleteTextView
import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


class CommonTextChange : CoroutineScope {

    private var position: Int? = 0
    private lateinit var textChangeListener: TextChangeListener
    private var searchFor = ""
    override val coroutineContext: CoroutineContext = Dispatchers.Main
    private var textChangeJob: Job? = null

    fun setCallback(callback: TextChangeListener): CommonTextChange {
        this.textChangeListener = callback
        return this
    }

    fun registerTextInputEditText(
        editText: TextInputEditText,
        position: Int = 0
    ): CommonTextChange {
        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(txt: Editable?) {
                Log.e("data change", txt.toString())
                // do our magic here
                txt.let {
                    textChangeListener.onAfterTextChanged(
                        position = position,
                        data = txt.toString().trim()
                    )
                }
            }
            override fun beforeTextChanged(txt: CharSequence, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(txt: CharSequence, start: Int, before: Int, count: Int) {
            }
        })
        return this
    }

    fun registerDelayTextInputEditText(
        editText: TextInputEditText,
        position: Int = 0
    ): CommonTextChange {
        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(txt: Editable?) {
                val searchText = txt.toString().trim()
                textChangeJob?.cancel()
                Log.e("delay data change", txt.toString())
                if (searchText == searchFor)
                    return
                searchFor = searchText
                textChangeJob = GlobalScope.launch(Dispatchers.Main) {
                    delay(1000L)  //debounce timeOut
                    if (searchText != searchFor)
                        return@launch
                    // do our magic here
                    if (editText.hasFocus()) {
                        txt.let {
                            textChangeListener.onAfterTextChanged(
                                position = position,
                                data = txt.toString().trim()
                            )
                        }
                    }
                }
            }
            override fun beforeTextChanged(txt: CharSequence, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(txt: CharSequence, start: Int, before: Int, count: Int) {
            }
        })
        return this
    }

    fun registerEditText(editText: EditText, position: Int = 0): CommonTextChange {
        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(txt: Editable?) {

                val searchText = txt.toString().trim()
                textChangeJob?.cancel()
                Log.e("delay data change", txt.toString())
                if (searchText == searchFor)
                    return
                searchFor = searchText
                textChangeJob = GlobalScope.launch(Dispatchers.Main) {
                    delay(2000L)  //debounce timeOut
                    if (searchText != searchFor)
                        return@launch
                    // do our magic here
                    Log.e("data change", txt.toString())
                    txt.let {
                        textChangeListener.onAfterTextChanged(
                            position = position,
                            data = txt.toString().trim()
                        )
                    }
                }

            }
            override fun beforeTextChanged(txt: CharSequence, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(txt: CharSequence, start: Int, before: Int, count: Int) {
            }
        })
        return this
    }

    fun registerAutoCompleteTextView(editText: AutoCompleteTextView, position: Int = 0): CommonTextChange {
        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(txt: Editable?) {
                Log.e("data change", txt.toString())
                txt.let {
                    textChangeListener.onAfterTextChanged(
                        position = position,
                        data = txt.toString().trim()
                    )
                }
            }
            override fun beforeTextChanged(txt: CharSequence, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(txt: CharSequence, start: Int, before: Int, count: Int) {
            }
        })
        return this
    }
}
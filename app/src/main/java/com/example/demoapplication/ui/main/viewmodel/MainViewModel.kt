package com.example.demoapplication.ui.main.viewmodel

import android.app.Application
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.demoapplication.model.locationResponse.response.Data
import com.example.demoapplication.service.ApiResponse
import com.example.demoapplication.ui.main.repository.MainRepository
import com.glowdubai_staff.base.BaseViewModel
import kotlinx.coroutines.launch


class MainViewModel(
    private val mainRepository: MainRepository,
    application: Application,
) : BaseViewModel(application) {

    private val mContext = application.applicationContext

    val status: MediatorLiveData<Any> by lazy {
        MediatorLiveData<Any>()
    }


    val isRecyclerViewVisible: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>(true)
    }

    val locationList : MutableLiveData<ArrayList<Data>> by lazy {
        MutableLiveData<ArrayList<Data>>(ArrayList())
    }

    val isNoDataVisible: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>(false)
    }

    val latitude: MutableLiveData<String> by lazy {
        MutableLiveData<String>("")
    }

    val logitutde: MutableLiveData<String> by lazy {
        MutableLiveData<String>("")
    }

    init {

    }


    /**
     * location API
     */
    fun callLocationAsync(latitude: String, longitude: String,page : String = "1") {

        viewModelScope.launch {
            status.postValue(ApiResponse.create<Boolean>(isLoadingShow = true))
            status.addSource(mainRepository.callLocationAsync(latitude, longitude,page)) {
                status.postValue(ApiResponse.create<Boolean>(isLoadingShow = false))
                status.value = it
            }
        }
    }


    /*
    *     private fun isLogInValid() {
        try {
            when {
                loginViewModel.forgotemail.value!!.trim().isBlank() -> {
                    loginViewModel.status.postValue(Validation<String>(getString(R.string.str_val_blank_email)))
                }
                !loginViewModel.forgotemail.value.toString()
                    .validEmail(loginViewModel.forgotemail.value!!, this) -> {
                    loginViewModel.status.postValue(Validation<String>(getString(R.string.str_val_email)))
                }
                loginViewModel.passwrod.value!!.trim().isBlank() -> {
                    loginViewModel.status.postValue(Validation<String>(getString(R.string.str_val_blank_pin)))
                }
                loginViewModel.passwrod.value!!.toString().trim().length < 6 -> {
                    loginViewModel.status.postValue(Validation<String>(getString(R.string.str_pin_length)))
                }
               /* !loginViewModel.passwrod.value!!.toString().trim().isValidPassword() ->{
                    loginViewModel.status.postValue(Validation<String>(getString(R.string.str_password_length)))
                }*/
                !loginViewModel.isTerms.value!! -> {
                    loginViewModel.status.postValue(Validation<String>(getString(R.string.str_val_agree_terms)))
                }
                else -> {
                    loginViewModel.callLoginAsync(PASS)
                }

            }
        } catch (e: Exception) {

        }

    }

    *
    * */

}
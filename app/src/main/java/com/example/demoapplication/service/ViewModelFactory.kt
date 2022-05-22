package com.example.demoapplication.service

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.demoapplication.ui.main.repository.MainRepository
import com.example.demoapplication.ui.main.viewmodel.MainViewModel


class ViewModelFactory(private val apiHelper: ApiHelper, private val application: MyApplication) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepository(apiHelper), application) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }


}


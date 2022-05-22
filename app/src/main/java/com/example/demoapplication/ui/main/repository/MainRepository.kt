package com.example.demoapplication.ui.main.repository

import com.example.demoapplication.service.ApiHelper


class MainRepository(private val apiHelper: ApiHelper) {

    fun callLocationAsync(
        latitude: String, longitude: String,page : String
    ) = run {
        apiHelper.callLocationAsync(latitude, longitude,page)
    }


}
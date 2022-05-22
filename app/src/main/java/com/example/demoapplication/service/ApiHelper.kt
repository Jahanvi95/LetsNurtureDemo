package com.example.demoapplication.service


class ApiHelper(private val apiService: APIServices) {

    fun callLocationAsync(latitude: String, longitude: String,page : String) =
        apiService.callLocationAsync(latitude,longitude,page)

}
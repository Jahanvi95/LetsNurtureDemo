package com.example.demoapplication.model.locationResponse.response

import com.glowdubai_staff.BaseData

data class Data(
    val _id: String,
    val address: String,
    val distance: Double,
    val image: String,
    val isFavorite: Boolean,
    val isOffer: Boolean,
    val is_restaurant_open: Boolean,
    val lat: Double,
    val lon: Double,
    val name: String,
    val open_hour: OpenHour,
    val photos: List<String>,
    val rating: Int,
    val res_description: String,
    val zip_code: String
):BaseData
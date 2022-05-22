package com.example.demoapplication.model.locationResponse.response

data class LocationResponse(
    val currentPage: String,
    val `data`: List<Data>,
    val latitude: String,
    val logging: String,
    val message: String,
    val status: Int,
    val totalCount: Int,
    val totalPage: Int
)
package com.example.demoapplication.service

import androidx.lifecycle.LiveData
import com.example.demoapplication.model.locationResponse.response.LocationResponse
import com.example.demoapplication.utills.AppConstants
import retrofit2.http.*


interface APIServices {


    @GET(AppConstants.APICONSTANTS.SEARCH_RESTURANT)
    fun callLocationAsync(
        @Query("latitude") lang_id: String,
        @Query("longitude") longitude: String,
        @Query("page") page: String,
        ): LiveData<ApiResponse<LocationResponse>>

 /*   @POST(AppConstants.APICONSTANTS.MODE_MEDICINE_CATEGORY_BY_ID)
    fun callMedicineCategoryByIDAsync(
        @Header(AppConstants.APICONSTANTS.ACCEPT) headerName1: String = AppConstants.APICONSTANTS.HEADER,
        @Header(AppConstants.APICONSTANTS.APIKEY) headerName2: String = AppConstants.APICONSTANTS.HEADERAPI,
        @Header("Authorization") token: String,
        @Body request: MedicalCategoryByIDRequest
    ): LiveData<ApiResponse<MedicalCategoryByIdResponse>>*/

}
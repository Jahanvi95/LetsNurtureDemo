package com.example.demoapplication.service

import android.util.Log
import com.example.demoapplication.R
import com.example.demoapplication.utills.AppConstants
import com.example.demoapplication.utills.ResourceUtils.getString
import com.google.gson.Gson
import org.json.JSONObject
import retrofit2.Response


internal const val UNKNOWN_CODE = -1

sealed class ApiResponse<T> {

    companion object {
        fun <T> create(response: Response<T>): ApiResponse<T> {
            return if (response.isSuccessful) {
                //added
                ApiLoading<Boolean>(false)
                val body = response.body()
                val jsonObj = Gson().toJson(body)
                val jsonStatus = JSONObject(jsonObj).optInt(
                    AppConstants.STATUS_CODE.STATUS_CODE,
                    AppConstants.STATUS_CODE.STATUS_200
                )
                val jsonMessage =
                    if (JSONObject(jsonObj).optString(AppConstants.Message) != null || JSONObject(
                            jsonObj
                        ).optString(AppConstants.Message).isNotEmpty()
                    ) JSONObject(jsonObj).optString(AppConstants.Message) else
                        getString(R.string.str_some_issue)

                // send error when status code is not 200
                if (jsonStatus != AppConstants.STATUS_CODE.STATUS_200) {
                    ApiLoading<Boolean>(isLoadingShow = false)
                }
                when (jsonStatus) {
                    AppConstants.STATUS_CODE.STATUS_200 -> {
                        ApiLoading<Boolean>(false)
                        if (body == null) {
                            ApiEmptyResponse()
                        } else {
                            ApiSuccessResponse(body)
                        }
                    }
                    AppConstants.STATUS_CODE.STATUS_400 -> {
                        ApiErrorResponse(jsonStatus, jsonMessage)
                        /*  showNewCustomMessageView(
                              AppConstants.ERROR,
                              jsonMessage,
                              object : View.OnClickListener {
                                  override fun onClick(p0: View?) {

                                  }
                              })*/
                    }
                    AppConstants.STATUS_CODE.STATUS_401 -> {
                        // data.value = Resource.UnAuthorized<String>(jsonMessage)
                        //context.showAuthCodeDialog()
                        ApiErrorResponse(jsonStatus, jsonMessage)
                    }
                    AppConstants.STATUS_CODE.STATUS_500 -> {
                        /*  context.showNewCustomMessageView(
                              AppConstants.ERROR,
                              jsonMessage,
                              object : View.OnClickListener {
                                  override fun onClick(p0: View?) {

                                  }
                              })*/
                        ApiErrorResponse(jsonStatus, jsonMessage)
                    }
                    else -> {
                        /*  data.value = Resource.Error<String>(jsonMessage, jsonStatus)
                          context.showNewCustomMessageView(
                              AppConstants.ERROR,
                              context.getString(R.string.str_some_issue),
                              object : View.OnClickListener {
                                  override fun onClick(p0: View?) {

                                  }
                              })*/
                        Log.e("json sattaus", jsonStatus.toString())
                        ApiErrorResponse(jsonStatus, jsonMessage)
                    }
                }
            } else {
                val body = response.errorBody()!!.string()
                ApiLoading<Boolean>(false)
                val jsonStatus = JSONObject(body).optInt("Status")
                val jsonMessage =
                    if (JSONObject(body).optString(AppConstants.Message) != null || JSONObject(body).optString(
                            AppConstants.Message
                        ).isNotEmpty()
                    ) JSONObject(body).optString(AppConstants.Message) else
                        getString(R.string.str_some_issue)
                // data.value = Resource.Error<String>(jsonMessage, jsonStatus)

                when (jsonStatus) {
                    AppConstants.STATUS_CODE.STATUS_400 -> {
                        ApiErrorResponse(jsonStatus, jsonMessage)

                    }

                    AppConstants.STATUS_CODE.STATUS_401 -> {
                        ApiErrorResponse(jsonStatus, jsonMessage)
                    }
                    AppConstants.STATUS_CODE.STATUS_500 -> {
                        ApiErrorResponse(jsonStatus, jsonMessage)
                    }
                    else -> {
                        ApiErrorResponse(jsonStatus, jsonMessage)
                    }
                }
            }
        }

        fun <T> create(errorCode: Int, error: Throwable): ApiErrorResponse<T> {
            return ApiErrorResponse(errorCode, error.message ?: "Unknown Error!")
        }

        fun <T> create(isLoadingShow: Boolean): ApiLoading<T> {
            return ApiLoading(isLoadingShow = isLoadingShow)
        }

        fun <T> network(isNetwork: Boolean): NoInternet<T> {
            return NoInternet(isNetworkAvailable = isNetwork)
        }
    }
}


class ApiEmptyResponse<T> : ApiResponse<T>()
data class ApiErrorResponse<T>(val errorCode: Int, val errorMessage: String?) : ApiResponse<T>()
data class ApiSuccessResponse<T>(val body: T) : ApiResponse<T>()
data class ApiLoading<T>(val isLoadingShow: Boolean = false) : ApiResponse<T>()
data class NoInternet<T>(val isNetworkAvailable: Boolean) : ApiResponse<T>()
data class Validation<T>(val message: String) : ApiResponse<T>()


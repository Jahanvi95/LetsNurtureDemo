package com.example.demoapplication.service

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import com.example.demoapplication.utills.isNetworkConnected
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.concurrent.atomic.AtomicBoolean

class LiveDataCallAdapter<R>(private val responseType: Type) :
    CallAdapter<R, LiveData<ApiResponse<R>>>, LifecycleObserver {
    val context = MyApplication.context


    override fun adapt(call: Call<R>): LiveData<ApiResponse<R>> {
        return object : LiveData<ApiResponse<R>>() {
            private var isSuccess = false
            var started = AtomicBoolean(false)

            override fun onInactive() {
                super.onInactive()
                if (!hasActiveObservers()) {
                    if (!call.isCanceled) {
                        call.cancel()
                        Log.e("onInactive", "onInactive")
                    }
                }

                // dequeue()

            }


            override fun onActive() {
                super.onActive()
                if (!isSuccess) {
                    if (NetworkUtil.isOnline(context)) {
                        if (started.compareAndSet(false, true)) {
                            enqueue()
                        }
                    } else {
                        if (call.isCanceled) return
                        //   postValue(ApiResponse.network(false))
                        value = ApiResponse.network(false)
                    }
                } else {

                    if (call.isCanceled) return
                }
            }

            private fun dequeue() {
                if (call.isExecuted) call.cancel() // when app is not live show cancle dilaog so remove this line

            }

            private fun enqueue() {
                // postValue(ApiResponse.create(true))

                call.enqueue(object : Callback<R> {

                    @RequiresApi(Build.VERSION_CODES.N)
                    override fun onFailure(call: Call<R>, t: Throwable) {
                        //postValue(ApiResponse.create(false))
                        /*  if (NetworkUtil.isOnline(context)) {
                              Log.e("okhttp" ,"NetworkUtil is Online "+" ----> "+ call.request().url.encodedPath)
                          } else {
                              Log.e("okhttp" ,"NetworkUtil is Online"+" ----> "+ call.request().url.encodedPath)
                              postValue(ApiResponse.network(false))
                          }*/
//                        if (t is IOException) {
//                            postValue(ApiResponse.network(false))
//                        }else{
//                            postValue(ApiResponse.create(UNKNOWN_CODE, t))
//                        }


                        if (call.isCanceled) return
                        if (t is UnknownHostException) {
                            postValue(ApiResponse.network(false))
                        }else if (t is SocketTimeoutException) {
                            postValue(ApiResponse.network(false))
                        }
                        else{
                            if (isNetworkConnected(context)) {
                                postValue(ApiResponse.create(UNKNOWN_CODE, t))
                            } else {
                                postValue(ApiResponse.network(false))
                            }
                        }

                       // postValue(ApiResponse.create(UNKNOWN_CODE, t))
//                        try {
//                            if (isNetworkConnected(context)) {
//                                postValue(ApiResponse.create(UNKNOWN_CODE, t))
//                            } else {
//                                postValue(ApiResponse.network(false))
//                            }
//                        }catch (e : UnknownHostException){
//                            Log.e("netword",e.message.toString())
//                        }



                        //postValue(ApiResponse.create(UNKNOWN_CODE, t))

                    }

                    override fun onResponse(call: Call<R>, response: Response<R>) {
                        Log.e("okhttp", "url " + " ----> " + call.request().url.encodedPath)

                        //  postValue(ApiResponse.create(isLoadingShow = false))

                        if (call.isCanceled) return
                        postValue(ApiResponse.create(response))
                        isSuccess = true


                    }
                })

            }

        }
    }

    override fun responseType(): Type = responseType
}
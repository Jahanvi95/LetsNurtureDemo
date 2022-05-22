package com.glowdubai_staff.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demoapplication.service.NetworkUtil


class NetworkViewModel : ViewModel() {
    var networkLiveData: MutableLiveData<Boolean> = MutableLiveData()
    var networkRequest: NetworkRequest? = null

    init {
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        networkRequest = NetworkRequest.Builder()
            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            .build()
    }

    fun enableNetworkListener(context: Context?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val connectivityManager =
                context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            connectivityManager.registerNetworkCallback(networkRequest!!, lollipopNetworkCall)
        } else {
            context?.registerReceiver(
                networkReceiver,
                IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
            )
        }
    }

    fun disableNetworkListener(context: Context?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            else {
            context?.unregisterReceiver(networkReceiver)
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private val lollipopNetworkCall = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            networkLiveData.postValue(true)
        }

        override fun onLost(network: Network) {
            networkLiveData.postValue(false)
        }
    }

    private val networkReceiver = object : BroadcastReceiver() {
        override fun onReceive(p0: Context?, p1: Intent?) {
            networkLiveData.postValue(NetworkUtil.isOnline(p0))
        }
    }
}
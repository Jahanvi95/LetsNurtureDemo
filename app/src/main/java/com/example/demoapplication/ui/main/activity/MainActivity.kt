package com.example.demoapplication.ui.main.activity

import android.Manifest
import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.net.Uri
import android.os.Build
import android.os.Looper
import android.provider.Settings
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.ViewPropertyAnimatorListener
import androidx.lifecycle.Observer
import com.example.demoapplication.R
import com.example.demoapplication.base.BaseBindingActivity
import com.example.demoapplication.base.RecyclerAdapter
import com.example.demoapplication.databinding.ActivityMainBinding
import com.example.demoapplication.model.locationResponse.response.Data
import com.example.demoapplication.model.locationResponse.response.LocationResponse
import com.example.demoapplication.service.*
import com.example.demoapplication.ui.main.viewmodel.MainViewModel
import com.example.demoapplication.utills.*
import com.glowdubai_staff.BaseData
import com.google.android.gms.location.*
import com.jakewharton.rxbinding2.widget.RxTextView
import com.jakewharton.rxbinding2.widget.TextViewTextChangeEvent
import iammert.com.view.scalinglib.ScalingLayoutListener
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.view.*
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.collections.ArrayList


class MainActivity : BaseBindingActivity<ActivityMainBinding>() {
    private lateinit var locationAdapter: RecyclerAdapter<Data>
    val PERMISSION_ID = 42
    lateinit var mFusedLocationClient: FusedLocationProviderClient
    private val disposable = CompositeDisposable()


    private val mainViewModel: MainViewModel by viewModels {
        ViewModelFactory(
            ApiHelper(RetrofitBuilder.apiService),
            MyApplication.instance
        )
    }


    override val layoutId: Int
        get() = R.layout.activity_main


    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onNetWorkChange(onNetworkChange: Boolean) {
        customToast(binding.root)
    }

    override fun initView() {
        binding.mainActivity = this
        binding.lifecycleOwner = this
        binding.mainViewModel = mainViewModel
        addObserver()
        setListener()
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        getCurrentLocation()
        setSearchListener()
    }

    @SuppressLint("MissingPermission")
    private fun getCurrentLocation() {
        if (checkPermissions()) {
            if (isLocationEnabled()) {
                mFusedLocationClient.lastLocation.addOnCompleteListener(this) { task ->
                    var location: Location? = task.result
                    if (location == null) {
                        requestNewLocationData()
                    } else {
                        callAPI(location)
                    }
                }
            } else {
                Toast.makeText(this, "Turn on location", Toast.LENGTH_LONG).show()
                val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                startActivity(intent)
            }
        } else {
            requestPermissions()
        }

    }

    private fun callAPI(location: Location) {
        mainViewModel.latitude.value = location.latitude.toString()
        mainViewModel.logitutde.value = location.longitude.toString()
        mainViewModel.callLocationAsync(location.latitude.toString(), location.longitude.toString())
        if (getAddress(location.latitude, location.longitude).isNotEmpty()) {
            binding.root.edtSearch.setText(
                getAddress(
                    location.latitude,
                    location.longitude
                )
            )
            binding.root.searchLayout.visibilityGone(true)
            binding.root.textViewSearch.visibilityGone(false)
        }
    }

    @SuppressLint("MissingPermission")
    private fun requestNewLocationData() {
        var mLocationRequest = LocationRequest()
        mLocationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        mLocationRequest.interval = 0
        mLocationRequest.fastestInterval = 0
        mLocationRequest.numUpdates = 1

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        Looper.myLooper()?.let {
            mFusedLocationClient!!.requestLocationUpdates(
                mLocationRequest, mLocationCallback,
                it
            )
        }
    }

    private val mLocationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            var mLastLocation: Location = locationResult.lastLocation
            callAPI(mLastLocation)

        }
    }

    private fun isLocationEnabled(): Boolean {
        var locationManager: LocationManager =
            getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
            LocationManager.NETWORK_PROVIDER
        )
    }

    private fun checkPermissions(): Boolean {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            return true
        }
        return false
    }

    private fun requestPermissions() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            ),
            PERMISSION_ID
        )
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_ID) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                getCurrentLocation()
            }
        }
    }


    private fun setListener() {

        binding.root.scalingLayout.setListener(object : ScalingLayoutListener {
            override fun onCollapsed() {
                ViewCompat.animate(binding.root.textViewSearch).alpha(1F).setDuration(150).start()
                ViewCompat.animate(binding.root.searchLayout).alpha(0F).setDuration(150)
                    .setListener(object : ViewPropertyAnimatorListener {
                        override fun onAnimationStart(view: View) {
                            binding.root.textViewSearch.visibilityGone(true)
                        }

                        override fun onAnimationEnd(view: View) {
                            binding.root.searchLayout.visibilityGone(false)
                        }

                        override fun onAnimationCancel(view: View) {

                        }
                    }).start()
            }

            override fun onExpanded() {
                ViewCompat.animate(binding.root.textViewSearch).alpha(0F).setDuration(200).start()
                ViewCompat.animate(binding.root.searchLayout).alpha(1F).setDuration(200)
                    .setListener(object : ViewPropertyAnimatorListener {
                        override fun onAnimationStart(view: View) {
                            binding.root.searchLayout.visibility = View.VISIBLE
                        }

                        override fun onAnimationEnd(view: View) {
                            binding.root.textViewSearch.visibility = View.GONE
                        }

                        override fun onAnimationCancel(view: View) {

                        }
                    }).start()
            }

            override fun onProgress(progress: Float) {

            }
        })

        binding.root.scalingLayout.setOnClickListener {
            binding.root.edtSearch.requestFocus()
            showKeyBoard(binding.root.edtSearch)
            binding.root.searchLayout.visibilityGone(true)
            binding.root.textViewSearch.visibilityGone(false)

            // }
        }

        binding.root.rootView.setOnClickListener {
            hideKeyboard(binding.root.edtSearch)
            //binding.root.scalingLayout.collapse()
            binding.root.textViewSearch.visibilityGone(true)
            binding.root.searchLayout.visibilityGone(false)
        }

        binding.root.ivBack.setOnClickListener {
            hideKeyboard(binding.root.edtSearch)
            binding.root.edtSearch.setText("")
            binding.root.textViewSearch.visibilityGone(true)
            binding.root.searchLayout.visibilityGone(false)
            // }
        }
    }


    fun setLocationAdapter(): RecyclerAdapter<Data> {
        locationAdapter = RecyclerAdapter(
            this,
            mainViewModel.locationList.value!!,
            mainViewModel,
            object : RecyclerAdapter.OnItemClickListener {
                override fun onItemClick(view: View, position: Int, T: BaseData, string: String) {
                    val data = T as Data
                    val uri: String =
                        java.lang.String.format("http://maps.google.co.in/maps?q=" + data.address)
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
                    try {
                        startActivity(intent);
                    } catch (ex : ActivityNotFoundException) {
                        try {
                            val unrestrictedIntent =  Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse(uri)
                            );
                            startActivity(unrestrictedIntent);
                        } catch ( innerEx : ActivityNotFoundException) {
                            toast( "Please install a maps application")
                        }
                    }

                }

            })

        return locationAdapter
    }


    private fun addObserver() {
        mainViewModel.status.observe(this, mObserver)
    }


    /**
     *  location observer
     */
    private val mObserver = Observer<Any> { it ->
        try {
            when (it) {
                is ApiErrorResponse<*> -> {
                    if (it.errorCode == 401) {
                        showAuthCodeDialog(
                            prefs,
                            it.errorMessage!!
                        ) {

                        }
                    } else {
                        showNewCustomMessageView(
                            AppConstants.PREFERECENCE_UTILLS.ERROR,
                            it.errorMessage.toString()
                        ) { }
                    }
                }
                is ApiSuccessResponse<*> -> {
                    if (it.body is LocationResponse) {
                        if (it.body.status == 1) {
                            setLocation(it.body.data as ArrayList<Data>)

                        } else {
                            mainViewModel.locationList.value!!.clear()
                            viewShowHide()
                        }
                    }

                }
                is ApiLoading<*> -> {
                    it.isLoadingShow.let {
                        if (it) {
                            binding.shimmerLayout.startShimmer()
                        } else {
                            binding.shimmerLayout.stopShimmer()
                        }
                        binding.shimmerLayout.visibilityGone(it)

                    }
                }
                is Validation<*> -> {
                    toast(msg = it.message)
                }

                is NoInternet<*> -> {

                    showNetworkMessageView {

                    }
                }
            }
        } catch (e: Exception) {
        }

    }

    /**
     * set LOcation list
     */
    private fun setLocation(arrayList: ArrayList<Data>) {
        try {
            mainViewModel.locationList.value?.clear()
            mainViewModel.locationList.postValue(ArrayList())
            mainViewModel.locationList.postValue(arrayList)
            mainViewModel.locationList.value!!.addAll(arrayList)
            if (arrayList.isNotEmpty()) {
                locationAdapter.setData(mainViewModel.locationList.value!!)

            }
            viewShowHide()

        } catch (e: Exception) {
        }
    }


    private fun viewShowHide() {
        mainViewModel.isRecyclerViewVisible.value =
            mainViewModel.locationList.value!!.size > 0
        mainViewModel.isNoDataVisible.value =
            mainViewModel.locationList.value!!.size <= 0
    }

    private fun setSearchListener() {
        try {
            disposable.add(
                RxTextView.textChangeEvents(binding.root.edtSearch!!)
                    .skipInitialValue()
                    .debounce(600, TimeUnit.MILLISECONDS)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(searchLocation())
            )

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    /**
     * search location
     */

    private fun searchLocation(): DisposableObserver<TextViewTextChangeEvent> {
        return object : DisposableObserver<TextViewTextChangeEvent>() {
            override fun onNext(textViewTextChangeEvent: TextViewTextChangeEvent) {
                val location = textViewTextChangeEvent.text().toString()
                val lati = getLocationFromAddress(location)

                if ((location.isNotEmpty() && lati != null)) {
                    mainViewModel.callLocationAsync(
                        lati!!.latitude.toString(),
                        lati.longitude.toString()
                    )
                }else if(location.isEmpty()){
                    mainViewModel.callLocationAsync(
                        mainViewModel.latitude.value!!,
                        mainViewModel.logitutde.value!!
                    )
                }

            }

            override fun onError(e: Throwable?) {

            }

            override fun onComplete() {
            }
        }


    }
}
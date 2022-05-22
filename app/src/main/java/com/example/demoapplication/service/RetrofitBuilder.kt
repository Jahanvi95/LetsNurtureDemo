package com.example.demoapplication.service



import com.example.demoapplication.BuildConfig
import com.example.demoapplication.utills.AppConstants
import io.reactivex.disposables.CompositeDisposable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitBuilder {
    private val okHttpClient: OkHttpClient
    private var mCompositeDisposable: CompositeDisposable? = null

    init {
        val httpLogging = provideLoggingInterceptor()
        okHttpClient = provideOkHttpClient(httpLogging)
        mCompositeDisposable = CompositeDisposable()
    }

    private fun getRetrofit(): Retrofit {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        return Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .client(okHttpClient)
            .build()
    }

    fun getRetrofitData() {
        apiService = getRetrofit().create(APIServices::class.java)

    }


    private fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient().newBuilder()
            .run {
                addInterceptor(interceptor)
            }.connectTimeout(5, TimeUnit.MINUTES)
            .readTimeout(5, TimeUnit.MINUTES)
            .writeTimeout(5, TimeUnit.MINUTES)
            .build()

    private fun provideLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY

            else
                HttpLoggingInterceptor.Level.NONE
        }

    var apiService: APIServices = getRetrofit().create(APIServices::class.java)

}
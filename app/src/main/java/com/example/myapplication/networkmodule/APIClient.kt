package com.example.myapplication.networkmodule

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


fun apiclient(URL: String): Retrofit? {

    val httpOKClient: OkHttpClient?
    var retrofit: Retrofit? = null
    if (URL != null && URL.isNotEmpty()) {

        httpOKClient = OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .addInterceptor { chain ->
                    val request = chain.request().newBuilder().build()
                    chain.proceed(request)
                }
                .build()
        retrofit = Retrofit.Builder()
                .client(httpOKClient!!)
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    return retrofit

}


class StateRepository(mRetrofit: Retrofit) {
    var mAPIInterface: APIInterface? = null

    init {
        mAPIInterface = mRetrofit.create(APIInterface::class.java)

    }

    fun getWeather() = mAPIInterface?.getStateList(0)


}






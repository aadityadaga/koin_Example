package com.example.myapplication.networkmodule

import com.example.myapplication.model.getstatelist.GetStatelist
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {

    @GET("GetStateList")
    fun getStateList(@Query("virtualPackID") virtualPackID: Int): Call<GetStatelist?>?
}
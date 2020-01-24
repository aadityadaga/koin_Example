package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.model.getstatelist.GetStatelist
import com.example.myapplication.networkmodule.StateRepository
import org.koin.android.ext.android.inject
import org.koin.android.ext.android.setProperty
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val mStateRepository: StateRepository by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setProperty("staging_url", "")
        mStateRepository.getWeather()?.enqueue(object : Callback<GetStatelist?> {
            override fun onFailure(call: Call<GetStatelist?>, t: Throwable) {
                Toast.makeText(this@MainActivity, "" + t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<GetStatelist?>, response: Response<GetStatelist?>) {
                if (response.body() != null) {
                    println("data: " + response.body().toString())
                } else {
                    Toast.makeText(this@MainActivity, "data not available", Toast.LENGTH_SHORT)
                            .show()

                }
            }

        })
    }
}

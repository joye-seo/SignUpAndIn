package com.example.signupandin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.HiltAndroidApp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@HiltAndroidApp
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder().baseUrl("https://reqres.in/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val service = retrofit.create(ExampleRetrofit::class.java)
        service.getUser("1")?.enqueue(object : Callback<Page> {
            override fun onResponse(call: Call<Page>, response: Response<Page>) {
                if (response.isSuccessful) {
                    // 정상적으로 통신이 성공한 경우
                } else {
                    // 통신이 실패한 경우(응답코드 3xx, 4xx 등)
                }
            }

            override fun onFailure(call: Call<Page>, t: Throwable) {
                // 통신 실패 (인터넷 끊킴, 예외 발생 등 시스템적인 이유)
            }
        })
    }
}
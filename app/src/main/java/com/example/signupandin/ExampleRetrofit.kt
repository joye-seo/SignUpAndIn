package com.example.signupandin

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ExampleRetrofit {
    @GET("api/users")
    fun getUser(@Query("page") page: String): Call<Page>
}
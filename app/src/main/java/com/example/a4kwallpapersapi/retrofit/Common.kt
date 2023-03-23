package com.example.introductionretrofit.retrofit

object Common {

    var BASE_URL = "https://api.unsplash.com/"

    val retrofitService: RetrofitService
        get() = RetrofitClient.getRetrofit(BASE_URL).create(RetrofitService::class.java)

}
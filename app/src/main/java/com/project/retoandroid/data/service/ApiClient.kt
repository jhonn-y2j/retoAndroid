package com.project.retoandroid.data.service

import com.project.retoandroid.utils.RetrofitUtil
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    const val url = "https://jsonplaceholder.typicode.com"

    @JvmStatic fun getTestApi() : TestApi =
        Retrofit.Builder()
            .baseUrl(url)
            .client(RetrofitUtil.getBasicClientInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(TestApi::class.java)

}
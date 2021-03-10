package com.project.retoandroid.data.service

import com.project.retoandroid.data.entity.User
import retrofit2.Response
import retrofit2.http.GET

interface TestApi {

    @GET("users")
    suspend fun getUsers(): Response<List<User>>

}
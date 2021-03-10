package com.project.retoandroid.data.repository

import com.project.retoandroid.data.entity.User
import com.project.retoandroid.data.service.ApiClient

class UserRepository : UserDataSource {

    companion object {
        private var INSTANCE: UserRepository? = null
        @JvmStatic fun getInstance() = INSTANCE ?: UserRepository().apply { INSTANCE = this }
    }

    override suspend fun getUsers(): List<User> {
        val response = ApiClient.getTestApi().getUsers()
        if (!response.isSuccessful) {
            return emptyList()
        }
        return response.body() ?: emptyList()
    }

}
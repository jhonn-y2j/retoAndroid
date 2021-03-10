package com.project.retoandroid.data.repository

import com.project.retoandroid.data.entity.User

interface UserDataSource {

    suspend fun getUsers(): List<User>

}
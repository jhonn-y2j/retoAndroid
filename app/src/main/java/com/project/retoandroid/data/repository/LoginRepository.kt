package com.project.retoandroid.data.repository

import com.project.retoandroid.data.raw.CredentialRaw

class LoginRepository: LoginDataSource {

    companion object {
        private var INSTANCE: LoginRepository? = null
        @JvmStatic fun getInstance() = INSTANCE ?: LoginRepository().apply { INSTANCE = this }
    }

    override suspend fun login(userRaw: CredentialRaw): CredentialRaw? {

        if (userRaw.user == "Admin" && userRaw.password == "123") {
            return userRaw
        }

        return null

    }

}
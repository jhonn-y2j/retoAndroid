package com.project.retoandroid.data.repository

import com.project.retoandroid.data.raw.CredentialRaw

interface LoginDataSource {

    suspend fun login(userRaw: CredentialRaw): CredentialRaw?

}
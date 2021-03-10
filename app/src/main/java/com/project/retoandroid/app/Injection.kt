package com.project.retoandroid.app

import com.project.retoandroid.data.repository.UserRepository

object Injection {

    fun provideUserRepository(): UserRepository {
        return UserRepository.getInstance()
    }

}
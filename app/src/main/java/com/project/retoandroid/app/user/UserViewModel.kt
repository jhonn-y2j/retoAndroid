package com.project.retoandroid.app.user

import android.app.Application
import androidx.lifecycle.*
import com.project.retoandroid.app.Injection
import com.project.retoandroid.data.entity.User
import kotlinx.coroutines.launch

class UserViewModel(
    application: Application
): AndroidViewModel(application) {

    private val userRepository = Injection.provideUserRepository()

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>>
        get() = _users

    val userSelected = MutableLiveData<User>()

    init {

        obtainUsers()

    }

    private fun obtainUsers() {

        viewModelScope.launch {

            try {

                val response = userRepository.getUsers()
                _users.value = response

            } catch (e: Exception) {
                e.printStackTrace()
            }

        }

    }

    fun onUser(user: User) {
        userSelected.value = user
    }

    class Factory(
        private val application: Application
    ) : ViewModelProvider.NewInstanceFactory() {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T =
            with(modelClass) {
                when {
                    isAssignableFrom(UserViewModel::class.java) ->
                        UserViewModel(
                            application,
                        )
                    else -> throw IllegalArgumentException("Unknown ViewModel")
                }
            } as T
    }

}
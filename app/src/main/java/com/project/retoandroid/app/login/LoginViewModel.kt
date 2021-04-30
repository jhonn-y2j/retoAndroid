package com.project.retoandroid.app.login

import android.app.Application
import androidx.lifecycle.*
import com.project.retoandroid.app.Injection
import com.project.retoandroid.data.raw.CredentialRaw
import com.project.retoandroid.utils.Event
import kotlinx.coroutines.launch

class LoginViewModel(
    application: Application
): AndroidViewModel(application) {

    val respository = Injection.provideLoginRepository()

    val input = MutableLiveData<String>()
    val pass = MutableLiveData<String>()
    val errorMessage = MutableLiveData<Event<String>>()
    val openMainActivity = MutableLiveData<Event<Any>>()

    fun login() {

        viewModelScope.launch {

            try {

                val email = input.value ?: ""
                val password = pass.value ?: ""

                if (email.isEmpty()) {
                    errorMessage.value = Event("Ingrese su correo.")
                    return@launch
                }

                if (password.isEmpty()) {
                    errorMessage.value = Event("Ingrese su contraseña")
                    return@launch
                }

                val credential = CredentialRaw(email, password)
                val data = respository.login(credential)

                if (data != null) {
                    errorMessage.value = Event("Inicio sesión correctamente.")
                    openMainActivity.value = Event(data)
                } else {
                    errorMessage.value = Event("Correo o contraseña inválida.")
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }

        }

    }

    class Factory(
        private val application: Application
    ) : ViewModelProvider.NewInstanceFactory() {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T =
            with(modelClass) {
                when {
                    isAssignableFrom(LoginViewModel::class.java) ->
                        LoginViewModel(
                            application,
                        )
                    else -> throw IllegalArgumentException("Unknown ViewModel")
                }
            } as T
    }

}
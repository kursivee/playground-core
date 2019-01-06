package kursivee.com.core.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kursivee.com.core.login.LoginRepository
import kursivee.com.core.login.LoginResponse

class MainViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private var session: LiveData<LoginResponse> = loginRepository.getLoginResult()

    fun login() {
        loginRepository.login()
    }

    fun getSession() : LiveData<LoginResponse> {
        return session
    }
}

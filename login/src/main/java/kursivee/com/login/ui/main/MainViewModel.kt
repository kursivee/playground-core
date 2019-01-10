package kursivee.com.login.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kursivee.com.login_data.LoginRepository
import kursivee.com.login_data.LoginResponse

class MainViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private var session: LiveData<LoginResponse> = loginRepository.getLoginResult()

    fun login() {
        loginRepository.login()
    }

    fun getSession() : LiveData<LoginResponse> {
        return session
    }
}
package kursivee.com.core.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kursivee.com.core.service.data.DataRepository
import kursivee.com.core.service.login.LoginRepository
import kursivee.com.core.service.login.LoginResponse

class MainViewModel(private val loginRepository: LoginRepository,
                    private val dataRepository: DataRepository) : ViewModel() {

    private var session: LiveData<LoginResponse> = loginRepository.getLoginResult()
    val data = dataRepository.getDataResult()

    fun login() {
        loginRepository.login()
    }

    fun data() {
        dataRepository.data()
    }

    fun getSession() : LiveData<LoginResponse> {
        return session
    }
}

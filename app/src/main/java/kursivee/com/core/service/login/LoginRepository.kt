package kursivee.com.core.service.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kursivee.com.core.service.session.SessionService

class LoginRepository(private val loginApi: LoginApi, private val sessionService: SessionService) {

    private lateinit var cacheResponse: LoginResponse
    private val loginResult = MutableLiveData<LoginResponse>()

    fun login() {
        GlobalScope.launch {
            val response = loginApi.login().await()
            if(response.isSuccessful) {
                loginResult.postValue(response.body())
                sessionService.sessionToken = response.body()!!.session
                cacheResponse = response.body()!!
            }
        }
    }

    fun getLoginResult(): LiveData<LoginResponse> {
        return loginResult
    }
}
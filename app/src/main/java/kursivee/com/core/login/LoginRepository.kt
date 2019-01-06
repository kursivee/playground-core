package kursivee.com.core.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginRepository(private val loginApi: LoginApi) {

    private lateinit var cacheResponse: LoginResponse
    private val loginResult = MutableLiveData<LoginResponse>()

    fun login() {
        if(::cacheResponse.isInitialized) {
            cacheResponse.session += "CACHED"
            loginResult.postValue(cacheResponse)
            Log.d("${this::class.java.simpleName}", cacheResponse.session)
            return
        }
        GlobalScope.launch {
            val response = loginApi.login().await()
            if(response.isSuccessful) {
                loginResult.postValue(response.body())
                cacheResponse = response.body()!!
            }
        }
    }

    fun getLoginResult(): LiveData<LoginResponse> {
        return loginResult
    }
}
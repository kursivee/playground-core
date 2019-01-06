package kursivee.com.core.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kursivee.com.core.login.LoginApi

class MainViewModel(private val loginApi: LoginApi) : ViewModel() {

    private val session = MutableLiveData<String>()

    fun login() {
        GlobalScope.launch {
            Log.d("TAG", "here")
            withContext(Dispatchers.Main) {
                session.value = loginApi.login().await().session
                Log.d("TAG", session.value)
            }
        }
    }

    fun getSession() : LiveData<String> {
        return session
    }
}

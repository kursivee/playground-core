package kursivee.com.core.login

import kotlinx.coroutines.Deferred
import retrofit2.http.POST

interface LoginApi {
    @POST("5c3172853500001200ca9f6b")
    fun login() : Deferred<LoginResponse>
}
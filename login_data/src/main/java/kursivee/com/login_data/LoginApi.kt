package kursivee.com.login_data

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.POST

interface LoginApi {
    @POST("5c3172853500001200ca9f6b")
    fun login() : Deferred<Response<LoginResponse>>
}
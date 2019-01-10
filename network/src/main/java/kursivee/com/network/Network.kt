package kursivee.com.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Network {

    private fun getHttpClient(sessionService: SessionService): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor {
            val original = it.request()
            val requestBuilder = original.newBuilder()
                .method(original.method(), original.body())
            if(sessionService.sessionToken != "") {
                requestBuilder.header("token", sessionService.sessionToken)
            }
            it.proceed(requestBuilder.build())
        }
        return httpClient.build()
    }

    fun getRetrofit(baseUrl: String, sessionService: SessionService): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(getHttpClient(sessionService))
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }
}
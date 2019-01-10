package kursivee.com.feature_data

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

class FeatureApi {
    interface DataApi {
        @GET("5c3172853500001200ca9f6b")
        fun data() : Deferred<Response<DataResponse>>
    }
}
package kursivee.com.core.service.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DataRepository(private val dataApi: DataApi) {

    private lateinit var cacheDataResponse: DataResponse
    private val dataResult = MutableLiveData<DataResponse>()

    fun data() {
        if(::cacheDataResponse.isInitialized) {
            dataResult.postValue(cacheDataResponse)
            return
        }
        GlobalScope.launch {
            val response = dataApi.data().await()
            if(response.isSuccessful) {
                dataResult.postValue(response.body())
                cacheDataResponse = response.body()!!
            }
        }
    }

    fun getDataResult(): LiveData<DataResponse> {
        return dataResult
    }
}
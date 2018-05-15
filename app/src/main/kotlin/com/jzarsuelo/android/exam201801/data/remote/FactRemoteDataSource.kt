package com.jzarsuelo.android.exam201801.data.remote

import com.jzarsuelo.android.exam201801.api.ApiService
import com.jzarsuelo.android.exam201801.data.FactDataSource
import com.jzarsuelo.android.exam201801.data.FactResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FactRemoteDataSource(
        private val apiService: ApiService
) : FactDataSource {

    override fun getData(callback: FactDataSource.FactCallback) {

        apiService.getFacts().enqueue(object : Callback<FactResponse>{

            override fun onFailure(call: Call<FactResponse>, t: Throwable) {
                callback.onNetworkError()
            }

            override fun onResponse(call: Call<FactResponse>, response: Response<FactResponse>) {
                when(response.code()) {
                    200 -> callback.onSuccess(response.body()!!)
                    else -> callback.onFailedRequest()
                }
            }
        })

    }

    companion object {

        var instance: FactRemoteDataSource? = null

        fun getInstance(apiService: ApiService): FactRemoteDataSource {
            return instance ?: FactRemoteDataSource(apiService).apply {
                instance = this
            }
        }

    }
}
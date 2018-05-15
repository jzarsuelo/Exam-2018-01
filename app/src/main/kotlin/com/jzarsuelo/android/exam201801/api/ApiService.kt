package com.jzarsuelo.android.exam201801.api

import com.jzarsuelo.android.exam201801.BuildConfig
import com.jzarsuelo.android.exam201801.data.FactResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Interface that contains the methods use to execute HTTP request to the API
 */
interface ApiService {

    @GET(ApiEndpoints.facts)
    fun getFacts() : Call<FactResponse>

    companion object {
        val instance: ApiService by lazy {
            val builder = OkHttpClient.Builder()

            // for debugging API calls
            if (BuildConfig.DEBUG) {
                val interceptor = HttpLoggingInterceptor()
                interceptor.level = HttpLoggingInterceptor.Level.BODY

                builder.addInterceptor(interceptor)
            }

            val okHttpClient = builder.build()
            val retrofit = Retrofit.Builder()
                    .baseUrl( BuildConfig.API_BASE_URI )
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()

            retrofit.create(ApiService::class.java)
        }
    }
}
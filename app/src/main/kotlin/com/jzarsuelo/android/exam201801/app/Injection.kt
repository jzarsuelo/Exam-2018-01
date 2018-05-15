package com.jzarsuelo.android.exam201801.app

import com.jzarsuelo.android.exam201801.api.ApiService
import com.jzarsuelo.android.exam201801.data.FactRepository
import com.jzarsuelo.android.exam201801.data.remote.FactRemoteDataSource

object Injection {

    private val apiService = ApiService.instance

    fun provideFactRepository() = FactRepository
                .getInstance( FactRemoteDataSource.getInstance(apiService) )

}
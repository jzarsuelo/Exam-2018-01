package com.jzarsuelo.android.exam201801.data

interface BaseCallback<T> {

    fun onSuccess(data: T)

    fun onNetworkError()

    fun onFailedRequest()
}
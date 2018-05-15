package com.jzarsuelo.android.exam201801.data

interface FactDataSource {

    interface FactCallback : BaseCallback<FactResponse>

    fun getData(callback: FactCallback)
}
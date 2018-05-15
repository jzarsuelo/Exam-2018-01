package com.jzarsuelo.android.exam201801.data

class FactRepository(
        private val remoteDataSource: FactDataSource
) : FactDataSource {

    override fun getData(callback: FactDataSource.FactCallback) {
        remoteDataSource.getData(callback)
    }

    companion object {

        private var instance: FactRepository? = null

        fun getInstance(remoteDataSource: FactDataSource): FactRepository {
            return instance ?: FactRepository(remoteDataSource).apply {
                instance = this
            }
        }
    }
}
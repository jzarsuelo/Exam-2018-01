package com.jzarsuelo.android.exam201801.ui.main

import com.jzarsuelo.android.exam201801.data.FactDataSource
import com.jzarsuelo.android.exam201801.data.FactResponse

class MainPresenter(
        private val view: MainContract.View,
        private val repository: FactDataSource
) : MainContract.Presenter {

    override fun requestData() {
        view.showProgressBar(true)

        repository.getData(object : FactDataSource.FactCallback{
            override fun onSuccess(data: FactResponse) {

                if (data.rows.isEmpty()) {
                    view.showErrorNoData()
                } else {
                    view.showData(data)
                }

            }

            override fun onNetworkError() {
                view.showErrorNoInternet()
            }

            override fun onFailedRequest() {
                view.showError("Something went wrong.")
            }
        })
    }

}
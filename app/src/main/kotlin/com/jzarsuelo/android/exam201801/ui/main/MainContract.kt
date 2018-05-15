package com.jzarsuelo.android.exam201801.ui.main

import com.jzarsuelo.android.exam201801.data.FactResponse
import com.jzarsuelo.android.exam201801.ui.BasePresenter
import com.jzarsuelo.android.exam201801.ui.BaseView

interface MainContract {

    interface View : BaseView<Presenter> {
        fun showData(data: FactResponse)
        fun showErrorNoInternet()
        fun showErrorNoData()
        fun showProgressBar(isVisible: Boolean)
    }

    interface Presenter : BasePresenter {
        fun requestData()
    }

}
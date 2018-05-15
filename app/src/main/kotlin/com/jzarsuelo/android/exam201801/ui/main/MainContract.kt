package com.jzarsuelo.android.exam201801.ui.main

import com.jzarsuelo.android.exam201801.ui.BasePresenter
import com.jzarsuelo.android.exam201801.ui.BaseView

interface MainContract {

    interface View : BaseView<Presenter> {
        fun showData()
        fun showError()
    }

    interface Presenter : BasePresenter {
        fun requestData()
    }

}
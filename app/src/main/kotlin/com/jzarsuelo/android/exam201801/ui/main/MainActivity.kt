package com.jzarsuelo.android.exam201801.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.jzarsuelo.android.exam201801.R
import com.jzarsuelo.android.exam201801.app.Injection
import com.jzarsuelo.android.exam201801.data.FactResponse

class MainActivity : AppCompatActivity(), MainContract.View {

    override var presenter: MainContract.Presenter = MainPresenter(this, Injection.provideFactRepository())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun showData(data: FactResponse) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showErrorNoInternet() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showErrorNoData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

package com.jzarsuelo.android.exam201801.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.jzarsuelo.android.exam201801.R

class MainActivity : AppCompatActivity(), MainContract.View {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun showData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override var presenter: MainContract.Presenter = MainPresenter()

}

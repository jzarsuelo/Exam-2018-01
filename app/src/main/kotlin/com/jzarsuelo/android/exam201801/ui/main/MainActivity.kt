package com.jzarsuelo.android.exam201801.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.jzarsuelo.android.exam201801.R
import com.jzarsuelo.android.exam201801.app.Injection
import com.jzarsuelo.android.exam201801.data.FactResponse
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    override var presenter: MainContract.Presenter = MainPresenter(this, Injection.provideFactRepository())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        setTitle(getString(R.string.app_name))

        presenter.requestData()
    }

    override fun showProgressBar(isVisible: Boolean) {
        progressBar.visibility = if (isVisible) View.VISIBLE
        else View.GONE
    }

    override fun showData(data: FactResponse) {
        showProgressBar(false)
        setTitle(data.title)
    }

    override fun showErrorNoInternet() {
        showError("Please check your internet connection")
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun showErrorNoData() {
        showProgressBar(false)
        noDataTextView.visibility = View.VISIBLE
    }

    private fun setTitle(title: String) {
        supportActionBar?.title = if (TextUtils.isEmpty(title)) getString(R.string.app_name)
        else title
    }
}

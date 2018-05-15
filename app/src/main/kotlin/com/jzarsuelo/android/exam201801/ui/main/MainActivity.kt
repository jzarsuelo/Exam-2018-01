package com.jzarsuelo.android.exam201801.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.jzarsuelo.android.exam201801.R
import com.jzarsuelo.android.exam201801.app.Injection
import com.jzarsuelo.android.exam201801.data.FactResponse
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    private val adapter = FactsAdapter()

    override var presenter: MainContract.Presenter = MainPresenter(this, Injection.provideFactRepository())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpViews()

        refreshData()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_refresh -> {
                refreshData()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun showProgressBar(isVisible: Boolean) {
        progressBar.visibility = if (isVisible) {
            noDataTextView.visibility = View.GONE
            View.VISIBLE
        }
        else View.GONE
    }

    override fun showData(data: FactResponse) {
        showProgressBar(false)
        setTitle(data.title)

        recyclerView.visibility = View.VISIBLE
        adapter.addData(data.rows)
    }

    override fun showErrorNoInternet() {
        showError("Please check your internet connection")
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun showErrorNoData() {
        showProgressBar(false)
        noDataTextView.visibility =  View.VISIBLE
    }

    private fun setUpViews() {
        setSupportActionBar(toolbar)
        setTitle(getString(R.string.app_name))

        recyclerView.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            setHasFixedSize(false)
            adapter = this@MainActivity.adapter
            addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
        }
    }

    private fun setTitle(title: String) {
        supportActionBar?.title = if (TextUtils.isEmpty(title)) getString(R.string.app_name)
        else title
    }

    private fun refreshData() {
        recyclerView.visibility = View.GONE
        presenter.requestData()
    }
}

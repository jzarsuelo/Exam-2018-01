package com.jzarsuelo.android.exam201801.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.jzarsuelo.android.exam201801.R
import com.jzarsuelo.android.exam201801.data.Fact
import com.jzarsuelo.android.exam201801.utils.ExamGlideApp

class FactsAdapter : RecyclerView.Adapter<FactsAdapter.ViewHolder>() {

    private var data: List<Fact> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_fact, parent, false)

        return ViewHolder(v)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fact = data[position]

        holder.titleTextView?.text = fact.title
        holder.descriptionTextView?.text = fact.description

        holder.imageView?.apply {

            val requestOptions = RequestOptions()
                    .placeholder(R.drawable.ic_image_placeholder)

            Glide.with(this)
                    .load(fact.imageHref)
                    .apply(requestOptions)
                    .into(this)
        }

    }

    fun addData(data: List<Fact>) {
        this.data = data
        notifyDataSetChanged()
    }


    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        var imageView: ImageView? = null
        var titleTextView: TextView? = null
        var descriptionTextView: TextView? = null

        init {
            imageView = v.findViewById(R.id.imageView)
            titleTextView = v.findViewById(R.id.titleTextView)
            descriptionTextView = v.findViewById(R.id.descriptionTextView)
        }
    }

}
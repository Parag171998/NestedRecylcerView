package com.example.nestedrecyclerview.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nestedrecyclerview.Models.Data
import com.example.nestedrecyclerview.R
import kotlinx.android.synthetic.main.custom_child_recycler_layout.view.*

class ChildItemAdapter (var data : List<Data>) : RecyclerView.Adapter<ChildItemAdapter.ViewHolder>() {

    private var dataList : List<Data>? = null

    var cotext: Context? = null

    init {
        this.dataList = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        cotext = parent.context
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
            R.layout.custom_child_recycler_layout,
            parent,
            false
        ))
    }

    override fun getItemCount(): Int {
        return dataList!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Glide.with(cotext!!).load(dataList?.get(position)?.pF).into(holder.img)
        holder.imgTitle.text = dataList?.get(position)?.cat
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var img = itemView.childImg
        var imgTitle = itemView.childText
    }
}
package com.example.nestedrecyclerview.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool
import com.example.nestedrecyclerview.Models.ItemItem
import com.example.nestedrecyclerview.R
import kotlinx.android.synthetic.main.custom_parent_recycler_layout.view.*


class ParentAdapter (var itemItemList:List<ItemItem>) : RecyclerView.Adapter<ParentAdapter.ViewHolder>() {

    private val viewPool = RecycledViewPool()
    private var itemList: List<ItemItem>? = null

    init {
        this.itemList = itemItemList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.custom_parent_recycler_layout,
            parent,
            false
        ))
    }

    override fun getItemCount(): Int {
        return itemItemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTitle.text = itemItemList.get(position).title

        val layoutManager = LinearLayoutManager(
            holder.recyclerView.getContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )
        layoutManager.initialPrefetchItemCount = itemItemList.get(position).data!!.size


        val childItemAdapter = ChildItemAdapter(itemItemList?.get(position).data!!)

        holder.recyclerView.setLayoutManager(layoutManager)
        holder.recyclerView.setAdapter(childItemAdapter)
        holder.recyclerView.setRecycledViewPool(viewPool)
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var itemTitle = itemView.tv_item_title
        var recyclerView = itemView.rv_sub_item
    }
}
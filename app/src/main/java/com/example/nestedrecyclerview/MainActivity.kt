package com.example.nestedrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nestedrecyclerview.Adapter.ParentAdapter
import com.example.nestedrecyclerview.Models.Item
import com.example.nestedrecyclerview.Models.ItemItem
import com.example.nestedrecyclerview.ViewModel.MainViewModel
import com.example.wenesdaytaskkotlin.Network.ApiClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var mainViewModel: MainViewModel? = null

    private var itemItemList : MutableList<ItemItem>? = null
    private var parentAdapter : ParentAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        itemItemList = ArrayList<ItemItem>()

        initRecylerView()

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        mainViewModel?.getResultList()?.observe(this, Observer { itmList ->

            if(itmList != null)
            {
                itemItemList?.addAll(itmList)
                parentAdapter?.notifyDataSetChanged()
            }

        })

    }

    private fun initRecylerView() {
        parentRecyler.layoutManager = LinearLayoutManager(this)
        parentAdapter = ParentAdapter(itemItemList!!)
        parentRecyler.adapter = parentAdapter

    }
}





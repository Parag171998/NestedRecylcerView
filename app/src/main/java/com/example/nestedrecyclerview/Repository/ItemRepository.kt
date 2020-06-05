package com.example.nestedrecyclerview.Repository

import androidx.lifecycle.MutableLiveData
import com.example.nestedrecyclerview.Models.ItemItem
import com.example.wenesdaytaskkotlin.Network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ItemRepository {

    companion object{
        private var instance: ItemRepository? = null
        private  var itemMutableList: MutableLiveData<List<ItemItem>>? = MutableLiveData()

         fun getinstance(): ItemRepository {
            if (instance == null){
                instance = ItemRepository()
            }

            return instance as ItemRepository
        }
    }

    fun getItems() :MutableLiveData<List<ItemItem>>?{
        var itemCall : Call<List<ItemItem>?> = ApiClient.getInstance()!!.getApi()!!.getIteams();

        itemCall.enqueue(object : Callback<List<ItemItem>?> {
            override fun onFailure(call: Call<List<ItemItem>?>, t: Throwable) {

            }

            override fun onResponse(call: Call<List<ItemItem>?>, response: Response<List<ItemItem>?>) {
                var itemItem = response.body()

               itemMutableList?.postValue(itemItem)
                itemMutableList
            }

        })
        return itemMutableList
    }
}
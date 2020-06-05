package com.example.nestedrecyclerview.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nestedrecyclerview.Models.ItemItem
import com.example.nestedrecyclerview.Repository.ItemRepository

class MainViewModel : ViewModel {

    private var itemMutableList : MutableLiveData<List<ItemItem>>? = null
    private var itemRepository: ItemRepository? = null


    constructor()
    {
        if(itemMutableList != null){
            return
        }
        itemRepository = ItemRepository.getinstance()
        itemMutableList = itemRepository?.getItems()
    }

    fun getResultList() : MutableLiveData<List<ItemItem>>? {

        if(itemMutableList != null)
        {
            itemMutableList
        }
        return  itemMutableList
    }
}
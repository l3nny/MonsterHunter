package com.yulie.monsterhunter.viewmodel


import androidx.lifecycle.MutableLiveData
import com.yulie.monsterhunter.service.api.ApiRequest
import com.yulie.monsterhunter.service.model.Armor

class ListViewModel : BaseViewModel() {
   val listLive = MutableLiveData<ArrayList<Armor>>()

    fun fetchList() {
        dataLoading.value = true
        ApiRequest.getInstance().getList { isSuccess, response ->
            dataLoading.value = false
            if (isSuccess) {
                listLive.value = response
                empty.value = false
            } else {
                empty.value = true
            }
        }
    }

    companion object {
        private var INSTANCE: ListViewModel? = null
        fun getInstance() = INSTANCE
            ?: ListViewModel().also {
                INSTANCE = it
            }
    }

}
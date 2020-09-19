package com.yulie.monsterhunter.view.apiList


import androidx.lifecycle.MutableLiveData
import com.yulie.monsterhunter.service.api.ApiRequest
import com.yulie.monsterhunter.service.model.Armor
import com.yulie.monsterhunter.view.callback.BaseViewModel

class ListViewModel : BaseViewModel() {
    private val listLive = MutableLiveData<List<Armor>>()

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
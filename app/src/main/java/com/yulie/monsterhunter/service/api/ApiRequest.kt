package com.yulie.monsterhunter.service.api

import com.yulie.monsterhunter.service.model.Armor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiRequest {

    fun getList(onResult: (isSuccess: Boolean, response: ArrayList<Armor>?) -> Unit) {

        RetrofitBuilder.instance.getRepo().enqueue(object : Callback<ArrayList<Armor>> {
            override fun onResponse(call: Call<ArrayList<Armor>>?, response: Response<ArrayList<Armor>>?) {
                if (response != null && response.isSuccessful)
                    onResult(true, response.body()!!)
                else
                    onResult(false, null)
            }

            override fun onFailure(call: Call<ArrayList<Armor>>?, t: Throwable?) {
                onResult(false, null)
            }

        })
    }

    companion object {
        private var INSTANCE: ApiRequest? = null
        fun getInstance() = INSTANCE
            ?: ApiRequest().also {
                INSTANCE = it
            }
    }
}
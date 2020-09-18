package com.yulie.monsterhunter.service.api

import com.yulie.monsterhunter.service.model.Armor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Request {

    fun getRepoList(onResult: (isSuccess: Boolean, response: Armor?) -> Unit) {

        RetrofitBuilder.instance.getRepo().enqueue(object : Callback<Armor> {
            override fun onResponse(call: Call<Armor>?, response: Response<Armor>?) {
                if (response != null && response.isSuccessful)
                    onResult(true, response.body()!!)
                else
                    onResult(false, null)
            }

            override fun onFailure(call: Call<Armor>?, t: Throwable?) {
                onResult(false, null)
            }

        })
    }
}
package com.yulie.monsterhunter.service.api

import com.yulie.monsterhunter.service.model.Armor
import retrofit2.Call
import retrofit2.http.GET



interface ApiService {

    @GET("armor")
    fun getRepo(): Call<List<Armor>>

}



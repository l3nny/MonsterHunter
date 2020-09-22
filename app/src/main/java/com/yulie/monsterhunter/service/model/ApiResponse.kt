package com.yulie.monsterhunter.service.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Armor(
    @Expose
    @SerializedName("name") val name: String,
    @Expose
    @SerializedName("rank") val rank: String,
    @Expose
    @SerializedName("defense") val defense: Defense,
    @Expose
    @SerializedName("slots") val slots: ArrayList<Slots>,
    @Expose
    @SerializedName("type") val type: String
)

data class Defense(
    @Expose
    @SerializedName("base") val base: String,
)

data class Slots(
    @Expose
    @SerializedName("rank") val rank: String,
)



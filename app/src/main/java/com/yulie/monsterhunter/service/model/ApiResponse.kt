package com.yulie.monsterhunter.service.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Armor(
    @Expose
    @SerializedName("name") val name: String?,
    @Expose
    @SerializedName("rank") val rank: String?,
    @Expose
    @SerializedName("defense") val defense: Defense? = null,
    @Expose
    @SerializedName("slots") val slots: List<Slots>?,
    @Expose
    @SerializedName("type") val type: String?
)

data class Defense(
    @Expose
    @SerializedName("base") val base: String? = null,
)

data class Slots(
    @Expose
    @SerializedName("rank") val rank: String? = null,
)



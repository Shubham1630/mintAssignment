package com.srp.assignment.model


import com.google.gson.annotations.SerializedName

data class Label(
    @SerializedName("id")
    val id: Double?,
    @SerializedName("node_id")
    val nodeId: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("color")
    val color: String?,
    @SerializedName("default")
    val default: Boolean?,
    @SerializedName("description")
    val description: String?
)
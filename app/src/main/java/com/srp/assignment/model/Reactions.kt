package com.srp.assignment.model


import com.google.gson.annotations.SerializedName

data class Reactions(
    @SerializedName("url")
    val url: String?,
    @SerializedName("total_count")
    val totalCount: Int?,
    @SerializedName("+1")
    val x1: Int?,
    @SerializedName("-1")
    val x2: Int?,
    @SerializedName("laugh")
    val laugh: Int?,
    @SerializedName("hooray")
    val hooray: Int?,
    @SerializedName("confused")
    val confused: Int?,
    @SerializedName("heart")
    val heart: Int?,
    @SerializedName("rocket")
    val rocket: Int?,
    @SerializedName("eyes")
    val eyes: Int?
)
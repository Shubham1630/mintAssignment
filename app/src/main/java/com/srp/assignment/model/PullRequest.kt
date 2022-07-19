package com.srp.assignment.model


import com.google.gson.annotations.SerializedName

data class PullRequest(
    @SerializedName("url")
    val url: String?,
    @SerializedName("html_url")
    val htmlUrl: String?,
    @SerializedName("diff_url")
    val diffUrl: String?,
    @SerializedName("patch_url")
    val patchUrl: String?,
    @SerializedName("merged_at")
    val mergedAt: Any?
)
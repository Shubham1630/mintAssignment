package com.srp.assignment.model


import com.google.gson.annotations.SerializedName

data class Milestone(
    @SerializedName("url")
    val url: String?,
    @SerializedName("html_url")
    val htmlUrl: String?,
    @SerializedName("labels_url")
    val labelsUrl: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("node_id")
    val nodeId: String?,
    @SerializedName("number")
    val number: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("creator")
    val creator: Creator?,
    @SerializedName("open_issues")
    val openIssues: Int?,
    @SerializedName("closed_issues")
    val closedIssues: Int?,
    @SerializedName("state")
    val state: String?,
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("updated_at")
    val updatedAt: String?,
    @SerializedName("due_on")
    val dueOn: String?,
    @SerializedName("closed_at")
    val closedAt: Any?
)
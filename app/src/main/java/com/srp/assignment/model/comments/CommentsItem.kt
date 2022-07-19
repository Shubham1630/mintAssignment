package com.srp.assignment.model.comments


import com.google.gson.annotations.SerializedName

data class CommentsItem(
    @SerializedName("url")
    val url: String?,
    @SerializedName("html_url")
    val htmlUrl: String?,
    @SerializedName("issue_url")
    val issueUrl: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("node_id")
    val nodeId: String?,
    @SerializedName("user")
    val user: User?,
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("updated_at")
    val updatedAt: String?,
    @SerializedName("author_association")
    val authorAssociation: String?,
    @SerializedName("body")
    val body: String?,
    @SerializedName("reactions")
    val reactions: Reactions?,
    @SerializedName("performed_via_github_app")
    val performedViaGithubApp: Any?
)
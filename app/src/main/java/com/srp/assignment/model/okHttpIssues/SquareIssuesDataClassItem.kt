package com.srp.assignment.model.okHttpIssues


import com.google.gson.annotations.SerializedName

data class SquareIssuesDataClassItem(
    @SerializedName("url")
    val url: String?,
    @SerializedName("repository_url")
    val repositoryUrl: String?,
    @SerializedName("labels_url")
    val labelsUrl: String?,
    @SerializedName("comments_url")
    val commentsUrl: String?,
    @SerializedName("events_url")
    val eventsUrl: String?,
    @SerializedName("html_url")
    val htmlUrl: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("node_id")
    val nodeId: String?,
    @SerializedName("number")
    val number: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("user")
    val user: User?,
    @SerializedName("labels")
    val labels: List<Label>?,
    @SerializedName("state")
    val state: String?,
    @SerializedName("locked")
    val locked: Boolean?,
    @SerializedName("assignee")
    val assignee: Assignee?,
    @SerializedName("assignees")
    val assignees: List<Any>?,
    @SerializedName("milestone")
    val milestone: Milestone?,
    @SerializedName("comments")
    val comments: Int?,
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("updated_at")
    val updatedAt: String?,
    @SerializedName("closed_at")
    val closedAt: Any?,
    @SerializedName("author_association")
    val authorAssociation: String?,
    @SerializedName("active_lock_reason")
    val activeLockReason: Any?,
    @SerializedName("draft")
    val draft: Boolean?,
    @SerializedName("pull_request")
    val pullRequest: PullRequest?,
    @SerializedName("body")
    val body: String?,
    @SerializedName("reactions")
    val reactions: Reactions?,
    @SerializedName("timeline_url")
    val timelineUrl: String?,
    @SerializedName("performed_via_github_app")
    val performedViaGithubApp: Any?,
    @SerializedName("state_reason")
    val stateReason: String?
)
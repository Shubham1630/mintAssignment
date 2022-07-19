package com.srp.assignment.repository

import com.srp.assignment.service.OkHttpIssuesService

class IssuesRepository constructor(private val retrofitService: OkHttpIssuesService) {


    fun getAllIssues() = retrofitService.issuesList()
    fun getAllComments() = retrofitService.getCommentList()
}
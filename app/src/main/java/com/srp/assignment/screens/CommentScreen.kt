package com.srp.assignment.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.srp.assignment.Constants
import com.srp.assignment.R
import com.srp.assignment.adapter.CommentAdapter
import com.srp.assignment.model.comments.CommentsItem
import com.srp.assignment.repository.IssuesRepository
import com.srp.assignment.service.OkHttpIssuesService
import com.srp.assignment.service.Retrofit
import com.srp.assignment.viewmodel.MainViewModel
import com.srp.assignment.viewmodel.MyViewModelFactory
import kotlinx.android.synthetic.main.activity_comment_screen.*

class CommentScreen : AppCompatActivity() {


    private lateinit var adapter: CommentAdapter


    private lateinit var commentURl: String
    private lateinit var commentList: List<CommentsItem>
    private lateinit var retrofitIssuesService: OkHttpIssuesService
    lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment_screen)
        getSupportActionBar()?.setTitle("CommentList")
        commentURl = intent.getStringExtra(Constants.COMMENT_URL).toString().replace("comments", "").trim()

        retrofitIssuesService = Retrofit().getInstance(commentURl)
        viewModel = ViewModelProvider(
            this,
            MyViewModelFactory(IssuesRepository(retrofitIssuesService))
        ).get(
            MainViewModel::class.java
        )


        viewModel.getAllComments()
        commetRecyclerView.layoutManager = LinearLayoutManager(this)


        attachObserver()

    }

    private fun attachObserver() {
        viewModel.commentList.observe(this, Observer {

            commentList = it
            initializeAdapter()
        })

        viewModel.errorMessage.observe(this, Observer {

        })
    }

    private fun initializeAdapter() {
        adapter =
            CommentAdapter(this, commentList, object : CommentAdapter.OnClickListener {
                override fun onItemClick(position: Int) {


                }
            })

        commetRecyclerView.adapter = adapter
        commetRecyclerView.addItemDecoration(
            DividerItemDecoration(
                commetRecyclerView.context,
                DividerItemDecoration.VERTICAL
            )
        )
    }


}
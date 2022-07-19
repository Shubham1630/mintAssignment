package com.srp.assignment.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.srp.assignment.Constants
import com.srp.assignment.R

class CommentScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment_screen)
        val commentURl: String = intent.getStringExtra(Constants.COMMENT_URL).toString()


    }
}
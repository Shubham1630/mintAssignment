package com.srp.assignment.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.srp.assignment.SharedPreferences
import com.srp.assignment.model.SquareIssuesDataClassItem
import com.srp.assignment.model.comments.CommentsItem
import com.srp.assignment.repository.IssuesRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: IssuesRepository) : ViewModel() {

    val issuesList = MutableLiveData<ArrayList<SquareIssuesDataClassItem>>()
    val errorMessage = MutableLiveData<String>()
    val commentList = MutableLiveData<List<CommentsItem>>()

    fun getAllOkHttpIssues() {

        val response = repository.getAllIssues()
        response.enqueue(object : Callback<ArrayList<SquareIssuesDataClassItem>> {
            override fun onResponse(
                call: Call<ArrayList<SquareIssuesDataClassItem>>,
                response: Response<ArrayList<SquareIssuesDataClassItem>>
            ) {
                issuesList.postValue(response.body())
                print(response.body().toString())
            }

            override fun onFailure(call: Call<ArrayList<SquareIssuesDataClassItem>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }

    fun getAllComments() {

        val response = repository.getAllComments()
        response?.enqueue(object : Callback<List<CommentsItem>> {
            override fun onResponse(
                call: Call<List<CommentsItem>>,
                response: Response<List<CommentsItem>>
            ) {
                print(commentList);
                commentList.postValue(response.body());

            }

            override fun onFailure(call: Call<List<CommentsItem>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }


}
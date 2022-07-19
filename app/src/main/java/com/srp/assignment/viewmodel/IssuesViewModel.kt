package com.srp.assignment.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.srp.assignment.model.SquareIssuesDataClassItem
import com.srp.assignment.repository.IssuesRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: IssuesRepository)  : ViewModel() {

    val issuesList = MutableLiveData<ArrayList<SquareIssuesDataClassItem>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllOkHttpIssues() {

        val response = repository.getAllIssues()
        response.enqueue(object : Callback<ArrayList<SquareIssuesDataClassItem>> {
            override fun onResponse(call: Call<ArrayList<SquareIssuesDataClassItem>>, response: Response<ArrayList<SquareIssuesDataClassItem>>) {
                print(response.body().toString())
                issuesList.postValue(response.body())
            }

            override fun onFailure(call: Call<ArrayList<SquareIssuesDataClassItem>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }



}
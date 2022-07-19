package com.srp.assignment


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.srp.assignment.adapter.IssuesAdapter
import com.srp.assignment.model.SquareIssuesDataClassItem
import com.srp.assignment.repository.IssuesRepository
import com.srp.assignment.screens.CommentScreen
import com.srp.assignment.service.OkHttpIssuesService
import com.srp.assignment.service.Retrofit
import com.srp.assignment.viewmodel.MainViewModel
import com.srp.assignment.viewmodel.MyViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*


private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: IssuesAdapter


    private lateinit var issuesList: ArrayList<SquareIssuesDataClassItem>
    private lateinit var retrofitIssuesService: OkHttpIssuesService
    lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        retrofitIssuesService = Retrofit().getInstance(Constants.BASE_URL)
        viewModel = ViewModelProvider(
            this,
            MyViewModelFactory(IssuesRepository(retrofitIssuesService))
        ).get(
            MainViewModel::class.java
        )
        issuesList = ArrayList<SquareIssuesDataClassItem>()


        if (getIssuesListFromCache() != null) {
            issuesList =
                getIssuesListFromCache()
            initializeAdapter()
        }

        viewModel.getAllOkHttpIssues()
        rvRestaurants.layoutManager = LinearLayoutManager(this)



        attachObserver()


    }

    private fun getIssuesListFromCache(): ArrayList<SquareIssuesDataClassItem> {
        return SharedPreferences.getIssuesList(this@MainActivity)
    }

    private fun attachObserver() {
        viewModel.issuesList.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            issuesList = it
            SharedPreferences.saveIssuesList(this@MainActivity, issuesList)
            initializeAdapter()
        })

        viewModel.errorMessage.observe(this, Observer {

        })
    }

    private fun initializeAdapter() {
        adapter =
            IssuesAdapter(this, issuesList, object : IssuesAdapter.OnClickListener {
                override fun onItemClick(position: Int) {
                    val intent = Intent(this@MainActivity, CommentScreen::class.java)
                    intent.putExtra(Constants.COMMENT_URL, issuesList[position].commentsUrl)
                    startActivity(intent)

                }
            })

        rvRestaurants.adapter = adapter
        rvRestaurants.addItemDecoration(
            DividerItemDecoration(
                rvRestaurants.context,
                DividerItemDecoration.VERTICAL
            )
        )

        adapter.notifyDataSetChanged()
    }


}



package com.srp.assignment


import YelpRestaurant
import YelpSearchResult
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import edu.stanford.dstratak.yelp.YelpService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private const val TAG = "MainActivity"
private const val BASE_URL = "https://api.yelp.com/v3/"
private const val API_KEY = "XPFgzKwZGK1yqRxHi0d5xsARFOLpXIvccQj5jekqTnysweGyoIfVUHcH2tPfGq5Oc9kwKHPkcOjk2d1Xobn7aTjOFeop8x41IUfVvg2Y27KiINjYPADcE7Qza0RkX3Yx"

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: RestaurantsAdapter
    private lateinit var swipeContainer: SwipeRefreshLayout


    private lateinit var restaurants: MutableList<YelpRestaurant>
    private lateinit var retrofit: Retrofit
    private lateinit var yelpService: YelpService

    private var searchQuery = "restaurants"
    private var searchLocation = "New York"
    private var radius = 500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iniRefreshListener()
        initializeView()

        restaurants = mutableListOf<YelpRestaurant>()
        retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()
        yelpService = retrofit.create(YelpService::class.java)

        updateSearch()

        rvRestaurants.layoutManager = LinearLayoutManager(this)
        adapter =
            RestaurantsAdapter(this, restaurants, object : RestaurantsAdapter.OnClickListener {
                override fun onItemClick(position: Int) {

                }
            })
        rvRestaurants.adapter = adapter
        rvRestaurants.addItemDecoration(
            DividerItemDecoration(
                rvRestaurants.context,
                DividerItemDecoration.VERTICAL
            )
        )

    }

    private fun updateSearch() {
        yelpService.searchRestaurants(
            "Bearer $API_KEY",
            searchQuery,
            searchLocation,
            radius,
            "distance",
            15
        )
            .enqueue(object : Callback<YelpSearchResult> {
                override fun onResponse(
                    call: Call<YelpSearchResult>,
                    response: Response<YelpSearchResult>
                ) {
                    Log.i(TAG, "onResponse $response")
                    val body = response.body()
                    swipeContainer?.setRefreshing(false);
                    if (body == null) {
                        Log.w(TAG, "Did not receive valid response body from Yelp API... exiting")
                        return
                    }
                    restaurants.clear()
                    restaurants.addAll(body.restaurants)
                    Log.i(TAG, "$restaurants")
                    adapter.notifyDataSetChanged()
                }

                override fun onFailure(call: Call<YelpSearchResult>, t: Throwable) {
                    Log.i(TAG, "onFailure $t")
                }
            })
    }

    fun iniRefreshListener() {
        swipeContainer = findViewById<SwipeRefreshLayout>(R.id.swipe_layout)
        swipeContainer.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener { // This method gets called when user pull for refresh,
            // You can make your API call here,
            if (swipeContainer.isRefreshing()) {
                updateSearch()
//                    swipeRefreshLayout.setRefreshing(false)
            }
        })
    }


    private fun initializeView() {
        // create objects of TextView and Seekbar
        val sliderValue: TextView = findViewById(R.id.selected_distance)
        sliderValue.text = radius.toString()
        val slider: SeekBar = findViewById(R.id.slider)

        // set the max value of the slider using setMax function
        slider.max = 5000
        // set initial
        slider.setProgress(500)

//        slider.

        slider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            // override the onProgressChanged method to perform operations
            // whenever the there a change in SeekBar
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                radius = progress
                sliderValue.text = (progress.toDouble() / 1000).toString() + "km"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
    }


}
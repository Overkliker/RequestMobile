package com.example.requests

import android.net.DnsResolver
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.requests.adapters.RecycleAdapter
import com.example.requests.common.Common
import com.example.requests.models.CounterName
import com.example.requests.models.Counters
import com.example.requests.retrofit.RequestsService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var requestsService: RequestsService
    lateinit var recycleAdapter: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        recycleAdapter = findViewById(R.id.listCounters)

        recycleAdapter.setHasFixedSize(true);
        recycleAdapter.layoutManager = LinearLayoutManager(this);
        requestsService = Common.retrofitService

        getCounters()

    }

    private fun getCounters(){
        requestsService.getAllCounters().enqueue(object: Callback<List<CounterName>> {
            override fun onResponse(call: Call<List<CounterName>>, response: Response<List<CounterName>>) {
                val counters = response.body()!!
                Log.w("aaaaaaaaa", counters.toString())
                recycleAdapter.adapter = RecycleAdapter(counters = counters,
                    context = this@MainActivity)
            }

            override fun onFailure(call: Call<List<CounterName>>, t: Throwable) {
                Log.d("DATA", t.message.toString())
            }

        })

    }
}
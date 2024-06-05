package com.example.requests

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.requests.common.Common
import com.example.requests.models.FullInfo
import com.example.requests.retrofit.RequestsService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CurrentCounter : AppCompatActivity() {
    lateinit var counterId: String

    lateinit var model: TextView
    lateinit var bus: TextView
    lateinit var password: TextView
    lateinit var number: TextView

    lateinit var deleteBtn: Button

    lateinit var requestsService: RequestsService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_current_counter)

        model = findViewById(R.id.model)
        bus = findViewById(R.id.bus)
        password = findViewById(R.id.password)
        number = findViewById(R.id.number)

        deleteBtn = findViewById(R.id.delete)

        requestsService = Common.retrofitService

        val intent: Intent = intent;

        counterId = intent.getStringExtra("uuid")!!


        getFullInfo()

        deleteBtn.setOnClickListener(View.OnClickListener {
            requestsService.deleteCounter(counterId!!).enqueue(object : Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    Toast.makeText(this@CurrentCounter,
                        response.body().toString(),Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })

            val intent = Intent(this@CurrentCounter, MainActivity::class.java)

            startActivity(intent)
        })
    }

    private fun getFullInfo() {
        requestsService.getCounterInfo(counterId!!).enqueue(object: Callback<FullInfo>{
            override fun onResponse(call: Call<FullInfo>, response: Response<FullInfo>) {
                val info = response.body()!!

                model.text = info.counterModel.name
                bus.text = info.counterBus.ipAddress + ":" + info.counterBus.port
                password.text = info.counter.password
                number.text = info.counter.number


            }

            override fun onFailure(call: Call<FullInfo>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

}
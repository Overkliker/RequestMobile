package com.example.requests.retrofit

import com.example.requests.models.Counter
import com.example.requests.models.CounterName
import com.example.requests.models.Counters
import com.example.requests.models.FullInfo
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RequestsService {

    @GET("counters/names")
    fun getAllCounters(): Call<List<CounterName>>

    @GET("counters/{uuid}/fullInfo")
    fun getCounterInfo(@Path("uuid") uuid: String): Call<FullInfo>

    @DELETE("counters/delete/{uuid}")
    fun deleteCounter(@Path("uuid") uuid: String): Call<String>


}
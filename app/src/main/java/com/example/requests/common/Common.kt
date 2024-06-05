package com.example.requests.common

import com.example.requests.retrofit.RequestsService
import com.example.requests.retrofit.RetrofitClient

object Common {
    private val url = "https://417a-80-252-149-29.ngrok-free.app/api/v1/";

    val retrofitService: RequestsService get() =
            RetrofitClient.getClient(url).create(RequestsService::class.java)
}
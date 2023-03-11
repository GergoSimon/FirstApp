package com.example.firstapp

import android.media.Image
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface MyApiService {

    @GET("api/?results=30&?inc=name,email,picture")
    suspend fun getUsers(): Response<ApiResponse>

}
package com.example.for_job

import retrofit2.Response
import retrofit2.http.GET

interface Api_Interfase {
    @GET("/")
    suspend fun getAllProducts():Response<>
}
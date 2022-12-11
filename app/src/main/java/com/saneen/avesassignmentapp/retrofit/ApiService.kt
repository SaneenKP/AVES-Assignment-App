package com.saneen.avesassignmentapp.retrofit

import retrofit2.Response
import com.saneen.avesassignmentapp.models.Result

import retrofit2.http.GET

interface ApiService {

    @GET("photos/")
    suspend fun getData() : Response<List<Result>>
}
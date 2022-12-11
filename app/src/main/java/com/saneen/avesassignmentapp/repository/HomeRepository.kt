package com.saneen.avesassignmentapp.repository

import com.saneen.avesassignmentapp.retrofit.RetrofitClient
import com.saneen.avesassignmentapp.retrofit.ResponseWrapper
import com.saneen.avesassignmentapp.models.Result

class HomeRepository {

    private val client : RetrofitClient = RetrofitClient()

    suspend fun getData() : ResponseWrapper<List<Result>>?{
        val response = client.getResults()
        if (response.isSuccessful){
            response.body()?.let {
                return ResponseWrapper.success(it)
            }
        }else{
            return ResponseWrapper.error(response.message())
        }
        return null
    }
}
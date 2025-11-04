package com.rindra.mvvmapp.service

import com.rindra.mvvmapp.model.User
import retrofit2.http.GET

interface ApiService {
    @GET("users/{id}")
    suspend fun getUser(id:Int=1): User
}
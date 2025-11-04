package com.rindra.mvvmapp.repository

import com.rindra.mvvmapp.model.User
import com.rindra.mvvmapp.service.ApiClient
import kotlinx.coroutines.delay

class UserRepository {
//    mock fetch user, ex: from db
    suspend fun getUser(id:Int=3): User{
        return ApiClient.api.getUser(id)
    }
}
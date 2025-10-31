package com.rindra.mvvmapp.repository

import com.rindra.mvvmapp.model.User
import kotlinx.coroutines.delay

class UserRepository {
//    mock fetch user, ex: from db
    suspend fun getUser(): User{
        delay(2000)
        return User(id = 1, username = "john")
    }
}
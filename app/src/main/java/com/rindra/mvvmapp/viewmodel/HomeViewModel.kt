package com.rindra.mvvmapp.viewmodel

import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rindra.mvvmapp.model.User
import com.rindra.mvvmapp.repository.UserRepository
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    val userRepository = UserRepository()

    private var _user = MutableLiveData<User>()
    var user: LiveData<User> = _user

    private var _loading = MutableLiveData<Boolean>()
    var loading: LiveData<Boolean> = _loading

    fun getUser(id:Int=1){
        _loading.postValue(true)
        viewModelScope.launch {
            val result = userRepository.getUser(id)
            _user.postValue(result)
            _loading.postValue(false)
        }
    }
}
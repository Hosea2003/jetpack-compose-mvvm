package com.rindra.mvvmapp.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.rindra.mvvmapp.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel
) {
    val user = viewModel.user.observeAsState()
    val loading = viewModel.loading.observeAsState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
    ) {
        Button(
            onClick = {
                viewModel.getUser()
            }
        ) {
            Text(text = "Get user")
        }
        if(loading.value==true){
            CircularProgressIndicator()
        }
        else{
            if(user.value!==null){
                Text(text="username: ${user.value!!.username}")
            }
        }
    }
}
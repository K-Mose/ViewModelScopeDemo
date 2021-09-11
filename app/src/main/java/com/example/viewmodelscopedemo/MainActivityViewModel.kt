package com.example.viewmodelscopedemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class MainActivityViewModel : ViewModel() {
    /*
    private val myJob = Job()
    private val myScope = CoroutineScope(Dispatchers.IO + myJob)
    */

    private var userRepository = UserRepository()
    var users : MutableLiveData<List<User>> = MutableLiveData()
    fun getUserData() {
        // myScope.launch {
        // ViewModelScope는 CoroutineScope를 ViewModel에 묶는 것이다.
        viewModelScope.launch {
            var result : List<User>? = null
            withContext(Dispatchers.IO) {
                result = userRepository.getUsers()
            }
            users.value = result
        }
    }

    /*// ViewModelScope에서는 자동으로 처리
    override fun onCleared() {
        super.onCleared()
        myJob.cancel() // canceling coroutine manually
        // 코루틴이 많아지면 보일러플레이트 코드가 많아질 수 있다.
    }*/



}
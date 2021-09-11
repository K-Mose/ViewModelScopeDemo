package com.example.viewmodelscopedemo

import kotlinx.coroutines.delay

class UserRepository {
    // 네트워크로 REST API 부르는 것과 비슷한 역할
    suspend fun getUsers() : List<User> {
        delay(8000)
        val users : List<User> = listOf(
            User(1, "김"),
            User(2, "이"),
            User(3, "박"),
            User(4, "최"),
            User(5, "양"),
            User(6, "하"),
        )
        return users
    }
}
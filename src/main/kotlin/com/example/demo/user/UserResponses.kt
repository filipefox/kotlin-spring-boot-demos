package com.example.demo.user

data class UserResponse(
    val id: Long,
    val name: String
)

fun User.toResponse() = UserResponse(
    id = id,
    name = name
)
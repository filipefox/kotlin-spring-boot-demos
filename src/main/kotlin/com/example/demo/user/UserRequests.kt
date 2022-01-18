package com.example.demo.user

data class UserCreateRequest(
    val name: String
)

fun UserCreateRequest.toEntity() = User(
    name = name
)

data class UserUpdateRequest(
    val name: String
)

fun UserUpdateRequest.toEntity(id: Long) = User(
    id = id,
    name = name
)
package com.example.demo.user

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity(name = "users")
class User(
    @Id
    @GeneratedValue
    val id: Long = 0,
    val name: String
)
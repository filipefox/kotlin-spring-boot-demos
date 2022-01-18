package com.example.demo.user

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
class UserController(
    private val userRepository: UserRepository
) {
    @PostMapping("/users")
    fun create(
        @RequestBody userCreateRequest: UserCreateRequest
    ): ResponseEntity<UserResponse> {
        val user = userRepository.save(userCreateRequest.toEntity())
        return ResponseEntity.ok(user.toResponse())
    }

    @GetMapping("/users")
    fun read(): ResponseEntity<List<UserResponse>> {
        val users = userRepository.findAll()
        return ResponseEntity.ok(users.map { it.toResponse() })
    }

    @PatchMapping("/users/{userId}")
    fun update(
        @PathVariable userId: Long,
        @RequestBody userUpdateRequest: UserUpdateRequest
    ): ResponseEntity<UserResponse> {
        userRepository.findById(userId).orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }
        val user = userRepository.save(userUpdateRequest.toEntity(userId))
        return ResponseEntity.ok(user.toResponse())
    }

    @DeleteMapping("/users/{userId}")
    fun delete(
        @PathVariable userId: Long
    ) {
        userRepository.findById(userId).orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }
        userRepository.deleteById(userId)
    }
}
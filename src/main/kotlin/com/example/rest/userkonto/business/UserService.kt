package com.example.rest.userkonto.business

import com.example.rest.userkonto.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*

@Service
class UserService(private val repository: UserRepository) {

	@GetMapping("/")
	fun findAll() = repository.findAll()

	@GetMapping("/{login}")
	fun findOne(@PathVariable login: String) = repository.findByLogin(login)

}

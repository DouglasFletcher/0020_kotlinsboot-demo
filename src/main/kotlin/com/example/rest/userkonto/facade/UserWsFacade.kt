package com.example.rest.userkonto.facade

import com.example.rest.userkonto.repository.UserRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(private val repository: UserRepository) {

	@GetMapping("/")
	fun findAll() = repository.findAll()

	@GetMapping("/{login}")
	fun findOne(@PathVariable login: String) = repository.findByLogin(login)

}

package com.example.rest.userkonto.repository

import com.example.rest.base.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {
	fun findByLogin(login: String): User
}


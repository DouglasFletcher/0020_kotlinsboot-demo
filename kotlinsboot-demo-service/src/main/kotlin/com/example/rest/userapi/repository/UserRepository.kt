package com.example.rest.userapi.repository

import com.example.rest.base.entities.User
import org.springframework.data.repository.CrudRepository

/**
 * repository layer example
 */
interface UserRepository : CrudRepository<User, String> {

	/**
	 * get user object by login id
	 * @param login name
	 * @return User user
	 */
	fun findByLogin(login: String): User

}


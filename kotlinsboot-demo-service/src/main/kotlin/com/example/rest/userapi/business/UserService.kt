package com.example.rest.userapi.business

import com.example.rest.userapi.mapper.UserConverter
import com.example.rest.userapi.repository.UserRepository
import com.example.rest.userapi.transfer.UserTO
import org.springframework.stereotype.Service

/**
 * example user login rest service
 */
@Service
class UserService(
		private val userRepository: UserRepository,
		private val userConverter: UserConverter) {

	/**
	 * business logic
	 */
    fun findUserByLogin(login: String): UserTO {
		// get from database
		val user = userRepository.findByLogin(login)
		// convert to DTO
		return userConverter.convertToDto(user)
	}

}

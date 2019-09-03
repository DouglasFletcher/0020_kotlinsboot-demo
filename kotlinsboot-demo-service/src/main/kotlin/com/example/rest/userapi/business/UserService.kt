package com.example.rest.userapi.business

import com.example.rest.base.messages.UserMessages
import com.example.rest.userapi.exceptions.CannotFindLoginException
import com.example.rest.userapi.mapper.UserMapper
import com.example.rest.userapi.repository.UserRepository
import com.example.rest.userapi.transfer.UserTO
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service

/**
 * example user login rest service
 */
@Service
class UserService(private val userRepository: UserRepository, private val userMapper: UserMapper){

	/**
	 * business logic
	 * @login login name
	 * @throws CannotFindLoginException login not found
	 */
	@Throws(CannotFindLoginException::class)
    fun findUserByLogin(login: String): UserTO {
		try {
			// get from database
			val user = userRepository.findByLogin(login)
			// map to dto
			return userMapper.convertToDto(user)
		} catch (e: EmptyResultDataAccessException) {
			throw CannotFindLoginException(UserMessages.userNotFound.format(login))
		}
	}

}

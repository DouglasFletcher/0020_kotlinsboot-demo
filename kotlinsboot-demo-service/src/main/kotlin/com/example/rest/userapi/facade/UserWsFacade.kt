package com.example.rest.userapi.facade

import com.example.rest.userapi.business.UserService
import com.example.rest.userapi.transfer.UserTO
import org.springframework.web.bind.annotation.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable

/**
 * base facade entry point to userAPI
 */
@RestController
@RequestMapping("/user")
class UserWsFacade(private val userService: UserService){

	/**
	 * get user details with login
	 * @param login from path
	 * @return Response with user dto
 	 */
	@GetMapping("/{login}")
	fun findOne(@PathVariable login: String): ResponseEntity<UserTO> { //
		val userTO = userService.findUserByLogin(login)
		return ResponseEntity.ok().body(userTO)
	}

}

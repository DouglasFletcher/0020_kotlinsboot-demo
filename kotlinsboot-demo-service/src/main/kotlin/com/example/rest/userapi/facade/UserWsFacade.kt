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
	 * @param username from path
	 * @return Response with user dto
 	 */
	@GetMapping("/{username}")
	fun findOne(@PathVariable username: String): ResponseEntity<UserTO> { //
		val userTO = userService.findUserByUsername(username)
		return ResponseEntity.ok().body(userTO)
	}

}

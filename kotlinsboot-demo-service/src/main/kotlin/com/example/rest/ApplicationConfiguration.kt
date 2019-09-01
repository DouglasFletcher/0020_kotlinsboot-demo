package com.example.rest

import com.example.rest.base.entities.User
import com.example.rest.userapi.repository.UserRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ApplicationConfiguration {

    @Bean
    fun databaseInitializer(userRepository: UserRepository) = ApplicationRunner {
		// generate default login
        userRepository.save(
            User(login="dofletcher"
                , firstname = "douglas"
                , lastname = "fletcher"
                , description = "deloitte employee"
            )
        )
    }
}
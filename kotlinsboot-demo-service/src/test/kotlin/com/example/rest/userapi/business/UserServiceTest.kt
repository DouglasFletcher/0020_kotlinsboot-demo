package com.example.rest.userapi.business

import com.example.rest.base.entities.User
import com.example.rest.base.messages.UserMessages
import com.example.rest.userapi.exceptions.CannotFindLoginException
import com.example.rest.userapi.mapper.UserMapper
import com.example.rest.userapi.repository.UserRepository
import com.example.rest.userapi.transfer.UserTO
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.*
import org.mockito.Mockito.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.test.context.junit4.SpringRunner
import kotlin.test.assertEquals

@RunWith(SpringRunner::class)
@SpringBootTest
class UserServiceTest {

    @Mock
    val userRepository: UserRepository = mock(UserRepository::class.java)

    @Autowired
    lateinit var userMapper: UserMapper

    lateinit var userService: UserService

    @Before
    fun init(){
        userService = UserService(userRepository, userMapper)
    }

    @Test
    fun `findUserByLogin should return UserTO`() {
        // mocks
        doReturn(createUser()).`when`(userRepository)
            .findByLogin(anyString())
        // run
        val actual = userService.findUserByLogin("test")
        // test
        verify(userRepository, times(1))
            .findByLogin(anyString())
        assertEquals(actual.id, createUserTO().id)
    }

    @Test
    fun `findUserByLogin should throw CannotFindLoginException`() {
        // mocks
        doThrow(EmptyResultDataAccessException(1)).`when`(userRepository)
                .findByLogin(anyString())
        // run
        try {
            userService.findUserByLogin("test")
        } catch(e: CannotFindLoginException) {
            assertTrue(e.message.equals(UserMessages.userNotFound.format("test")))
            verify(userRepository, times(1))
                .findByLogin(anyString())
        }
    }

    /**
     * test createUserTO
     */
    private fun createUser(): User {
        return User("id","login","first","last","des")
    }

    private fun createUserTO(): UserTO {
        return UserTO("login","first","last","des","id")
    }

}


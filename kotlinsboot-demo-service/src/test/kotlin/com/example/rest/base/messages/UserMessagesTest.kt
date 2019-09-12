package com.example.rest.base.messages

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
class UserMessagesTest {

    lateinit var user: User

    @Before
    fun init(){
        user = User()
    }

    @Test
    fun `set and get all methods`() {
        // mocks
        user.login = "login"
        user.description = "description"
        user.id = "id"
        user.lastname = "lastname"
        user.firstname = "firstname"
        assertEquals(user.description, "description")
        assertEquals(user.login, "login")
        assertEquals(user.id, "id")
        assertEquals(user.lastname, "lastname")
        assertEquals(user.firstname, "firstname")
    }

}


package com.example.rest.userapi.mapper

import com.example.rest.base.entities.User
import com.example.rest.userapi.transfer.UserTO
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import kotlin.test.assertEquals

@RunWith(SpringRunner::class)
@SpringBootTest
class UserMapperTest {

    @Autowired
    lateinit var userMapper: UserMapper

    @Test
    fun `convertToModel from userTO`() {
        val expected = createUser()
        val actual = userMapper.convertToModel(createUserTO())
        assertEquals(expected.id, actual.id)
        assertEquals(expected.description, actual.description)
        assertEquals(expected.firstname, actual.firstname)
        assertEquals(expected.lastname, actual.lastname)
        assertEquals(expected.login, actual.login)
    }

    private fun createUserTO(): UserTO {
        val userTO = UserTO()
        userTO.id = "id"
        userTO.lastname = "lastname"
        userTO.firstname = "firstname"
        userTO.username = "username"
        userTO.description = "description"
        return userTO
    }

    private fun createUser(): User {
        val user = User()
        user.id = "id"
        user.lastname = "lastname"
        user.firstname = "firstname"
        user.login = "username"
        user.description = "description"
        return user
    }
}

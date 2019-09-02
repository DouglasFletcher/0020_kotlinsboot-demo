package com.example.rest.userapi.business

import com.example.rest.base.entities.User
import com.example.rest.userapi.mapper.UserMapper
import com.example.rest.userapi.repository.UserRepository
import com.example.rest.userapi.transfer.UserTO
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.*
import org.mockito.Mockito.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertEquals


@SpringBootTest
class UserServiceTest {

    @Mock
    val userRepository: UserRepository = mock(UserRepository::class.java)

    @Autowired
    lateinit var userMapper: UserMapper

    @InjectMocks
    lateinit var userService: UserService

    @Before
    fun init(){
        MockitoAnnotations.initMocks(this)
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
        assertEquals(actual, createUserTO())
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


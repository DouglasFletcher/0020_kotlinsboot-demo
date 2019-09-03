package com.example.rest.userapi.facade

import com.example.rest.userapi.business.UserService
import com.example.rest.userapi.transfer.UserTO
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.mockito.MockitoAnnotations
import org.mockito.InjectMocks
import io.restassured.module.mockmvc.RestAssuredMockMvc
import org.junit.Ignore
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@RunWith(SpringRunner::class)
@SpringBootTest
class UserWsFacadeTest {

    private val JSON_GET = "{\"username\":\"username\",\"firstname\":\"first\",\"lastname\":\"last\",\"description\":\"des\",\"id\":\"id\"}"

    @Mock
    val userService: UserService = mock(UserService::class.java)

    lateinit var userWsFacade: UserWsFacade

    lateinit var mockMvc: MockMvc

    @Before
    fun init(){
        // TODO move
        `when`(userService.findUserByLogin(anyString())).thenReturn(createUserTO())
        userWsFacade = UserWsFacade(userService)
        MockitoAnnotations.initMocks(this)
        mockMvc = MockMvcBuilders//
                .standaloneSetup(userWsFacade)
                .build()
        RestAssuredMockMvc.mockMvc(mockMvc)
    }

    @Test
    fun `findOne should return ResponseEntityOk`() {
        // run
        val user = createUserTO()
        // tests
        val requestBuilder = get("/user/{username}", user.username)
        val resultActions = this.mockMvc.perform(requestBuilder)
        resultActions//
            .andExpect(status().isOk)
            .andExpect(content().string(JSON_GET))
            .andReturn()
        // TODO check
        //verify(userService, times(1)).findUserByLogin(anyString())
        verifyNoMoreInteractions(userService)
    }

    // TODO implement
    @Test
    @Ignore
    fun `findUserByLogin should throw CannotFindLoginException`() {
    }

    /**
     * test createUserTO
     */
    private fun createUserTO(): UserTO {
        return UserTO("username","first","last","des","id")
    }

}


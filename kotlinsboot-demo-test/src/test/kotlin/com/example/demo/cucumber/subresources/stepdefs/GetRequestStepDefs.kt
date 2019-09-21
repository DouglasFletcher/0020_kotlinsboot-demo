package com.example.demo.cucumber.subresources.stepdefs

import com.example.demo.cucumber.subresources.testObjects.UserTO
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import cucumber.api.java.en.And
import com.example.demo.cucumber.subresources.utility.DataStorage
import org.junit.After
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class GetRequestStepDefs {

    private var userData: String = "expectedUserTO"

    @Given("^the user with the following values exists:")
    fun saveTestData(user: MutableMap<String, String>){
        val expected = UserTO(user) as Any
        // save expected response
        DataStorage.saveTestData(userData, expected)
    }

    @When("^a request with base uri (.*) and parameter (.*)$")
    fun makeGetRequest(baseUri: String, param: String){
        // use rest assured to make request with param
        // save response to storage
        print(String.format("baseUri: %s, param: %s", baseUri, param))
    }

    @Then("the status of the request is (.*)$")
    fun checkStatus(status: String){
        // check response
        assertNotNull(status)
        assertEquals(status, "OK")
        print(String.format("status %s", status))
    }

    @And("the response is what is expected$")
    fun checkData(){
        // check actual as expected
        val expected = DataStorage.getTestData(userData)
        print(String.format("expected: %s", expected))
        assertNotNull(expected)
    }

    @After
    fun tearDown(){
        DataStorage.emptyTestData()
    }
}
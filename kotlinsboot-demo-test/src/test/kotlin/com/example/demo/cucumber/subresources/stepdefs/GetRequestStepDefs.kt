package com.example.demo.cucumber.subresources.stepdefs

import com.example.demo.cucumber.subresources.testObjects.UserTO
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import cucumber.api.java.en.And
import com.example.demo.cucumber.subresources.utility.DataStorage
import com.example.demo.cucumber.subresources.utility.RestApi
import com.jayway.restassured.response.Response
import org.apache.http.HttpStatus
import org.junit.After
import java.lang.Exception
import kotlin.test.assertNotNull

class GetRequestStepDefs {

    private var expUserTO: String = "expectedUserTO"
    private var actUserTO: String = "actualUserTO"

    @Given("^the user with the following values exists:")
    fun saveTestData(user: MutableMap<String, String>){
        val expected = UserTO(user) as Any
        // save expected response
        DataStorage.saveTestData(expUserTO, expected)
    }

    @When("^a request with path (.*) and parameter (.*) is made$")
    fun makeGetRequest(path: String, param: String){
        // use rest assured to make request with param
        val response = RestApi(
            String.format("%s/%s", path, param)
        ).get()
        DataStorage.saveTestData(actUserTO, response)
        assertNotNull(response, "null api response")
    }

    @Then("the status of the request is (.*)$")
    fun checkStatus(status: String){
        // check response
        val response = DataStorage.getTestData(actUserTO) as Response
        // expected
        val expStatus = parseExpStatus(status)
        // check response
        response.then().log().ifValidationFails().statusCode(expStatus)
    }

    @And("the response contains the expected data$")
    fun checkData(){
        // check actual as expected
        val expected = DataStorage.getTestData(expUserTO)
        print(String.format("expected: %s", expected))
        assertNotNull(expected)
    }

    private fun parseExpStatus(status: String): Int {
        return when (status) {
            "SUCCESS" -> HttpStatus.SC_OK
            "FAILED" -> HttpStatus.SC_NOT_FOUND
            else -> {
                throw Exception("Unknown expected status")
            }
        }
    }

    @After
    fun tearDown(){
        DataStorage.emptyTestData()
    }
}
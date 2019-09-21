package com.example.demo.cucumber.subresources.stepdefs

import com.example.demo.cucumber.subresources.testObjects.UserTO
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import cucumber.api.java.en.And
import com.example.demo.cucumber.subresources.utility.DataStorage
import org.junit.After

class GetRequestStepDefs {

    private var userData: String = "USER"

    @Given("^the user with the following values exists:")
    fun saveTestData(user: MutableMap<String, String>){
        val userTO = UserTO(user) as Any
        // save expected response
        DataStorage.saveTestData(userData, userTO)
    }

    @When("^a request with base uri (.*) and parameter (.*)$")
    fun makeGetRequest(baseUri: String, param: String){
        val userTO = DataStorage.getTestData(userData)
        print(String.format("userTO: %s", userTO))
        print(String.format("baseUri: %s, param: %s", baseUri, param))
    }

    @Then("the status of the request is (.*)$")
    fun checkStatus(status: String){
        print(String.format("status %s", status))
    }

    @And("the data matches what is in the database$")
    fun checkData(){
        print("all ok")
    }

    @After
    fun tearDown(){
        DataStorage.emptyTestData()
    }
}
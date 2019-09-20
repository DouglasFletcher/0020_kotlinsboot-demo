package com.example.demo.cucumber.subresources.stepdefs

import com.example.demo.cucumber.subresources.testObjects.UserTO
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import cucumber.api.java.en.And
import com.example.demo.cucumber.subresources.utility.DataStorage

class GetRequestStepDefs {

    private userData: String = "USER"

    @Given("^the user with the following values exists:")
    fun saveTestData(user: Map<String, String>){
        val userTO = UserTO()
        DataStorage.saveTestData("userData", userTO)
        user.forEach {
            print(String.format("key %s, value %s", it.key, it.value))
        }
    }

    @When("^a request with base uri (.*) and parameter (.*)$")
    fun makeGetRequest(baseUri: String, param: String){
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
}
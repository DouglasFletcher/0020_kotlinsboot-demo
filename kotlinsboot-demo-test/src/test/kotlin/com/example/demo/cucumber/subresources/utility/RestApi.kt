package com.example.demo.cucumber.subresources.utility

import com.jayway.restassured.RestAssured.given
import com.jayway.restassured.response.Response
import com.jayway.restassured.specification.RequestSpecification

class RestApi(param: String) {

    private var requestSpecification: RequestSpecification = given()
        // todo read from properties
        .baseUri("http://localhost")
        .port(8080)
        .basePath(param)

    /**
     * get request
     */
    fun get(): Response {
        return given()
            .spec(requestSpecification)
            .`when`()
            .log()
            .ifValidationFails()
            .get()
    }

}
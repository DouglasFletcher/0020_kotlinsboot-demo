package com.example.demo.cucumber.subresources.stepdefs

import com.example.demo.cucumber.subresources.testObjects.Belly
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import kotlin.test.assertEquals

class StepDefs {

    @Given("^I have (\\d+) cakes in my belly$")
    fun checkTheBelly(cake: Int) {
        val belly = Belly()
        belly.eat(cake)
        print(String.format("string %s", cake))
    }


    @When("^I wait (\\d+) hour$")
    fun digestCake(hours: Int){
        assertEquals(1, hours)
        print(String.format("hours waited %s", hours))
    }

    @Then("My belly should grumble with loudness (\\d+)$")
    fun burpLoud(scale: Int){
        assertEquals(1, scale)
        print(String.format("height %s", scale))
    }

}
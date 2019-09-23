package com.example.demo.cucumber.runner

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(
        features = ["features"],
        tags = ["not @ignored"],
        glue = ["com.example.demo.cucumber.subresources"])
class RunKukesTest
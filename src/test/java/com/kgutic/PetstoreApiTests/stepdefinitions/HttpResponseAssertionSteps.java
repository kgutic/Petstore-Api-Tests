package com.kgutic.PetstoreApiTests.stepdefinitions;

import io.cucumber.java.en.Then;

import static net.serenitybdd.rest.SerenityRest.then;

public class HttpResponseAssertionSteps {
    @Then("the response status code is {int}")
    public void theResponseStatusCodeIs(int expectedStatusCode) {
        then().statusCode(expectedStatusCode);
    }
}

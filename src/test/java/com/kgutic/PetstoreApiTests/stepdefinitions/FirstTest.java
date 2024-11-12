package com.kgutic.PetstoreApiTests.stepdefinitions;

import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;


public class FirstTest {
    @Given("the get endpoint is called")
    public void theGetEndpointIsCalled() {
        given().log().all()
                .basePath("api/v3/pet/1")
                .accept(ContentType.JSON)
                .get();
        then().log().all();

    }
}
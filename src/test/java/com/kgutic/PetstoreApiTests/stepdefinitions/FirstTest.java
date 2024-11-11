package com.kgutic.PetstoreApiTests.stepdefinitions;

import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;


public class FirstTest {
    @Given("the get endpoint is called")
    public void theGetEndpointIsCalled() {
        given()
                .baseUri("https://petstore.swagger.io/v2/pet/")
                .basePath("0")
                .accept(ContentType.JSON)
                .get();
        then().log().all();

    }
}
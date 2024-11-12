package com.kgutic.PetstoreApiTests.stepdefinitions;

import com.kgutic.PetstoreApiTests.config.TestConfiguration;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.annotations.Shared;
import net.serenitybdd.core.Serenity;

@Slf4j
public class TestSetup {
    @Shared
    private TestConfiguration testConfiguration;

    @Before
    public void setTheBaseUri(){
        log.info("Setting baseURI to {}", testConfiguration.getEndpointUrl());
        Serenity.recordReportData().withTitle("BaseURI").andContents(testConfiguration.getEndpointUrl());
        RestAssured.baseURI = testConfiguration.getEndpointUrl();
    }
}

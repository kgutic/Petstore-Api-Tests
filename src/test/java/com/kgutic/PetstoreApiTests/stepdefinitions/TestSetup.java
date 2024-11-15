package com.kgutic.PetstoreApiTests.stepdefinitions;

import com.kgutic.PetstoreApiTests.config.TestConfiguration;
import com.kgutic.PetstoreApiTests.pet.PetService;
import com.kgutic.PetstoreApiTests.world.PetWorld;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.annotations.Shared;
import net.serenitybdd.core.Serenity;

@Slf4j
public class TestSetup {
    @Shared
    private TestConfiguration testConfiguration;
    @Shared
    private PetWorld petWorld;
    @Shared
    private PetService petService;

    @Before
    public void setTheBaseUri(){
        log.info("Setting baseURI to {}", testConfiguration.getEndpointUrl());
        Serenity.recordReportData().withTitle("BaseURI").andContents(testConfiguration.getEndpointUrl());
        RestAssured.baseURI = testConfiguration.getEndpointUrl();
    }

    @After
    public void deletePet(){
        if (petWorld.getPetId() != null)  {
            petService.deletePet(petWorld.getPetId());
        }
    }
}

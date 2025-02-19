package com.kgutic.api.stepdefinitions;

import com.kgutic.api.config.TestConfiguration;
import com.kgutic.api.order.OrderService;
import com.kgutic.api.pet.PetService;
import com.kgutic.api.world.PetWorld;
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
    @Shared
    private OrderService orderService;

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

    @After
    public void deleteOrder(){
        if (petWorld.getOrderId() != null)  {
            orderService.deleteOrder(petWorld.getOrderId());
        }
    }
}

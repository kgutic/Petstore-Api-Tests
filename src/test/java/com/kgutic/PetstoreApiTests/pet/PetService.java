package com.kgutic.PetstoreApiTests.pet;

import com.kgutic.pss.generated.model.PetDTO;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;

public class PetService {
    public static final String PET_PATH = "api/v3/pet";

    public void createPet(PetDTO petDTO) {
        given()
                .basePath(PET_PATH)
                .body(petDTO, ObjectMapperType.JACKSON_2)
                .contentType(ContentType.JSON)
                .post();
        then().log().all();
    }

    public void deletePet(long petId){
        given()
                .basePath(PET_PATH)
                .delete(String.valueOf(petId));
    }
}

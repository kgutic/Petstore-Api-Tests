package com.kgutic.PetstoreApiTests.pet;

import com.kgutic.pss.generated.model.PetDTO;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;

import static net.serenitybdd.rest.SerenityRest.given;

public class PetService {
    public static final String PET_PATH = "api/v3/pet";

    public void createPet(PetDTO petDTO) {
        given()
                .basePath(PET_PATH)
                .body(petDTO, ObjectMapperType.JACKSON_2)
                .contentType(ContentType.JSON)
                .post();
    }

    public void deletePet(long petId){
        given()
                .basePath(PET_PATH)
                .delete(String.valueOf(petId));
    }

    public void getPetById(long petId){
        given()
                .basePath(PET_PATH)
                .accept(ContentType.JSON)
                .get(String.valueOf(petId));
    }
}

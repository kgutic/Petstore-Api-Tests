package com.kgutic.api.stepdefinitions;

import com.kgutic.api.config.TestUtils;
import com.kgutic.api.datatables.Pet;
import com.kgutic.api.pet.PetService;
import com.kgutic.api.world.PetWorld;
import com.kgutic.pss.generated.model.CategoryDTO;
import com.kgutic.pss.generated.model.PetDTO;
import com.kgutic.pss.generated.model.TagDTO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Shared;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.then;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PetSteps {
    private PetDTO petDTO;
    @Shared
    private PetService petService;
    @Shared
    private PetWorld petWorld;

    @Given("a new pet is ready to be added with following details")
    public void aNewPetIsReadyToBeAddedWithFollowingDetails(List<Map<String, String>> petTable) {
        petDTO = createNewPetDtoFromDataTable(petTable);
    }

    @When("the request is sent to add a new pet")
    public void theRequestIsSentToAddANewPet() {
        petService.createPet(petDTO);
        petDTO = then().extract().body().as(PetDTO.class);
    }

    @Given("a new pet is added with following details")
    public void aNewPetIsAddedWithFollowingDetails(List<Map<String, String>> petTable) {
        petDTO = createNewPetDtoFromDataTable(petTable);
        petService.createPet(petDTO);
    }

    @When("the request is sent to delete this pet")
    public void theRequestIsSentToDeleteThisPet() {
        petService.deletePet(petWorld.getPetId());
    }

    @And("following details are returned in the response")
    public void followingDetailsAreReturnedInTheResponse(List<Pet> petData) {
        Pet expectedPet = petData.get(0);

        assertThat(petDTO.getId()).isEqualTo(petWorld.getPetId());
        assertThat(petDTO.getName()).isEqualTo(expectedPet.getName());
        assertThat(petDTO.getCategory().getId()).isEqualTo(expectedPet.getCategoryId());
        assertThat(petDTO.getCategory().getName()).isEqualTo(expectedPet.getCategoryName());
        assertThat(petDTO.getPhotoUrls()).isEqualTo(expectedPet.getPhotoUrls());
        assertThat(petDTO.getStatus().getValue()).isEqualTo(expectedPet.getStatus());
    }

    @When("the request is sent to search for this pet by ID")
    public void theRequestIsSentToSearchForThisPetByID() {
        petService.getPetById(petWorld.getPetId());
        petDTO = then().extract().body().as(PetDTO.class);
    }

    @And("the pet no longer exists in the store")
    public void thePetNoLongerExistsInTheStore() {
        petService.getPetById(petWorld.getPetId());
        then().statusCode(404);
    }

    private PetDTO createNewPetDtoFromDataTable(List<Map<String, String>> petTable) {
        petWorld.setPetId(TestUtils.getRandomPetId());
        CategoryDTO categoryDTO = new CategoryDTO()
                .id(Long.valueOf(petTable.get(0).get("categoryId")))
                .name(petTable.get(0).get("categoryName"));
        TagDTO tagDTO = new TagDTO()
                .id(Long.valueOf(petTable.get(0).get("tagId")))
                .name(petTable.get(0).get("tagName"));
        return new PetDTO()
                .id(petWorld.getPetId())
                .name(petTable.get(0).get("name"))
                .category(categoryDTO)
                .photoUrls(List.of(petTable.get(0).get("photoUrls")))
                .tags(List.of(tagDTO))
                .status(PetDTO.StatusEnum.fromValue(petTable.get(0).get("status")));
    }

}

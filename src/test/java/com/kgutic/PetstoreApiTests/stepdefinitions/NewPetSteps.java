package com.kgutic.PetstoreApiTests.stepdefinitions;

import com.kgutic.PetstoreApiTests.config.TestUtils;
import com.kgutic.PetstoreApiTests.datatables.Pet;
import com.kgutic.PetstoreApiTests.pet.PetService;
import com.kgutic.PetstoreApiTests.world.PetWorld;
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

public class NewPetSteps {
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

    private PetDTO createNewPetDtoFromDataTable(List<Map<String, String>> petTable) {
        CategoryDTO categoryDTO = new CategoryDTO()
                .id(Long.valueOf(petTable.get(0).get("categoryId")))
                .name(petTable.get(0).get("categoryName"));
        TagDTO tagDTO = new TagDTO()
                .id(Long.valueOf(petTable.get(0).get("tagId")))
                .name(petTable.get(0).get("tagName"));
        petWorld.setPetId(TestUtils.getRandomPetId());

        return new PetDTO()
                .status(PetDTO.StatusEnum.fromValue(petTable.get(0).get("status")))
                .id(petWorld.getPetId())
                .name(petTable.get(0).get("name"))
                .photoUrls(List.of(petTable.get(0).get("photoUrls")))
                .category(categoryDTO)
                .tags(List.of(tagDTO));
    }

    @And("following details are returned in the response")
    public void followingDetailsAreReturnedInTheResponse(List<Pet> petData) {
        Pet expectedPet = petData.get(0);

        assertThat(petDTO.getId()).isEqualTo(petWorld.getPetId());
        assertThat(petDTO.getName()).isEqualTo(expectedPet.getName());
        assertThat(petDTO.getCategory().getId()).isEqualTo(expectedPet.getCategoryId());
        assertThat(petDTO.getCategory().getName()).isEqualTo(expectedPet.getCategoryName());
        assertThat(petDTO.getPhotoUrls().get(0)).isEqualTo(expectedPet.getPhotoUrls());
        assertThat(petDTO.getStatus().getValue()).isEqualTo(expectedPet.getStatus());
    }
}

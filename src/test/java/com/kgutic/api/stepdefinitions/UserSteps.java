package com.kgutic.api.stepdefinitions;

import com.kgutic.api.config.TestUtils;
import com.kgutic.api.datatables.User;
import com.kgutic.api.user.UserService;
import com.kgutic.api.world.PetWorld;
import com.kgutic.pss.generated.model.UserDTO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.annotations.Shared;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.then;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
public class UserSteps {
    private UserDTO userDTO;
    @Shared
    private PetWorld petWorld;
    @Shared
    private UserService userService;

    @Given("a new user is ready to be added with following details")
    public void aNewUserIsReadyToBeAddedWithFollowingDetails(List<Map<String, String>> userTable) {
        userDTO = createNewUserDtoFromDataTable(userTable);
    }

    @When("the request is sent to add a new user")
    public void theRequestIsSentToAddANewUser() {
        userService.createUser(userDTO);
    Response response = then().extract().response();

        if (response.statusCode() == 200) {
            userDTO = response.getBody().as(UserDTO.class);
        } else {
            log.error("Error while creating new user {}", response.body().asString());
        }
    }

    @And("the details returned in the response are")
    public void theDetailsReturnedInTheResponseAre(List<User> userData) {
        User expectedUser = userData.get(0);

        assertThat(userDTO.getId()).isEqualTo(petWorld.getUserId());
        assertThat(userDTO.getUsername()).isEqualTo(expectedUser.getUserName());
        assertThat(userDTO.getFirstName()).isEqualTo(expectedUser.getFirstName());
        assertThat(userDTO.getLastName()).isEqualTo(expectedUser.getLastName());
        assertThat(userDTO.getEmail()).isEqualTo(expectedUser.getEmail());
        assertThat(userDTO.getPassword()).isEqualTo(petWorld.getPassword());
        assertThat(userDTO.getPhone()).isEqualTo(expectedUser.getPhone());
        assertThat(userDTO.getUserStatus()).isEqualTo(expectedUser.getStatus());
    }

    private UserDTO createNewUserDtoFromDataTable(List<Map<String, String>> userTable) {
        petWorld.setUserId(TestUtils.getRandomUserId());
        petWorld.setPassword(TestUtils.getRandomPassword());
        return new UserDTO()
                .id(petWorld.getUserId())
                .username(userTable.get(0).get("username"))
                .firstName(userTable.get(0).get("firstName"))
                .lastName(userTable.get(0).get("lastName"))
                .email(userTable.get(0).get("email"))
                .password(petWorld.getPassword())
                .phone(userTable.get(0).get("phone"))
                .userStatus(Integer.valueOf(userTable.get(0).get("status")));
    }
}

package com.kgutic.api.stepdefinitions;

import com.kgutic.api.config.TestUtils;
import com.kgutic.api.world.PetWorld;
import com.kgutic.pss.generated.model.UserDTO;
import io.cucumber.java.en.Given;
import net.serenitybdd.annotations.Shared;

import java.util.List;
import java.util.Map;

public class UserSteps {
    @Shared
    private PetWorld petWorld;
    private UserDTO userDTO;

    @Given("a new user is ready to be added with following details")
    public void aNewUserIsReadyToBeAddedWithFollowingDetails(List<Map<String, String>> userTable) {
        userDTO = createNewUserFromDto(userTable);
    }

    private UserDTO createNewUserFromDto(List<Map<String, String>> userTable) {
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

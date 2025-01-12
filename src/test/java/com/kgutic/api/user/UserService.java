package com.kgutic.api.user;


import com.kgutic.pss.generated.model.UserDTO;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;

public class UserService {
    public static final String USER_PATH = "api/v3/user";

    public void createUser(UserDTO userDTO) {
        given()
                .basePath(USER_PATH)
                .body(userDTO, ObjectMapperType.JACKSON_2)
                .contentType(ContentType.JSON)
                .post();
        then().log().all();
    }
}

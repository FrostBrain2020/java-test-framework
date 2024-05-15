package com.frostbrain2020.api;

import io.restassured.response.Response;

import static io.restassured.http.ContentType.JSON;
import static org.frostBrain2020.properties.EnvironmentProperties.BASE_URL;
import static com.frostbrain2020.utils.RequestUtils.getBaseRequestSpecification;

public class GetUsernameApi {

    public static Response getUsername(String username){
        return getBaseRequestSpecification()
                .contentType(JSON)
                .when()
                .get(BASE_URL + "/users/" + username)
                .prettyPeek();
    }
}

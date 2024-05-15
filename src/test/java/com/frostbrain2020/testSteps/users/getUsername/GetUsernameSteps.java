package com.frostbrain2020.testSteps.users.getUsername;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.frostbrain2020.api.GetUsernameApi;
import com.frostbrain2020.assertions.CustomAssertion;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.frostBrain2020.properties.EnvironmentProperties.BASE_URL;

public class GetUsernameSteps {
    Response response;
    static ObjectMapper mapper = new ObjectMapper();
    private static final String fakeUsername = "RandomUserName335527";

    @Step
    public void getIncorrectUsername(){
        response = GetUsernameApi.getUsername(fakeUsername);
    }

    @Step
    public void checkIncorrectUserStatus(){
        CustomAssertion.assertThat(response)
                .has404StatusCode();
    }
}

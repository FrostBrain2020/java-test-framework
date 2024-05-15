package com.frostbrain2020.testSteps.users.getUsername;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.frostbrain2020.api.GetUsernameApi;
import com.frostbrain2020.api.model.GetUsername;
import com.frostbrain2020.assertions.CustomAssertion;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import com.fasterxml.jackson.databind.ObjectMapper;


import static org.frostBrain2020.properties.EnvironmentProperties.USERNAME;
import static org.frostBrain2020.properties.EnvironmentProperties.USERNAME_REQUIRED_FIELD;

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

    @Step
    public void getCorrectUsername(){
        response = GetUsernameApi.getUsername(USERNAME);
    }

    @Step
    public void checkCorrectUserStatus(){
        CustomAssertion.assertThat(response)
                .has200StatusCode();
    }

    @Step
    public void checkUsernameRequiredFields() throws JsonProcessingException {
        //TODO: Add assertions for all required fields. For now only assertion exists on login and id
//        String requiredFields[] = USERNAME_REQUIRED_FIELD
//                .replace("\"", "")
//                .split(",");
        CustomAssertion.assertThat(mapper.readValue(response.getBody().print(), GetUsername.class))
                .hasLogin()
                .hasId();

    }
}

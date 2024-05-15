package com.frostbrain2020.assertions;

import com.frostbrain2020.api.model.GetUsername;
import io.restassured.response.Response;

public class CustomAssertion {
    public static ResponseAssertion assertThat(Response response) {return new ResponseAssertion(response); }
    public static UserAssertion assertThat(GetUsername user) { return new UserAssertion(user); }
}

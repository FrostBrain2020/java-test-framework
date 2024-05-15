package com.frostbrain2020.assertions;

import io.restassured.response.Response;

public class CustomAssertion {
    public static ResponseAssertion assertThat(Response response) {return new ResponseAssertion(response); }
}

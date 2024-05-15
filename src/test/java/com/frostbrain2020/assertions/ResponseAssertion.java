package com.frostbrain2020.assertions;

import io.restassured.response.Response;

import static org.assertj.core.api.Assertions.assertThat;

public class ResponseAssertion {
    final Response response;

    ResponseAssertion(Response response){
        this.response = response;
    }

    public ResponseAssertion has200StatusCode(){
        assertThat(response.getStatusCode())
                .as("Response HTTP status code is incorrect")
                .isEqualTo(200);
        return this;
    }

    public ResponseAssertion has404StatusCode(){
        assertThat(response.getStatusCode())
                .as("Response HTTP status code is incorrect")
                .isEqualTo(404);
        return this;
    }

}

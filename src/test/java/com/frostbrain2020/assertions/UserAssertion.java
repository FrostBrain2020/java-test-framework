package com.frostbrain2020.assertions;

import com.frostbrain2020.api.model.GetUsername;

import static org.assertj.core.api.Assertions.assertThat;

public class UserAssertion {
    private final GetUsername user;

    UserAssertion(GetUsername user){ this.user = user; }

    public UserAssertion hasLogin(){
        assertThat(user.getLogin())
                .as("Not exists 'login' key in json")
                .isNotEmpty();
        return this;
    }

    public UserAssertion hasId(){
        assertThat(user.getId())
                .as("Not exists 'id' key in json")
                .isNotEmpty();
        return this;
    }

    //TODO: Add assertions for all fields

}

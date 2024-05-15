package com.frostbrain2020.testSteps.users.getUsername;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.frostBrain2020.properties.EnvironmentProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetUsernameDefSteps {

    private static final Logger log = LoggerFactory.getLogger(EnvironmentProperties.class);

    @Steps
    private GetUsernameSteps getUsernameSteps;

    @When("Send GET request with incorrect username")
    public void sendIncorrectUsername(){
        getUsernameSteps.getIncorrectUsername();
    }

    @Then("I received HTTP response 404")
    public void checkHttpStatus(){
        getUsernameSteps.checkIncorrectUserStatus();
    }
}

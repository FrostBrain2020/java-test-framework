package com.frostbrain2020.testSteps.users.getUsername;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
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
    public void checkHttpStatus404(){
        getUsernameSteps.checkIncorrectUserStatus();
    }

    @When("Send GET request with correct username")
    public void sendCorrectUsername(){
        getUsernameSteps.getCorrectUsername();
    }

    @Then("I received HTTP response 200")
    public void checkHttpStatus200(){
        getUsernameSteps.checkCorrectUserStatus();
    }

    @And("I received all required fields for endpoint username")
    public void checkRequiredFields(){
        try {
            getUsernameSteps.checkUsernameRequiredFields();
        } catch (JsonProcessingException e) {
            log.error("Problem with mapping JSON on class GetUsername");
            e.printStackTrace();
        }
    }

}

package com.frostbrain2020.testSuites;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    plugin = "pretty",
    tags = "@test",
    glue = "com.frostbrain2020",
    features = "src/test/resources/features/users/"
)
public class UsersTestSuite {
}

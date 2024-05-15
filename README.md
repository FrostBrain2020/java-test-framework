# Test Automation Framework
Example endpoints (/users/{username}) tests in Java Test Framework

> The project covers the basic scope of creating the **Test Automation Framework**, including:
> - basic REST API test

![](https://img.shields.io/badge/Code-Java%2017-informational?style=flat&color=blueviolet)
![](https://img.shields.io/badge/Build-Maven-informational?style=flat&color=blueviolet)
![](https://img.shields.io/badge/Test_Framework-JUnit5-informational?style=flat&color=blueviolet)

[//]: # (![]&#40;https://img.shields.io/badge/Library_to_UI_tests-Selenium-informational?style=flat&color=blueviolet&#41;)
![](https://img.shields.io/badge/Framework_to_implemented_BDD-Cucumber-informational?style=flat&color=blueviolet)
![](https://img.shields.io/badge/Library_to_API_tests-Rest_Assured-informational?style=flat&color=blueviolet)
![](https://img.shields.io/badge/Reports-Serenity-informational?style=flat&color=blueviolet)

**Test Automation Framework (TAF)** - the environment required for test automation including test harnesses and artifacts
such as test libraries. 

A **test automation framework** that is easy to use, well documented and maintainable, supports a consistent approach to
automating tests. In order to establish an easy to use and maintainable TAF, the following framework meets expectations such as: 
- Implement reporting facilities 
- Enable easy troubleshooting 
- Address the test environment appropriately 
- Document the automated test cases 
- Trace the automated test 
- Enable easy maintenance
- Keep the automated test up-to-date
- Plan for deployment
- Retire test as needed
- Monitor and restore the SUT (System Under Test)

The components that make up a test automation framework include test data, driver scripts, environment variables, 
general user library, object repository, and tests execution report. 

Natural benefits of implementing automated tests:
 - It eliminates repetitive manual testing that consumes lots of time and effort. 

## How To Run The Test
1. Clone the [repo](https://github.com/FrostBrain2020/java-test-framework).
2. If you want to run a project locally, you can use command:
```
mvn clean verify -Dtest.suite.name=<suite_name> -DenvConfig=<environment>
```
example:
```
mvn clean verify -DenvConfig=qa -Dtest.suite.name=UsersTestSuite
```
3. After the tests are performed, two types of reports are generated: \
   a. **Full report** located in: */target/site/serenity/index.html* \
   b. **Single Page HTML Summary** located in : */target/site/serenity/serenity-summary.html*

## Implemented Features 
- Generating a single page report in HTML format for each run of a tests
- Implementation example REST API tests with chain assertion pattern
- Possibility to run tests on different environments

## Project Structures 
```
integration-tests
│   README.md                  # this file      
|   pom.xml                    # pom for build, running, and generating report for the project         
└─── src 
     └── main           
        │   properties         # folder with environments settings 
     └── test           
        └── java               
        |    |   api           # models - Jackson model for serialization
        |    |                 # api's class - class with requerst definition   
        |    |   assertions    # all assertion using "Chain assertion model"; main class - CustomAssertions
        |    |                 # with a large number of assertion classes, it is worth separating the main class 
        |    |                 # (CustomAssertions) into smaller grouped ones
        |    |   testsSteps    # all DefSteps with Steps classes splitted by functionalities
        |    |   testsSuites   # list of all Suites
        |    |   utils         # support folder ex. for RequestUtils       
        └── resources 
            |   environments   # properties with lists of env attributes used in tests ex. base_url etc. 
            |   features       # cucumbers features described in the BDD convention
            |   cucumber.pr... # cucumber settings for not generating a report after the tests
            |   logback.xml    # setting the level of logs in the console when performing tests

```

## Using Libraries 
- JUnit 5
- Serenity
- Jackson

## Design Patterns Using In The Code
- Test written in BDD convention
- Chain custom assertion model


---
## Q&A Section 
### How to run tests with a specific test suite?
1. If you don't want to declare a specific tests suite on startup, all tests suites will run by default.
> If you want to overwrite the default test suite settings, you need to change the value **test.suite.name** in the main pom file.
2. Run command with test suite declaration
```
mvn clean verify -Dtest.suite.name=<suite_name> -DenvConfig=<environment>
```

### How to run tests on a specific environment?
Run command with environment declaration, ex.
```
mvn clean verify -DenvConfig=<environment>
```
The list of available environments is in: _test\resources\environments_

### How to add a new variable to environment settings?
1. Select file in _test\resources\environments_ where you would like to put the new variable. You need to add a new property file if you want to add a new environment.
2. Add a new variable and save.
3. Check if the kay of a new variable was declared in class **EnvironmentProperties.java**. If not, you need to add this declaration. 
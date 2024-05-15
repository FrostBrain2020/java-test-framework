@test
  Feature: REST API: Users/{username}
    # Description:
    # Get public available information about user with a GitHub account
    # Documentation: https://docs.github.com/en/rest/users/users?apiVersion=2022-11-28

    Scenario: System return HTTP 404 when user not exist in GitHub
      When Send GET request with incorrect username
      Then I received HTTP response 404

    Scenario: System return required fields in the response
      When Send GET request with correct username
      Then I received HTTP response 200
       And I received all required fields for endpoint username

#      TODO: Implement rest tests
#    Scenario: System return correct data in the response
#    Scenario: System return correct data for private user
#    Scenario: System return required fields in the response for private user

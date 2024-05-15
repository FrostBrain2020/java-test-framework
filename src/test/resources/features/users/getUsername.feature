@test
  Feature: REST API: Users/{username}
  # Description:
  # Get public available information about user with a GitHub account

    Scenario: System return HTTP 404 when user not exist in GitHub
      When Send GET request with incorrect username
      Then I received HTTP response 404
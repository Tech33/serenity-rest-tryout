

@api3
Feature: Pet API test

  Scenario: Get Pet API
    Given I have a pet store API
    When I call get end point for fetching pets and with status as "available"
    Then I should get the status code as 200

  Scenario: Create Pet API
    Given I have a pet store API
    When I create a new pet with body
    Then I should get the status code as 200
    And New pet is created successfully
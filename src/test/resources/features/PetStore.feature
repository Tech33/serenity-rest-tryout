@api
Feature: Pet API test
#
#  Scenario: Get Pet API
#    Given I have a pet store API
#    When I call get end point for fetching pets and with status as "available"
#    Then I should get the status code as 200
#
#  Scenario: Create Pet API
#    Given I have a pet store API
#    When I create a new pet with body
#    Then I should get the status code as 200
#    And New pet is created successfully

  @api121
  Scenario Outline: Get Pet API
    Given User have the petstore API
    When User call "GET" Request on the Pet "<endpoint>"
    When I use the response value
    Then User should get the status code as 200 for Pet API
    Examples:
      | endpoint |
      | /pet/findByStatus?status=available|

  Scenario Outline: Create Pet API
    Given User have the petstore API
    When User call "POST" Request on the Pet "<endpoint>" with dynamically generated body
    Then User should get the status code as 200 for Pet API
    And New pet is created successfully
    Examples:
      | endpoint |
      | /pet     |
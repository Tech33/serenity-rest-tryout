@apiNo
Feature: Fake Rest API

  Scenario Outline: Create Author API
    Given User have a Author API
    When User call "POST" Request on the Author "<endpoint>" with dynamically generated body
    Then User should get the status code as 200 for Author API
    And New Author is created successfully
    Examples:
      | endpoint |
      | /Activities |
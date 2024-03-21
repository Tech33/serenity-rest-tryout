Feature: Basic checks for search/repositories parameters
  - required Parameters (**q**)
  - optional Parameters (**sort**, **order**)
  - **order** parameter is ignored if **sort** parameter is not present
  - default sorting is done on **best match** (no parameter present) by score value from response

  @automated @smoke
  Scenario Outline: Should receive response if q parameter is used in query and data
    Given the client uses the following url parameters:
      | q | <value> |
    Then the client should receive an HTTP 200 response code
    Then the client using jsonPath 'items' should see <numberItems> elements
    And the client using jsonPath 'total_count' should see having <numberTotal>
    And the client using jsonPath 'incomplete_results' should see having boolean false
    And the client using jsonPath 'items' should see having value '<language>' for all elements with key 'language'
    And the client using jsonPath 'items' should see containing value '<name>' for all elements with keys:
      | name        |
      | description |
    Examples:
      | value                                        | numberItems | numberTotal | language | name         |
      | tetris language:assembly created:<2013-12-31 | 30          | 60          | Assembly | tetris       |
      | serenity language:java created:<2018-12-31   | 30          | 634         | Java     | serenity |
      | behat language:ruby created:<2018-12-31      | 9           | 9           | Ruby     | behat        |

  @automated1
  Scenario: Get Pet API
#    Given I have a pet store API
    Given the client uses the following url parameters:
      | status | available |
    When the client calls 'SEARCH_PETSTORE' endpoint
#    When I call get end point for fetching pets and with status as "available"
    Then the client should receive an HTTP 200 response code

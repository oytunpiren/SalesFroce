@google
Feature: Google Search Function


  Scenario Outline: User able to search
    Given User go to website
    Then user search "<product>"

    Examples:
      | product       |
      | wooden spoon  |
      | apple macbook |
      | cartier watch |

  Scenario: User able to search
    Given user go to website
    Then user create a account
      | wooden spoon  |
    Then verify


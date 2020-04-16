Feature: Google Search Function

  @google
  Scenario Outline: User able to search
    Given User go to website
    Then user search "<product>"

    Examples:
      | product       |
      | wooden spoon  |
      | apple macbook |
      | cartier watch |
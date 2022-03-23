Feature: Colour lovers API
  I want to test colour lovers api

  Scenario: Send valid request to GET colour patterns
    Given User set GET colour patterns endpoint
    And User set request header
    When User submit GET request to colour lovers
    Then User should receive valid status code 200

Scenario: Verify that "numViews" is greater than 4000
Given User set GET colour patterns endpoint
And User set request header
When User Get colour pattern
Then Verify numViews greater than 4000


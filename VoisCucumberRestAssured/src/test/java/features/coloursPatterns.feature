Feature: Colour patterns API
  I want to test colour patterns for colour lovers api

  Background:
    Given User set GET colour patterns endpoint
    And User set request header

  Scenario: Send valid request to GET colour patterns
    When User submit GET request to colour lovers
    Then User should receive valid status code 200

  Scenario: Verify that "numViews" is greater than 4000
    When User submit GET request to colour lovers
    Then Verify numViews is greater than 4000
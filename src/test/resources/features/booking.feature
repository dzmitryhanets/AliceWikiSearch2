Feature: Booking search
  Scenario: Search booking page for Europe
    Given I want to search for "Europe Minsk"
    When I do search
    Then Results page should contain "Europe Minsk"
    And Rate is "9"
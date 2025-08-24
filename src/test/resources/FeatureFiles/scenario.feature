Feature: Broken link validation
  @TC_UIF2A_Commerce_01
  Scenario: Verify broken links on a web page
    Given I launch the browser
    When I navigate to "https://www.cakes.com/us"
    And I should find all broken links
    And I should find broken dynamic content
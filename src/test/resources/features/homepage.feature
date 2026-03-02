Feature: Homepage validation
  As a user I want to verify that the homepage loads successfully
  So that I know the application is accessible
  Scenario: Verify homepage loads successfully
    Given the user launches the application
    When the homepage is loaded
    Then the homepage title should contain "nopCommerce demo store"


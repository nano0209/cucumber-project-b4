
Feature: Docuport Login Logout Feature




@xray @smoke
  Scenario: Login as a client
  Given user is on Docuport login page
    When user enters username for client
    And user enters password for client
    And user click login button
    Then user should be able to see the home page for client
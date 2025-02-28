Feature: Docuport Login Logout Feature
Background: this is for navigating Docuport login page
  Given user is on Docuport login page


@smoke
  Scenario: Login as a client
    When user enters username for client
    And user enters password for client
    And user click login button
    Then user should be able to see the home page for client

@smoke
  Scenario: Login as a employee
    When user enters username for employee
    And user enters password for employee
    And user click login button
    Then user should be able to see the home page for employee

@smoke
  Scenario: Login as a advisor
    When user enters username for advisor
    And user enters password for advisor
    And user click login button
    Then user should be able to see the home page for advisor


  @smoke
  Scenario: Login as supervisor
    When user enters username for supervisor
    And user enters password for supervisor
    And user click login button
    Then user should be able to see the home page for supervisor

  @dataTableLogin @smoke
  Scenario: Login as a client map practice
    When user enters credentials
      | username | b1g1_client@gmail.com |
      | password | Group1                |
    Then user should bbe able to see the home for client


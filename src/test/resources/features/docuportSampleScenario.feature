Feature: Docuport Sample Scenario
@na
Scenario: Practice click buttons on different pages as a client
  Given user is on Docuport login page
  When user inserts "b1g1_client@gmail.com" to "username" field on "Login" page
  When user inserts "Group1" to "password" field on "Login" page
  And user clicks "login" button on "Login" page
  And user clicks "continue" button on "Choose account" page
  Then user should be able to see the home page for client
  And user clicks "Received Doc" button on "Left Navigate" page
  And user clicks "Search" button on "Received Doc" page
  And user inserts "tax document" to "Document name" field on "Received Doc" page
  And user clicks "My Uploads" button on "Left Navigate" page
  And user clicks "Upload Documents" button on "My Uploads" page
  And user clicks "Upload file" button on "My uploads" page
  And user uploads document




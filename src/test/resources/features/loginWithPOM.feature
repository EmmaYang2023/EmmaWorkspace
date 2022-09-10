Feature: Login

  Scenario: Login With POM
    Given [POM] user is on the homepage
    And [POM] user clicks on the login link button
    When [POM] user enters email and password
      | email                            | password |
      | muradil.erkin@boratechschool.com | Boratech |
    And [POM] user clicks on submit login button
    Then [POM] user should be on the dashboard page

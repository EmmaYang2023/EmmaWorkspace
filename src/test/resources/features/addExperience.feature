@addExperience
Feature: Add Experience

  @smoke @regression @ui
  Scenario: Add a New Experience
    Given user is logged in
      | username                         | password |
      | muradil.erkin@boratechschool.com | Boratech |
    Then user should be navigated to the "Dashboard" page
    Then user clicks the "Add Experience" button
    Then user should be navigated to the "Add An Experience" page
    When user adds an experience
      | jobtitle | company   | location      | from     | current | to | description           |
      | Cashier  | Mcdonalds | Annandale, VA | 09012021 | true    |    | I donot like this job |
    Then user should see the success alert

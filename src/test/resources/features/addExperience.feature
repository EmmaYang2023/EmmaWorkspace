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
      | title   | company   | location      | from     | current | to | description           |
      | Cashier | Mcdonalds | Annandale, VA | 09012021 | true    |    | I donot like this job |
    Then user should see the success alert

  @regression @api
  Scenario: Add a new experience with API
    Given [API] user is logged in
      | email                            | password |
      | muradil.erkin@boratechschool.com | Boratech |
    Then [API] user adds an experience
      | title   | company   | location      | from       | current | to | description           | errors                                                        |
      | Cashier | Mcdonalds | Annandale, VA | 2021/09/01 | true    |    | I donot like this job |                                                               |
      |         | Mcdonalds | Annandale, VA | 2021/09/01 | true    |    | I donot like this job | Title is required                                             |
      |         |           | Annandale, VA | 2021/09/01 | true    |    | I donot like this job | Title is required, Company is required                        |
      |         |           | Annandale, VA |            | true    |    | I donot like this job | Title is required, Company is required, From date is required |

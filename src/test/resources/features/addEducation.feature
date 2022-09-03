@ui @regression
Feature: Add Education

  Scenario: Title of your scenario
    Given user is logged in
      | username                     | password   |
      | yadikaeryashengdmv@gmail.com | yadang0306 |
    Then User updates "add education"
      | school   | degree                 | fieldofstudy  | from date  | current | to   | description  |
      | BoraTech | Test automation degree | Test Automation | 05/07/2022 | true    | null | This is fun! |
    Then user should see the success alert

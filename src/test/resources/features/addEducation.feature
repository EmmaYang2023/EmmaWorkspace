@addEducation
Feature: Add Education

  @smoke @regression @ui
  Scenario: Adding education
    Given user is logged in
      | username                     | password   |
      | yadikaeryashengdmv@gmail.com | yadang0306 |
    Then user should be navigated to the "Dashboard" page
    When user clicks the "Add Education" button
    Then user should be navigated to the "Add Your Education" page
    When user adds an education
      | school   | degree                 | fieldofstudy    | from date  | current | to   | description  |
      | BoraTech | Test automation degree | Test Automation | 05/07/2022 | true    | null | This is fun! |
    Then user should see the success alert

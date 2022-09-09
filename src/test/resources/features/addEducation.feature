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
      | school   | degree                 | fieldofstudy    | from       | current | to | description  |
      | BoraTech | Test automation degree | Test Automation | 2012/06/09 | true    |    | This is fun! |
    Then user should see the success alert

  @smoke @regression @api
  Scenario: Add a new education with API
    Given [API] user is logged in
      | username                         | password |
      | muradil.erkin@boratechschool.com | Boratech |
    Then [API] user adds an education
      | school   | degree                 | fieldofstudy    | from       | current | to | description  |
      | BoraTech | Test automation degree | Test Automation | 2022/05/07 | true    |    | This is fun! |

  @regression @api
  Scenario Outline: Add a new education with API - Error Path
    Given [API] user is logged in
      | username                         | password |
      | muradil.erkin@boratechschool.com | Boratech |
    Then [API] [ERROR] user adds an education
      | school   | degree   | fieldofstudy   | from   | current   | to   | description   | errors   |
      | <school> | <degree> | <fieldofstudy> | <from> | <current> | <to> | <description> | <errors> |

    Examples: 
      | school | degree                 | fieldofstudy    | from       | current | to | description  | errors                                                                                    |
      |        | Test automation degree | Test Automation | 2022/05/07 | true    |    | This is fun! | School is required                                                                        |
      |        |                        | Test Automation | 2022/05/07 | true    |    | This is fun! | School is required, Degree is required                                                    |
      |        |                        |                 | 2022/05/07 | true    |    | This is fun! | School is required, Degree is required, Field of study is required                        |
      |        |                        |                 |            | false   |    |              | School is required, Degree is required, Field of study is required, From date is required |

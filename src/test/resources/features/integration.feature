Feature: Integration

  Scenario Outline: AddEducation API to UI
    Given [API] user is logged in
      | email   | password   |
      | <email> | <password> |
    When [API] user adds an education
      | school   | degree   | fieldofstudy    | from       | current | to | description  |
      | <school> | <degree> | Test Automation | 2022/05/07 | true    |    | This is fun! |
    And user is logged in
      | email   | password   |
      | <email> | <password> |
    Then user should see the newly added education crendential
      | school   | degree   |
      | <school> | <degree> |

    Examples: 
      | email                            | password | school                    | degree                 |
      | muradil.erkin@boratechschool.com | Boratech | Bora Consulting Solutions | Test automation degree |

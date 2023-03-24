@Login
Feature: TIPS Login
  
  TIPS Appian Application Login

  @UI
  Scenario Outline: [UI] Log in with valid credentials
    Given I'm on Appian Loginpage
    And I enter username "<username>" and password "<password>"
    And Click SIGN IN
    Then I should be logged in
    And See the Dashboard page

    Examples: 
      | username  | password |
      | tips3.vs1 | appian3  |

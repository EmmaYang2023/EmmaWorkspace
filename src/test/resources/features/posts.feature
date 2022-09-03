@posts
Feature: Posts

	@smoke @regression @ui
  Scenario: Create Post
    Given user is logged in
      | username                         | password |
      | muradil.erkin@boratechschool.com | Boratech |
    When user clicks on the "Posts" navigation link
    Then user should be navigated to the "Posts" page
    When user enters the post comment
      | comment                                          |
      | Cucumber automation is a lot more than you think |
    And user submits the post
    Then user should see the success alert

@profile
Feature: Profile

  @api
  Scenario: Create or update profile happy path
    Given [API] user is logged in
      | email                            | password |
      | muradil.erkin@boratechschool.com | Boratech |
    When [API] user creates/updates the profile
      | company        | BoraTech                                                              |
      | website        | https://www.boraconsultingsolutions.com/                              |
      | location       | Annandale, VA                                                         |
      | status         | Test Automation Engineer                                              |
      | skills         | HTML, CSS, JavaScript, TypeScript, React.js, Node.js, AWS, Serverless |
      | githubusername | Muradil-Erkin                                                         |
      | bio            | I enjoy teaching people stuff                                         |
      | twitter        |                                                                       |
      | facebook       |                                                                       |
      | linkedin       | https://www.linkedin.com/in/muradil-erkin                             |
      | youtube        |                                                                       |
      | instagram      | https://www.instagram.com/muradilerkin                                |
    Then [API] user should receive the created/updated profile

  @ui
  Scenario: Create or update profile happy path
    Given user is logged in
      | email                            | password |
      | muradil.erkin@boratechschool.com | Boratech |
    When user creates/updates the profile
      | company        | BoraTech                                                              |
      | website        | https://www.boraconsultingsolutions.com/                              |
      | location       | Annandale, VA                                                         |
      | status         | Test Automation Engineer                                              |
      | skills         | HTML, CSS, JavaScript, TypeScript, React.js, Node.js, AWS, Serverless |
      | githubusername | Muradil-Erkin                                                         |
      | bio            | I enjoy teaching people stuff                                         |
      | twitter        |                                                                       |
      | facebook       |                                                                       |
      | linkedin       | https://www.linkedin.com/in/muradil-erkin                             |
      | youtube        |                                                                       |
      | instagram      | https://www.instagram.com/muradilerkin                                |
    Then user should see the success alert

Feature: Parabank Registration

  Scenario: User registers successfully
  	Given user launches the browser
    And user navigate to parabank application
    When user clicks on Register option
    When user enters all the mandatory details
    And user submits the registration form
    Then user gets success message

Feature: Parabank Login

  Scenario: User logs in successfully
    Given user launches the browser
    And user navigate to parabank application
    And user enters login credentials
    And user clicks Login button
    Then user should see Accounts Overview page

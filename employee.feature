@employee
Feature: Add new Employee

Background:
Given the user is on the OrangeHRM login page
When the user enters valid username and password

Scenario: TC_01_ Add a new employee sucessfully 
When user navigate PIM and clicks add option
When user enters mandatory details and save the details
Then user captures the username
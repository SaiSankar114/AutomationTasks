@admin
Feature: Add new Employee

Background:
Given the user is on the OrangeHRM login page
When the user enters valid username and password

Scenario:TC_01_Add admin details sucessfully
When user navigate admin and clicks add option
When user enters mandatory details and save the details
Then user search for added user
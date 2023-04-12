#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@login @regression
Feature: Crater app user management
  Users with permisssions should be able to interact
  with application on successful login

  @validLogin @loginTests @smokeTest
  Scenario: Successful log in
    Given I am on the login page
   	When I enter valid username and password
    And I click the login button
    Then I see the dashboard page
    
	@invalidLogin @loginTests
	Scenario: Invalid login attempts
		Given I am on the login page
		When I enter an invalid username and password
		And I click the login button
		Then I see an error message
		And I am not logged in
    
 
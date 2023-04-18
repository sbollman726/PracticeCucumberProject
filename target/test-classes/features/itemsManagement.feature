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
@regression @itemsTests
Feature: Items Management

@createItem @smoketest
Scenario: As a user, I am able to create an item or a service
    Given As an entity user, I am logged in
    And I navigate to Items tab
    When I click on the Add Item button
    Then I should be on item input page
    When I provide item information name "Books", price "18", unit "pc", and description "a good book"
    And I click Save Item button
    Then The Item is added to the Item list table

@updateItem
  Scenario: As a user, I am able to update an item or a service
    Given As an entity user, I am logged in
    And I navigate to Items tab
    When I select the item "Books"
    Then I should be on item details page
    When I update the item price to 30 dollars
    And I click Update Item button
    Then the Item price is updated to 30 dollars
    
    
    
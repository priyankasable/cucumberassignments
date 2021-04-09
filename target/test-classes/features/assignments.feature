@ui @healthcheck
Feature: Vision IT All Assignments

  Scenario: User is able to open the browser, verify the title and search for product t-shirts
    Given User Opend the Home Page
    When User Search for product "t-shirts"
    Then Search Result page is displayed
    
 
 
 Scenario: User is able to open the browser, check for logo
    Given User Opend the Home Page
    Then User Check for Logo result is diplyed
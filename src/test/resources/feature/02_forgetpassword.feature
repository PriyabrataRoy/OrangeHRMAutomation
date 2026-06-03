Feature: OrangeHRM Forgot Password Module

 
  Scenario: Verify forgot password link navigation
    Given User launches OrangeHRM application
    When User clicks on Forgot your password link
    Then User should be navigated to Reset Password page

  
  Scenario: Reset password with valid username
    Given User launches OrangeHRM application
    When User clicks on Forgot your password link
    And User enters valid username for reset
    And User clicks Reset Password button
    Then User should see success message

  
  Scenario: Reset password with invalid username
    Given User launches OrangeHRM application
    When User clicks on Forgot your password link
    And User enters invalid username for reset
    And User clicks Reset Password button
    Then User should see success message
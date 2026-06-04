Feature: OrangeHRM Logout Module

Scenario: Verify logout functionality
  Given User logs into OrangeHRM for Logout
  When User logs out from application
  Then User should be redirected to login page

Scenario: Verify session termination after logout
  Given User logs into OrangeHRM for Logout
  When User logs out from application
  And User clicks browser back button
  Then User should not access application without login
Feature: OrangeHRM Login

Scenario: Valid Login
Given User launches OrangeHRM application
When User enters valid username and valid password
And User clicks Login button
Then User should be navigated to dashboard

Scenario: Invalid Username
Given User launches OrangeHRM application
When User enters invalid username and valid password
And User clicks Login button
Then User should see invalid credential error

Scenario: Invalid Password
Given User launches OrangeHRM application
When User enters valid username and invalid password
And User clicks Login button
Then User should see invalid credential error

Scenario: Blank Credentials
Given User launches OrangeHRM application
When User clicks Login button
Then User should see required field validation

Scenario: Verify Login UI
Given User launches OrangeHRM application
Then Verify login page elements are displayed
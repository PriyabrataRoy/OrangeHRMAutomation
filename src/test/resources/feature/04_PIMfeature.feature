Feature: OrangeHRM PIM Module

Scenario: Add New Employee
  Given User logs into OrangeHRM
  When User navigates to PIM module
  And User adds a new employee
  Then Employee should be added successfully

Scenario: Search Employee By ID
  Given User logs into OrangeHRM
  When User navigates to PIM module
  And User searches employee by ID
  Then Employee record should be displayed

Scenario: Edit Employee Details
  Given User logs into OrangeHRM
  When User navigates to PIM module
  And User edits employee details
  Then Employee details should be updated

Scenario: Upload Employee Picture
  Given User logs into OrangeHRM
  When User navigates to PIM module
  And User uploads employee profile picture
  Then Profile picture should be uploaded successfully

Scenario: Delete Employee
  Given User logs into OrangeHRM
  When User navigates to PIM module
  And User deletes employee record
  Then Employee should be deleted successfully
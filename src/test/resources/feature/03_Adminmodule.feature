Feature: OrangeHRM Admin Module Scenarios

  Background:
    Given User launches OrangeHRM application
    When User enters valid username and valid password
    And User clicks Login button

  Scenario: 11. Verify Admin page access after login
    When User clicks on Admin tab
    Then User should see Admin section page header

  Scenario: 12. Search user by username
    When User clicks on Admin tab
    And User enters existing Username in search field
    And User clicks on Search button
    Then User details should be displayed in the system

  # MERGED LIFECYCLE (13, 14, and 15 combined into one session)
  Scenario: 13, 14, 15. Complete User Lifecycle (Create, Edit and Delete User)
    When User clicks on Admin tab
    
    # --- 13. Add User ---
    And User clicks on Add button
    And User selects User Role from dropdown
    And User selects Status from dropdown
    And User enters Employee Name for new user
    And User enters unique Username for new user
    And User enters Password for new user
    And User enters Confirm Password for new user
    And User clicks on Save button
    Then User should be added successfully
    
    # --- 14. Edit User (Bina session break kiye direct table se pick karega) ---
    When User clicks Edit button for the created user
    And User updates the username field with new value
    And User clicks on Save button
    Then User details should be updated successfully
    
    # --- 15. Delete User ---
    When User enters updated Username in search field
    And User clicks on Search button
    And User clicks Delete button for the updated user
    Then User should be deleted successfully from the system
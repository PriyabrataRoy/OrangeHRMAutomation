Feature: OrangeHRM My Info Module Scenarios

  Background:
    Given User launches OrangeHRM application
    When User enters valid username and valid password
    And User clicks Login button

  Scenario: 21, 22, 23, 24. Complete My Info Details Lifecycle
    When User clicks on My Info tab from sidebar menu
    Then User should be redirected to My Info personal details page
    
    # Personal Details Section Update
    When User updates Personal Details with new name strings
    And User clicks Save button on Personal Details form
    Then Personal Details should be saved and verified successfully
    
    # Contact Details Section Update
    When User navigates to Contact Details tab
    And User updates Contact Details for Australia address
    And User clicks Save button on Contact Details form
    Then Contact Details should be saved and verified successfully in system
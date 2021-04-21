@tag
Feature: Google Search 
				'When the user is on the Google search page and, Searches for any keyword then, related search results should be displayed'

 Scenario: Google search page validation
    Given the user is in Google page
    Then the page should display google logo
    And the page sholud have a search box
  
  Scenario: Google search results validation
    Given the user is in Google page
    When the user searches "ducks" in the google search box
    And click the search button
    Then results should be displayed
    And the searched word "ducks" should be mentioned in the results
    
 Scenario: Auto-suggestion in Google validation
    Given the user is in Google page
    When the user searches "duc" in the google search box
    Then google should give auto suggestions
    And the word "duck" should be mentioned in the auto suggestions

  Scenario: Search result on selecting suggested keyword and on providing the keyword directly should be the same
    Given the user is in Google page
    When the user searches "ducks" in the google search box
    And click the search button
    Then results should be displayed
    When the user searches "duc" in the google search box
    And click "duck" from the auto suggestions
    And click the search button
    Then results should be displayed 



Feature: Get (Logout )
Background: Admin sets authorization to bearer Token with token

Scenario: Check if Admin able to logout 
Given Admin creates request 
When Admin calls Get Https method with valid endpoint
Then Admin receives 200 ok  and response with "Logout successful"

Scenario: Check if Admin able to logout  with invalid endpoint
Given Admin creates request 
When Admin calls Get Https method withinvalid endpoint
Then Admin receives 404 Not found

Scenario: Check if Admin able to logout 
Given Admin creates request 
When Admin calls Get Https method with valid endpoint
Then Admin receives 401  unauthorized

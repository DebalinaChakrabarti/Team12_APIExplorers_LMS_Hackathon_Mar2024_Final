Feature: ProgramModule
Background: Admin sets Authorization
	#Given Admin navigates to the login page
	#When I submit username and password
	#Then I should be logged in 

  @tag
  	Scenario: Check if Admin able to create a program with valid endpoint and request body with Authorization
    Given Admin creates POST Request for the LMS with request body
    When Admin sends HTTPS Request and  request Body with endpoint
    Then Admin receives 201 Created Status with response body.
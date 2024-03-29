@tag
Feature: ProgramModule
Background: Admin sets Authorization
	#Given Admin navigates to the login page
	#When I submit username and password
	#Then I should be logged in 

  @CreateProgram
  	Scenario: Check if Admin able to create a program with valid endpoint and request body with Authorization
    Given Admin creates POST Request for the LMS with request body
    When Admin sends HTTPS Request and  request Body with endpoint
    Then Admin receives 201 Created Status with response body.
#
    #Scenario: Check if Admin able to create a program with invalid endpoint
    #Given Admin creates POST Request for the LMS with request body	
    #When Admin sends HTTPS Request and  request Body with invalid endpoint	
    #Then Admin receives 404 not found  Status with message and boolean success details
    #
    #Scenario: Check if Admin able to create a program with already existing program name 
    #Given Admin creates POST Request for the LMS with request body	
    #When Admin sends HTTPS Request and  request Body with endpoint	
    #Then Admin receives 400 Bad Request Status with message and boolean success details
    #
    
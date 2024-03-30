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
    
    #Scenario: Check if Admin able to retrieve all programs with valid Endpoint
    #Given Admin creates GET Request for the LMS API	
    #When Admin sends HTTPS Request with endpoint	
    #Then Admin receives 200 OK Status with response body.     
    
    #Scenario: Check if Admin able to retrieve a program with valid program ID
    #Given Admin creates GET Request for the LMS API	with valid Program ID
    #When Admin sends Get program Request with endpoint	
    #Then Admin receives 200 OK Status code with response body.      
    
    #Scenario: Check if Admin able to retrieve all programs with valid Endpoint
    #Given Admin creates GET Request for the LMS API	for Users
    #When Admin sends Get All programs with users Request with endpoint	
    #Then Admin receives 200 OK Status with response body of Users
    
    #Scenario: Check if Admin able to update a program with valid programID endpoint  and valid request body
    #Given Admin creates PUT Request for the LMS API endpoint with request Body with mandatory , additional  fields. 	
    #When Admin sends Put Request with valid endpoint
    #Then Admin receives 200 OK Status with updated value in response body. 
    #
    #Scenario: Check if Admin able to update a program with  Valid program Name and request body
    #Given Admin creates PUT Request with Program Name for the LMS API endpoint with valid request Body with mandatory , additional  fields. 	
    #When Admin sends Put Request with Program name with valid endpoint	
    #Then Admin receives 200 OK Status code with updated value in response body.  
    
    Scenario: Check if Admin able to delete a program with valid programName
    Given Admin creates DELETE Request for the LMS API endpoint  and  valid programName	
    When Admin sends Delete by ProgramName Request with endpoint	
    Then Admin receives 200 Ok status with message     
    
    Scenario: Check if Admin able to delete a program with valid program ID
    Given Admin creates DELETE Request for the LMS API endpoint  and  valid program ID	
    When Admin sends Delete Request By Program Name with endpoint	
    Then Admin receives 200 Ok status with message for delete by program name
                                       
    
    
    
    
    
                                                                                                                                                                                                             
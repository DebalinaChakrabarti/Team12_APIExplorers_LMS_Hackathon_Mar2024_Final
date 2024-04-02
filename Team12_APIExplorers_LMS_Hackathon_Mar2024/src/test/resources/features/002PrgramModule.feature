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

		Scenario: Check if Admin able to create a program with valid endpoint and request body without Authorization
		Given Admin creates POST Request for the LMS with request body
    When Admin sends Post Request and request Body with endpoint without Authorization
    Then Admin receives 401 Unauthorized error for post
    
    Scenario: Check if Admin able to create a program with invalid endpoint
    Given Admin creates POST Request for the LMS with request body	
    When Admin sends HTTPS Request and  request Body with invalid endpoint	
    Then Admin receives 404 not found  Status with message and boolean success details
    
    Scenario: Check if Admin able to create a program with already existing program name 
    Given Admin creates POST Request for the LMS with request body	
    When Admin sends Post Request with exsisting prgm name and  request Body with endpoint
    Then Admin receives 400 Bad Request Status with message and boolean success details
    
    Scenario: Check if Admin able to create a program with missing values in the request body
    Given Admin creates POST Request for the LMS with request body
    When Admin sends Post Request and missing Pgm Name in request Body with endpoint	
    Then Admin receives 400 Bad Request Status for missing value
    
    Scenario: Check if Admin able to create a program with invalid method
    Given Admin creates POST Request for the LMS with request body	
    When Admin sends Get Request instead of post and  request Body with endpoint	
    Then Admin receives 405 Method Not Allowed 
    
    Scenario: Check if Admin able to create a program without program name starting with a number  
    Given Admin creates POST Request for the LMS with request body	
    When Admin sends Post Request and Pgm Name starting with Number in request Body with endpoint	
    Then Admin receives 400 Bad Request Status for Pgm name starting with number
    
    ##BUG
    Scenario: Check if Admin able to create a program with missing additional field 
    Given Admin creates POST Request for the LMS with request body
    When Admin sends Post Request with request Body with missing additional field with endpoint	 
    Then Admin receives 200 ok for missing additional fields in program post request body
    
    
    
    
    ####GET REQUEST#################
    Scenario: Check if Admin able to retrieve all programs with valid Endpoint
    Given Admin creates GET Request for the LMS API	
    When Admin sends HTTPS Request with endpoint	
    Then Admin receives 200 OK Status with response body.    
    
    Scenario: Check if Admin able to retrieve all programs with valid Endpoint without auth
    Given Admin creates GET Request for the LMS API	
    When Admin sends Get Request and request Body with endpoint without Authorization
    Then Admin receives 401 Unauthorized error for put    
    
    Scenario: Check if Admin able to create a program with invalid endpoint
    Given Admin creates GET Request for the LMS API	
    When Admin sends Get Request and  request Body with invalid endpoint	
    Then Admin receives 404 not found Status for GET with message and boolean success details
    
    Scenario: Check if Admin able to create a program with invalid method
    Given Admin creates GET Request for the LMS API	
    When Admin sends Post Request instead of get and  request Body with endpoint	
    Then Admin receives 405 Method Not Allowed message
    
    Scenario: Check if Admin able to retrieve a program with valid program ID
    Given Admin creates GET Request for the LMS API	with valid Program ID
    When Admin sends Get program Request with endpoint	
    Then Admin receives 200 OK Status code with response body.     
    
    Scenario: Check if Admin able to retrieve all programs with valid prgm id without auth
    Given Admin creates GET Request for the LMS API	with valid Program ID
    When Admin sends Get Request by pgm id and request Body with endpoint without Authorization
    Then Admin receives 401 Unauthorized error for put by pgm id    
    
    Scenario: Check if Admin able to retrieve a program with invalid program ID 
    Given Admin creates GET Request for the LMS API	
    When Admin sends Get Request with invlaid ID and endpoint	
    Then Admin receives 404 Not Found Status for invalid PG Id with message and boolean success details 
    
    Scenario: Check if Admin able to retrieve a program with invalid baseURI
    Given Admin creates GET Request for the LMS API	with invalid baseURI
    When Admin sends Get Request Request with endpoint	
    Then Admin receives 404 Not Found Status for invalid baseurl with message and boolean success details
    
    Scenario: Check if Admin able to retrieve a program with invalid Endpoint
    Given Admin creates GET Request for the LMS API
    When Admin sends Get Request with pgm Id and  request Body with invalid endpoint
    Then Admin receives 404 Not Found Status for Get with Pgm Id with message and boolean success details
    
    Scenario: Check if Admin able to retrieve all programs with valid Endpoint
    Given Admin creates GET Request for the LMS API	for Users
    When Admin sends Get All programs with users Request with endpoint	
    Then Admin receives 200 OK Status with response body of Users
    
    Scenario: Check if Admin able to retrieve a program with invalid Endpoint
    Given  Admin creates GET Request for the LMS API	for Users
    When Admin sends Get Request for all users with request Body with invalid endpoint
    Then Admin receives 404 Not Found Status for Get w for all users with message and boolean success details
    
    Scenario: Check if Admin able to retrieve all programs with invalid Method
    Given Admin creates GET Request for the LMS API	for Users
    When Admin sends post all users Request instead of get with endpoint	
    Then Admin receives 405 Method Not Allowed for get all users invalid method 
    
    Scenario: Check if Admin able to retrieve all programs without Authorization
    Given Admin creates GET Request for the LMS API	for Users
    When Admin sends HTTPS Request with endpoint without auth
    Then Admin receives 401 Status with response body as Unauthorized                                   
    
    #####UPDATE REQUEST
    Scenario: Check if Admin able to update a program with valid programID endpoint  and valid request body
    Given Admin creates PUT Request for the LMS API endpoint with request Body with mandatory , additional  fields. 	
    When Admin sends Put Request with valid endpoint
    Then Admin receives 200 OK Status with updated value in response body. 
    
    Scenario: Check if Admin able to update a program with invalid programID endpoint  and valid request body
    Given Admin creates PUT Request for the LMS API endpoint with request Body with mandatory , additional  fields.
    When Admin sends Put Request with invalid prgm Id and valid endpoint
    Then Admin receives 404 Not Found Status for update pgm invalid pgm id with message and boolean success details 
    
        
    Scenario: Check if Admin able to update a program without request body
    Given Admin creates PUT Request for the LMS API endpoint with request Body with mandatory , additional  fields.
    When Admin sends Put Request missing mandate field and valid endpoint
    Then Admin receives 400 Bad Request Status for put for missing mandate field with message and boolean success details 
    
    Scenario: Check if Admin able to update a program with invalid baseURI
    Given Admin creates PUT Request for the LMS API endpoint with request Body with mandatory , additional  fields with invalid baseurl
    When Admin sends Put Request with invalid baseurl valid endpoint	
    Then Admin receives 404 Not Found Status for put invalid baseurl with message and boolean success details
    
    Scenario: Check if Admin able to update a program with invalid method
    Given Admin creates PUT Request for the LMS API endpoint with request Body with mandatory , additional  fields.	
    When Admin sends get request instead of put Request with valid endpoint	
    Then Admin receives 405 Method Not Allowed for using get instead of put 
    
    Scenario: Check if Admin able to update a program without Authorization
    Given Admin creates PUT Request for the LMS API endpoint with request Body with mandatory , additional  fields.
    When Admin sends Put Request with endpoint without auth
    Then Admin receives 401 Status with response body as Unauthorized for put by pgm id 
    
    Scenario: Check if Admin able to update a program with  Valid program Name and request body
    Given Admin creates PUT Request with Program Name for the LMS API endpoint with valid request Body with mandatory , additional  fields. 	
    When Admin sends Put Request with Program name with valid endpoint	
    Then Admin receives 200 OK Status code with updated value in response body.  
    
    Scenario: Check if Admin able to update a program with  invalid program Name and request body
    Given Admin creates PUT Request with Program Name for the LMS API endpoint with valid request Body with mandatory , additional  fields.
    When Admin sends Put Request with invalid Program name with valid endpoint 
    Then Admin receives 404 Not Found Status for put with invalid pg namewith message and boolean success details
    
    Scenario: Check if Admin able to update a program using valid program name - missing mandatory fields in request body 
    Given Admin creates PUT Request for the LMS API with missing mandatory fields 
    When Admin sends Put Request with valid prgom name with valid endpoint
    Then Admin receives 400 Bad Request Status for missing field with message and boolean success details
    
    Scenario: Check if Admin able to upadte a program with program name starting with a number  
    Given Admin creates PUT Request with Program Name for the LMS API endpoint with valid request Body with mandatory , additional  fields.
    When Admin sends Put Request and Pgm Name starting with Number in request Body with endpoint	
    Then Admin receives 400 Bad Request Status for put Pgm name starting with number
    
    Scenario: Check if Admin able to update a program with invalid program Description
    Given Admin creates PUT Request with Program Name for the LMS API endpoint with valid request Body with mandatory , additional  fields.
    When Admin sends Put Request and Pgm Descrip starting with Number in request Body with endpoint	
    Then Admin receives 400 Bad Request Status for put Pgm descrip starting with number
    
    Scenario: Check if Admin able to update a program status
    Given Admin creates PUT Request with Program Name for the LMS API endpoint with valid request Body with mandatory , additional  fields.
    When Admin sends Put Request for status change with valid endpoint
    Then Admin receives 200 OK Status with updated prgm status value in response body. 
                                              
    ######DELETE REQUEST
    #Scenario: Check if Admin able to delete a program with valid programName
    #Given Admin creates DELETE Request for the LMS API endpoint  and  valid programName	
    #When Admin sends Delete by ProgramName Request with endpoint	
    #Then Admin receives 200 Ok status with message   
    #
    Scenario: Check if Admin able to delete a program with valid LMS API,invalid programName
    Given Admin creates DELETE Request for the LMS API endpoint  and invalid programName	
    When Admin sends Delete by invalid ProgramName Request with endpoint	
    Then Admin receives 404 Not Found Status for delete invalid pgnamewith message and boolean success details
    
    
    Scenario: Check if Admin able to delete a program by pgrm name without Authorization
    Given Admin creates DELETE Request for the LMS API endpoint  and  valid programName	
    When Admin sends delete Request by program name with endpoint without auth
    Then Admin receives 401 Status with response body as Unauthorized for delete by pgm name    
    
    #Scenario: Check if Admin able to delete a program with valid program ID
    #Given Admin creates DELETE Request for the LMS API endpoint  and  valid program ID	
    #When Admin sends Delete Request By Program Name with endpoint	
    #Then Admin receives 200 Ok status with message for delete by program name
     #
    Scenario: Check if Admin able to delete a program with valid LMS API,invalid programId
    Given Admin creates DELETE Request for the LMS API endpoint  and invalid programId	
    When Admin sends Delete by invalid ProgramID Request with endpoint	
    Then Admin receives 404 Not Found Status for delete invalid pgid with message and boolean success details    
    
    Scenario: Check if Admin able to delete a program without Authorization
    Given Admin creates DELETE Request for the LMS API endpoint  and  valid program ID	
    When Admin sends delete Request by program id with endpoint without auth
    Then Admin receives 401 Status with response body as Unauthorized for delete by pgm id                               
    
    
    
    
    
                                                                                                                                                                                                             
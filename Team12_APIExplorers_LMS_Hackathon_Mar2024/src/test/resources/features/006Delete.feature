Feature: Delete All modules

		###Delete Program Role batch map By Admin ID
    Scenario: Check if admin is able to delete the program batch for a Admin
    Given Admin creates DELETE Request to delete Admin assigned to program/batch by AdminId with Authorization to bearer token
    When Admin sends HTTPS Request to Delete program/batch by Admin Id
    Then Admin receives Status Code 200 OK after delete operation for Role Program Batch Map
    
   ####  delete batch by Id
  
  Scenario: Check if admin able to delete a Batch with valid Batch ID
    Given Admin creates DELETE Request with valid BatchId
    When Admin sends HTTPS Request to delete with endpoint
    Then Admin receives 200 Ok status with message to delete batch module

   #### get batch by id after deleting
   
    Scenario: Check if admin able to retrive a batch after deleting the batch 
    Given Admin creates GET Request with valid Batch ID
    When Admin sends HTTPS GET Request with valid id 
    Then Admin receives 200 OK Status with  batchStatus field "Inactive" in the response body.
    
		####DELETE Program Using Program Name
    Scenario: Check if Admin able to delete a program with valid programName
    Given Admin creates DELETE Request for the LMS API endpoint  and  valid programName	
    When Admin sends Delete by ProgramName Request with endpoint	
    Then Admin receives 200 Ok status with message   
   
   ####Delete Program using Program ID 
    Scenario: Check if Admin able to delete a program with valid program ID
    Given Admin creates DELETE Request for the LMS API endpoint  and  valid program ID	
    When Admin sends Delete Request By Program Name with endpoint	
    Then Admin receives 200 Ok status with message for delete by program name
     
Feature: User Role Program Batch Map 

  Scenario: Admin retreives all Admins with assigned program batches
    Given Admin creates GET Request to retrieve all Admins assigned to programs/batches with Authorization to bearer token
    When Admin sends HTTPS GET Request to retrieve all Admins assigned to programs/batches with Authorization to bearer token
    Then Admin receives statuscode 200 OK for Role Program Batch Map

  Scenario: Check if admin is able to retreive all Admins with assigned program batches with No Authorization
    Given Admin creates GET Request to retrieve all Admins assigned to programs/batches with authorization to No Auth 
    When Admin sends HTTPS Request without authorization
    Then Admin receives status 401 with Unauthorized message for Role Program Batch Map
  
  Scenario: Admin retreives assigned program batches for valid AdminId
    Given Admin creates GET Request to retrieve Admin assigned to Program/Batch by AdminId with Authorization to bearer token
    When Admin sends HTTPS Request to get program batches for valid AdminId
    Then Admin will receive 200 OK for Role Program Batch Map
    
  Scenario: Check if admin is able to retreive assigned program batches for invalid AdminId
    Given Admin creates GET Request to retrieve Admin assigned to Program/Batch by invalid AdminID with Authorization to bearer token
    When Admin sends HTTPS Request to get program batches for invalid AdminId
    Then Admin receives 404 with message for Role Program Batch Map
    
  Scenario: Check if admin is able to retreive assigned program batches for valid AdminId with No authorization
    Given Admin creates GET Request to retrieve Admin assigned to Program/Batch by valid AdminID with authorization to No Auth 
    When Admin sends HTTPS Request to get Program/Batch by valid Admin Id without authorization
    Then Admin will receive status 401 with Unauthorized message for Role Program Batch Map
    
  #Scenario: Check if admin is able to delete the program batch for a Admin
    #Given Admin creates DELETE Request to delete Admin assigned to program/batch by AdminId with Authorization to bearer token
    #When Admin sends HTTPS Request to Delete program/batch by Admin Id
    #Then Admin receives Status Code 200 OK after delete operation for Role Program Batch Map
  
   Scenario: Check if admin is able to delete the program batch for invalid Admin
    Given Admin creates DELETE Request to delete Admin assigned to program/batch by invalid AdminId with Authorization to bearer token
    When Admin sends HTTPS Request to delete program/batch by invalid Admin Id
    Then Admin will receive 404 with message for Role Program Batch Map
  
    Scenario: Check if admin is able to delete the program batch for valid Admin and No Authorization
    Given Admin creates DELETE Request to delete Admin assigned to program/batch by valid AdminId with authorization to No Auth
    When Admin sends HTTPS Request to delete program/batch by Admin id without Authorization
    Then Admin will receive status code 401 with Unauthorized message for Role Program Batch Map
  
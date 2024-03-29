Feature: Batch Module POST request

  #create batch
  @tag
  Scenario: Check if admin able to create a Batch with valid endpoint and request body (non existing values)
    Given Admin creates POST Request  with valid data in request body
    When Admin sends HTTPS Request with endpoint
    Then Admin receives 201 Created Status with response body

  #get all batches
  Scenario: Check if admin able to retrieve all batches  with valid LMS API
    Given Admin creates GET Request
    When Admin sends HTTPS Get Request with endpoint
    Then Admin receives 200 OK Status with response body

  #get batch by id
  Scenario: Check if admin able to retrieve a batch with valid BATCH ID
    Given Admin creates GET Request with valid Batch ID
    When Admin sends Get Request with endpoint
    Then Admin receives 200 OK Status with response in the response body

  #get batch by name
  @tag
  Scenario: Check if admin able to retrieve a batch with valid BATCH NAME
    Given Admin creates GET Request with valid Batch Name
    When Admin sends Get batch Request with endpoint
    Then Admin receives 200 Status code with response body

  #get batch by program id
 
  Scenario: Check if admin able to retrieve a batch with valid Program ID
    Given Admin creates GET Request with valid Program Id
    When Admin sends HTTPS Request to get batch by program Id with endpoint
    Then Admin receives status code 200 OK Status with response body

  #update batch by Id
  Scenario: Check if admin able to update a Batch with valid batchID and mandatory fields in request body
    Given Admin creates PUT Request with valid BatchId and Data
    When Admin sends HTTPS Request to update with endpoint
    Then Admin receives 200 OK Status with updated value in response body.

  #delete batch by Id
  Scenario: Check if admin able to delete a Batch with valid Batch ID
    Given Admin creates DELETE Request with valid BatchId
    When Admin sends HTTPS Request to delete with endpoint
    Then Admin receives 200 Ok status with message

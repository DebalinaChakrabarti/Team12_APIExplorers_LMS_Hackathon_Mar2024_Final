Feature: User Module
Background: Admin sets authorization to bearer token

@PostRequest
Scenario: Check if admin is able to create a new Admin with valid endpoint and request body with mandatory fields
Given Admin creates POST request with all mandatory fields for User Module
When Admin sends HTTPS Request with endpoint for User Module
Then Admin receives 201 Created Status with response body for User Module                                                          

@GetRequest(allroles)
Scenario: Check if admin is able to retreive all the available roles
Given Admin creates GET Request for User Module
When Admin sends HTTPS Request with GET All Roles endpoint for User Module
Then Admin receives 200 OK  for User Module

@GetRequest(All_Admins)
Scenario: Check if admin able to retrieve all Admin with valid endpoint
Given Admin creates GET Request for User Module
When Admin sends HTTPS Request with valid endpoint for User Module
Then Admin receives 200 OK Status with response body for User Module                                                                 

@GetRequest(by_AdminID)
Scenario: Check if admin able to retrieve a Admin with valid Admin ID
Given Admin creates GET Request with valid AdminId 
When Admin sends HTTPS Request with valid endpoint for User Module
Then Admin receives 200 OK Status with response body for User Module                                                                 

@GetRequest(All_active_admins)
Scenario: Check if admin able to retrieve all active Admins
Given Admin creates GET Request for active admins
When Admin sends HTTPS Request with Get ALL Active Users endpoint for User Module
Then Admin receives 200 OK with all Active Admins response body for User Module 

@GetRequest(Count_of_active_inactive_Admins)
Scenario: Check if admin is able to get count of active and inactive Admins
Given Admin creates GET Request for User Module 
When Admin sends HTTPS Request with endpoint for User Module
Then Admin  receices 200 OK With count of all active and inactive admins for User Module

#@GetRequest(Admins_by_program_batches)
#Scenario: Check if admin is able to get the Admins by program batches for valid batch ID
#Given Admin creates GET Request with valid batch Id for User Module
#When Admin sends HTTPS Request with endpoint to get Admins by program batch for valid batchId for User Module
#Then Admin receives 200 OK for admins by program batches for valid adminId for User Module

#@GetRequest(get_Admin_for_program)
#Scenario: Check if admin is able to get the Admins for valid program Id
#Given Admin creates GET Request to get admins with valid program Id for User Module
#When Admin sends HTTPS Request with endpoint to get the Admins for valid program Id for User Module
#Then Admin receives 200 OK to get the Admins for valid program Id for User Module

@GetRequest(get_Admin_by_RoleID)
Scenario: Check if admin is able to retreive Admins by valid role ID
Given Admin creates GET Request with valid role ID  to retreive Admins by valid role ID 
When Admin sends HTTPS Request with endpoint to retreive Admins by valid role ID
Then Admin receives 200 OK when retreived Admins by valid role ID for User Module

@GetRequest(Admin_With_Roles)
Scenario: Check if admin able to retrieve all Admins with roles
Given Admin creates GET Request to retrieve all Admins with roles
When Admin sends HTTPS Request with endpoint to retrieve all Admins with roles
Then Admin receives 200 OK Status with response body after retrieved all Admins with roles for User Module                                                                 

#@GetRequest(Admin_With_Filters)
#Scenario: Check if admin is able to retrieve all Admins with filters
#Given Admin creates GET Request to retrieve all Admins with filters
#When Admin sends HTTPS Request with endpoint to retrieve all Admins with filters
#Then Admin receives 200 OK after retrieved all Admins with filters for User Module

@PutRequest(Update_Admin_Role_Status_By_AdminID)
Scenario: Check if admin is able to update role status of a Admin with valid Admin id
Given Admin creates PUT Request with valid data in request body to update role status
When Admin sends HTTPS Request with endpoint to update role status
Then Admin receives 200 Ok Status with response message after update of role status for User Module                


@PutRequest(Update_Admin_RoleID)
Scenario: Check if admin is able to update role id of a Admin by valid Admin id
Given Admin creates PUT Request with valid request body for User Module
When Admin sends HTTPS Request with endpoint to update Admin roleId by valid AdminId
Then Admin receives 200 OK  Status with response body to update Admin roleId                                                           


@PutRequest(Update_Admin_Role_Program_Batch_Status)
Scenario: Check if admin is able to assign Admin to with program/batch by Admin Id
Given Admin creates PUT Request with valid data in request body to assign Admin with program/batch by Admin Id
When Admin sends HTTPS Request with endpoint to assign Admin with program/batch by Admin Id
Then Admin receives 200 Ok Status with response message to assign Admin to with program/batch by Admin Id

@GetRequest(get_Admin_for_program)
Scenario: Check if admin is able to get the Admins for valid program Id
Given Admin creates GET Request to get admins with valid program Id for User Module
When Admin sends HTTPS Request with endpoint to get the Admins for valid program Id for User Module
Then Admin receives 200 OK to get the Admins for valid program Id for User Module

@GetRequest(Admins_by_program_batches)
Scenario: Check if admin is able to get the Admins by program batches for valid batch ID
Given Admin creates GET Request with valid batch Id for User Module
When Admin sends HTTPS Request with endpoint to get Admins by program batch for valid batchId for User Module
Then Admin receives 200 OK for admins by program batches for valid adminId for User Module



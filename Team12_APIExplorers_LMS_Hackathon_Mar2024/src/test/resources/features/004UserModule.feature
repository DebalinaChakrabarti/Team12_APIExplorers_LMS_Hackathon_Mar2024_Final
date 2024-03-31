@userModule
Feature: Get request 
Background: User module 


@09userModuleRequest_getUserByProgram_pos_01
Scenario: User Module get User By Progam ID
Given User send request for the LMS API
When User Get request with valid program id
Then The user should receive a successful response with status code 200 for user module

@09userModuleRequest_getUserByProgram_neg_01
Scenario: User Module get User By Progam ID wih invalid program
Given User send request for the LMS API endPoint
When User Get request with invalid program id for 09userModuleRequest_getUserByProgram_neg_01
Then The user should receive a unsuccessful response with status code 404 for user module

@09userModuleRequest_getUserByProgram_neg_02
Scenario: User Module get User By Progam ID with valid program id without authorization
Given User send request for the LMS API endPoint
When User Get request with valid program id without authorization for 09userModuleRequest_getUserByProgram_neg_02
Then The user should receive a unsuccessful response with status code 401 and unauthorized message "Unauthorized"


@09userModuleRequest_getUserByProgram_neg_03
Scenario: User Module get User By Progam ID with invalid endpoint
Given User send request for the LMS API endPoint
Then User Get request with valid program id and invalid endpoint for 09userModuleRequest_getUserByProgram_neg_03
Then The user should receive a unsuccessful response with status code 404 and Not Found message "Not Found" Program ID


@10userModuleRequest_getUserByRoleID_pos_01
Scenario: User Module get User By Role ID
Given User send request for the LMS API
When User Get request with valid Role ID
Then The user should receive a successful response with status code 200 for user module

@10userModuleRequest_getUserByRoleID_neg_01
Scenario: User Module get User By Role ID with invalid Role ID
Given User send request for the LMS API endPoint
When User Get request with invalid Role ID for 10userModuleRequest_getUserByRoleID_neg_01
Then The user should receive a unsuccessful response with status code 404 for user module Role ID

@10userModuleRequest_getUserByRoleID_neg_02
Scenario: User Module get User By Role ID with valid Role ID without authorization
Given User send request for the LMS API endPoint
When User Get request with valid Role ID without authorization for 10userModuleRequest_getUserByRoleID_neg_02
Then The user should receive a unsuccessful response with status code 401 and unauthorized message "Unauthorized"


@10userModuleRequest_getUserByRoleID_neg_03
Scenario: User Module get User By Role ID with invalid endpoint
Given User send request for the LMS API endPoint
Then User Get request with valid Role ID and invalid endpoint for 10userModuleRequest_getUserByRoleID_neg_03
Then The user should receive a unsuccessful response with status code 404 and Not Found message "Not Found" Role ID

@11userModuleRequest_getUsers_pos_01
Scenario: User Module get Users
Given User send request for the LMS API
When User Get request with Users
Then The user should receive a successful response with status code 200 for user module

@11userModuleRequest_getUsers_neg_01
Scenario: User Module get Users without authorization
Given User send request for the LMS API endPoint
When User Get request with users without authorization for 11userModuleRequest_getUsers_neg_01
Then The user should receive a unsuccessful response with status code 401 and unauthorized message "Unauthorized"


@11userModuleRequest_getUsers_neg_02
Scenario: User Module get Users with invalid endpoint
Given User send request for the LMS API endPoint
Then User Get request with users and invalid endpoint for 11userModuleRequest_getUsers_neg_02
Then The user should receive a unsuccessful response with status code 404 and Not Found message "Not Found" users



@12userModuleRequest_getUsersFilters_pos_01
Scenario: User Module get Users with filters
Given User send request for the LMS API
When User Get request with Users with filters
Then The user should receive a successful response with status code 200 for user module

@12userModuleRequest_getUsersFilters_neg_01
Scenario: User Module get Users without authorization with filters
Given User send request for the LMS API endPoint
When User Get request with users with filters without authorization for 12userModuleRequest_getUsersFilters_neg_01
Then The user should receive a unsuccessful response with status code 401 and unauthorized message "Unauthorized"


@12userModuleRequest_getUsersFilters_neg_02
Scenario: User Module get Users with invalid endpoint with filters
Given User send request for the LMS API endPoint
Then User Get request with users with filters and invalid endpoint for 12userModuleRequest_getUsersFilters_neg_02
Then The user should receive a unsuccessful response with status code 404 and Not Found message "Not Found" users

@13userModuleRequest_putUser_pos_01
Scenario: User Module update Users
Given User send request for the LMS API
When User Update request with Users
Then The user should receive a successful response with status code 200 for user module


@13userModuleRequest_putUser_neg_01
Scenario: User Module update Users Invalid Request Body with Valid Admin ID
Given User send request for the LMS API
When User Update request with Users and Invalid Request body with valid Admin ID
Then The user should receive a unsuccessful response with status code 400

@13userModuleRequest_putUser_neg_02
Scenario: User Module update Users valid Request Body with Invalid Admin ID
Given User send request for the LMS API
When User Update request with Users and Valid Request body with Invalid Admin ID
Then The user should receive a unsuccessful response with status code 400

@13userModuleRequest_putUser_neg_03
Scenario: User Module update Users valid Request Body with existing Admin ID
Given User send request for the LMS API
When User Update request with Users and valid Request body with existing Admin ID
Then The user should receive a unsuccessful response with status code 400

@13userModuleRequest_putUser_neg_04
Scenario: User Module update Users Valid Request Body with Valid Admin ID without authorization
Given User send request for the LMS API
When User put request with users with filters without authorization for 13userModuleRequest_putUser_neg_04
Then The user should receive a unsuccessful response with status code 401 and unauthorized message "Unauthorized"

@13userModuleRequest_putUser_neg_05
Scenario: User Module update Users with authorization and invalid endpoint
Given User send request for the LMS API
Then User Put request with users with authorization and invalid endpoint for 13userModuleRequest_putUser_neg_05
Then The user should receive a unsuccessful response with status code 401 and Not Found message "Not Found" users


@14userModuleRequest_putUserRole_pos_01
Scenario: User Module update Users
Given User send request for the LMS API
When User Update request with Users Role
Then The user should receive a successful response with status code 200 for user module


@14userModuleRequest_putUserRole_neg_01
Scenario: User Module update Users Invalid Request Body with Valid Admin ID
Given User send request for the LMS API
When User Update request with valid Admin ID and Invalid Role status
Then The user should receive a unsuccessful response with status code 400

@14userModuleRequest_putUserRole_neg_02
Scenario: User Module update role status of a Admin with invalid Admin id
Given User send request for the LMS API
When User Update request with valid Request body and Invalid Admin ID
Then The user should receive a unsuccessful response with status code 400

@14userModuleRequest_putUserRole_neg_03
Scenario: User Module update role status of a Admin with non existing Role ID
Given User send request for the LMS API
When User Update request with valid Request body with non existing Role ID
Then The user should receive a unsuccessful response with status code 400 and Not Found message "Not Found" users

@14userModuleRequest_putUserRole_neg_04
Scenario: User Module update role status of a Admin without authorization
Given User send request for the LMS API
When User Update request with valid Request body without authorization for 14userModuleRequest_putUserRole_neg_04
Then The user should receive a unsuccessful response with status code 401 and unauthorized message "Unauthorized"


@14userModuleRequest_putUserRole_neg_05
Scenario: User Module update Users Valid Request Body with Valid Admin ID without authorization
Given User send request for the LMS API
Then User Put request with users with authorization and invalid endpoint for 14userModuleRequest_putUserRole_neg_05
Then The user should receive a unsuccessful response with status code 404 and Not Found message "Not Found" users


@15userModuleRequest_putUserRoleBatch_pos_01
Scenario: User Module update Users
Given User send request for the LMS API
When User Update request with Users Role Batch
Then The user should receive a successful response with status code 200 for user module


@15userModuleRequest_putUserRoleBatch_neg_01
Scenario: User Module update Users Invalid Request Body with Invalid Admin ID user role batch
Given User send request for the LMS API
When User Update request with Invalid Request body and valid Admin ID user role batch
Then The user should receive a unsuccessful response with status code 400 and Not Found message "Bad Request" Role Batch


@15userModuleRequest_putUserRoleBatch_neg_02
Scenario: User Module update Users valid Request Body with Invalid Admin ID
Given User send request for the LMS API
When User Update request with valid Request body and Invalid Admin ID user role batch
Then The user should receive a unsuccessful response with status code 404 and Not Found message "User not found with Id : U25123 " Role Batch


@15userModuleRequest_putUserRoleBatch_neg_03
Scenario: User Module update Users valid Request Body with valid Admin ID with No Authorization
Given User send request for the LMS API
When User Update request with valid Request body without authorization for 15userModuleRequest_putUserRoleBatch_neg_03
Then The user should receive a unsuccessful response with status code 401 and unauthorized message "Unauthorized"

@15userModuleRequest_putUserRoleBatch_neg_04
Scenario: User Module update Users Valid Request Body with Valid Admin ID invalid endpoint
Given User send request for the LMS API
Then User Put request with users with authorization and invalid endpoint for 15userModuleRequest_putUserRoleBatch_neg_04
Then The user should receive a unsuccessful response with status code 404 and Not Found message "Not Found" users

@16userModuleRequest_putUsersLogin_pos_01
Scenario: User Module update Users Login
Given User send request for the LMS API
When User Update request with Users Login
Then The user should receive a successful response with status code 200 for user module


@16userModuleRequest_putUsersLogin_neg_01
Scenario: User Module update Users Login Invalid Request Body with Invalid Admin ID users login
Given User send request for the LMS API
When User Update request with Invalid Request body and valid Admin ID Users Login
Then The user should receive a unsuccessful response with status code 400 and Not Found message "Bad Request" Role Batch


@16userModuleRequest_putUsersLogin_neg_02
Scenario: User Module update Users Login valid Request Body with Invalid Admin ID
Given User send request for the LMS API
When User Update request with valid Request body and Invalid Admin ID Users Login
Then The user should receive a unsuccessful response with status code 404 and Not Found message "User not found with Id : U25123 " Role Batch


@16userModuleRequest_putUsersLogin_neg_03
Scenario: User Module update Users Login valid Request Body with valid Admin ID with No Authorization
Given User send request for the LMS API
When User Update request with valid Request body without authorization for 16userModuleRequest_putUsersLogin_neg_03
Then The user should receive a unsuccessful response with status code 401 and unauthorized message "Unauthorized"

@16userModuleRequest_putUsersLogin_neg_04
Scenario: User Module update Users Login Valid Request Body with Valid Admin ID invalid endpoint
Given User send request for the LMS API
Then User Put request with users with authorization and invalid endpoint for 16userModuleRequest_putUsersLogin_neg_04
Then The user should receive a unsuccessful response with status code 404 and Not Found message "Not Found" users


@17userModuleRequest_deleteUser_pos_01
Scenario: User Module update Users
Given User send request for the LMS API
When User delete request the user
Then The user should receive a successful response with status code 200 for user module

@17userModuleRequest_deleteUserInvalid_neg_01
Scenario: User Module Delete User with Invalid User ID
Given User send request for the LMS API
When User delete request the user with invalid user id
Then The user should receive a unsuccessful response with 404 status code and message "UserID: 123456 does not exist"


@17userModuleRequest_deleteUserInvalid_neg_02
Scenario: User Module Delete Users valid Request Body with No Authorization
Given User send request for the LMS API
When User Update request with valid Request body without authorization for 15userModuleRequest_putUserRoleBatch_neg_03
Then The user should receive a unsuccessful response with status code 401 and unauthorized message "Unauthorized"

Feature: User Login Controller

@01PostRequest_UserSignIn
Scenario: Valid user Login
Given User send request for the LMS API endPoint
When User send post request with valid email id and password
Then The user should receive a successful response with status code 200



#@02PostRequest_UserSignIn
#Scenario: Invalid user Logout
#Given User send request for the LMS API endpoint
#When User send post request with invalid email id and password
#Then The user should receive a status code 400 
#And The response body should contain an error message Invalid request body


@userModule
Feature: Post request 
Background: Admin sets No Auth

@01PostRequest_UserSignIn
Scenario: Valid user Login
Given User send request for the LMS API endPoint
When User send post request with valid email id and password
Then The user should receive a successful response with status code 200

Scenario: Check if Admin able to generate token with invalid endpoint
Given Admin creates request with valid credentials
When Admin calls Post Https method  with invalid endpoint
Then Admin receives 401 unauthorized

#Scenario: Check if Admin able to generate token with invalid credentials
#Given Admin creates request with invalid credentials
#When Admin calls Post Https method  with valid endpoint
#Then Admin receives 400 Bad request




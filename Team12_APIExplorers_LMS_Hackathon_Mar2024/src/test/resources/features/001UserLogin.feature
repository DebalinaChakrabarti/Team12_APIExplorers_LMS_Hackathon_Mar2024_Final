Feature: Post request 
Background: Admin sets No Auth

@tag
Scenario: Valid user Login
Given User send request for the LMS API endPoint
When User send post request with valid email id and password
Then The user should receive a successful response with status code 200

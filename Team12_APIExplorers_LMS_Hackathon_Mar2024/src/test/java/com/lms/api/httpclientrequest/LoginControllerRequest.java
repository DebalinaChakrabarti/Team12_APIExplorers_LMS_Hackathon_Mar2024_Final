package com.lms.api.httpclientrequest;

import java.io.IOException;

import com.lms.api.endpoints.LoginControllerEndpoints;
import com.lms.api.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginControllerRequest extends RestUtils {
	
	
	private String token;
	String email="numpyninja@gmail.com";
	String password="lmsHackathon@2024";
	int responseCode=0;
	
	String requestBody="{ \"userLoginEmailId\": \"" + email + "\", \"password\": \"" + password + "\" }";
	
	public Response  generateToken()
	{
		 Response response=RestAssured.given()
				 .baseUri(baseURL.getString("baseUri"))
					.log().all()
					.contentType("application/json")
					.body(requestBody)
					.post(LoginControllerEndpoints.endpoint.LOGINPOST.getPath());
		  token = response.jsonPath().getString("token"); 
		  responseCode=response.getStatusCode();
		  return response; 
	}
	
	public void printtoken()
	{
		System.out.println(token);
	}
	public  int getResponseCode()
	{
		return responseCode;
	}
}

	
	
	
	



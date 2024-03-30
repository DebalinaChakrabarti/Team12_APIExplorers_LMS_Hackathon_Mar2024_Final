package com.lms.api.httpclientrequest;

import java.io.IOException;

import com.lms.api.Payload.P_01_UserLoginPayload;
import com.lms.api.endpoints.UserLoginEndpoints;
import com.lms.api.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserLoginRequest extends RestUtils {
	int responseCode=0;
	
	public  Response PostRequest(P_01_UserLoginPayload payload) throws IOException {

		response = RestAssured
				.given()
				 .baseUri(baseURL.getString("baseUri"))
				.contentType(ContentType.JSON)
				.auth().none()
				.body(payload)
				.log().all()
				.when()
				.post(UserLoginEndpoints.endpoint.LOGINPOST.getPath());
		token = response.jsonPath().getString("token"); 
		 responseCode=response.getStatusCode();
		return response;

	}
	
	public  int getResponseCode()
	{
		return responseCode;
	}
	
//	//private String token;
//	String email="numpyninja@gmail.com";
//	String password="lmsHackathon@2024";
//	int responseCode=0;
//	
//	String requestBody="{ \"userLoginEmailId\": \"" + email + "\", \"password\": \"" + password + "\" }";
//	
//	public Response  generateToken()
//	{
//		 Response response=RestAssured.given()
//				 .baseUri(baseURL.getString("baseUri"))
//					.log().all()
//					.contentType("application/json")
//					.body(requestBody)
//					.post(LoginControllerEndpoints.endpoint.LOGINPOST.getPath());
//		  token = response.jsonPath().getString("token"); 
//		  responseCode=response.getStatusCode();
//		  return response; 
//	}
//	
//	public void printtoken()
//	{
//		System.out.println(token);
//	}
	
}

	
	
	
	



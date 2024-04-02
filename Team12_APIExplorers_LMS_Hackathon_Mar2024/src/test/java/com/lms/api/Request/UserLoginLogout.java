package com.lms.api.Request;

import java.io.IOException;

import com.lms.api.Endpoints.UserLoginLogoutEndpoints;
import com.lms.api.Payload.P_01_UserLoginPayload;
import com.lms.api.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserLoginLogout extends RestUtils {

	

	public static Response PostRequest(P_01_UserLoginPayload payload) throws IOException {

		RequestSpecification request = RestAssured.given().body(payload);
		request.header("Content-Type", "application/json");
		
		request.then().log().all();
		
		response = request.when().post(UserLoginLogoutEndpoints.endpoint.LOGINPOST.getPath());
		
		response.then().log().all();
		

		return response;


	}
	
	public static Response PostInvalidEndpoint(P_01_UserLoginPayload payload) {
		
		RequestSpecification request = RestAssured.given().body(payload);
		request.header("Content-Type", "application/json");
		
		request.then().log().all();
		
		response = request.when().post(UserLoginLogoutEndpoints.endpoint.PostInvalid_LoginEndpoint.getPath());
		
		response.then().log().all();
		

		return response;

	}

	public static Response PostInvalidCredentials() {
		RequestSpecification request = RestAssured.given().auth().basic("useremail", "3sdrfs");
		request.header("Content-Type", "application/json");
		
		request.then().log().all();
		
		response = request.when().post(UserLoginLogoutEndpoints.endpoint.LOGINPOST.getPath());
		
		response.then().log().all();
		

		return response;


	}

	public static Response getLogout() {
		response = RestAssured.given().header("Authorization", "Bearer "+token)
				.log().all().when().get(UserLoginLogoutEndpoints.endpoint.GetLogout.getPath());
		return response;

	}

	public static Response getLogoutWithInvalidEndpoint() {
		response = RestAssured.given().header("Authorization", "Bearer " + token).log().all().when()
				.get(UserLoginLogoutEndpoints.endpoint.InvalidGetLogout.getPath());
		return response;

	}
	
	public static Response getLogoutWithNoAuth() {
		response=RestAssured.given().auth().none().log().all().when().get(UserLoginLogoutEndpoints.endpoint.GetLogout.getPath());
		return response;
		
	}

}

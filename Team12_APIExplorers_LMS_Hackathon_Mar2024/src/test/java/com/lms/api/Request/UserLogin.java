package com.lms.api.Request;

import java.io.IOException;

import com.lms.api.Endpoints.UserLoginEndpoints;
import com.lms.api.Payload.P_01_UserLoginPayload;
import com.lms.api.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserLogin extends RestUtils {

	public static Response PostRequest(P_01_UserLoginPayload payload) throws IOException {

		response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.auth().none()
				.body(payload)
				.log().all()
				.when()
				.post(UserLoginEndpoints.endpoint.LOGINPOST.getPath());
		
		token = response.getBody().jsonPath().get("token");
		

		return response;

	}

	public static Response PostInvalidEndpoint(P_01_UserLoginPayload payload) {
		response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.auth().none()
				.body(payload)
				.log().all().when()
				.post(UserLoginEndpoints.endpoint.PostInvalid_LoginEndpoint.getPath());

		return response;

	}

}

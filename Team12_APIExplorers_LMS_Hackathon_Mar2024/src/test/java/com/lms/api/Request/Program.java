package com.lms.api.Request;


import java.io.IOException;
//import com.jayway.jsonpath.JsonPath;
import com.lms.api.Endpoints.ProgramEndpoints;
import com.lms.api.Payload.P_02_ProgramPayload;
import com.lms.api.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

	public class Program extends RestUtils {
		
		int Respcode =0; 

		public static Response PostRequest(P_02_ProgramPayload payload) throws IOException {
			System.out.println("This is token from utils "+token);
			response = RestAssured
					.given()
					.contentType(ContentType.JSON)
					.header("Authorization","Bearer " +token)
					.body(payload)
					.log().all()
					.when()
					.post(ProgramEndpoints.endpoint.PROGRAMPOST.getPath());

	
			programId = response.jsonPath().getInt("programId");
			programName= response.jsonPath().getString("programName");
			System.out.println("programId: "+programId );
			System.out.println("programName: "+programName);

			return response;

		}
	

		public static Response ProgrmInvalidEndpoint(P_02_ProgramPayload payload) throws IOException {
			response = RestAssured
			.given()
			.contentType(ContentType.JSON)
			.header("Authorization","Bearer" +token)
			.body(payload)
			.log().all()
			.when()
			.post(ProgramEndpoints.endpoint.INVALIDPROGRAMPOST.getPath())
			.then()
			.assertThat()
			.statusCode(404)
			.extract()
			.response();
			
			return response;
		}

	}
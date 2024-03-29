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
		
		 int RStatuscode=0; 

		public Response PostRequest(P_02_ProgramPayload payload) throws IOException {
			System.out.println("This is token from utils "+token);
			Response response = RestAssured
					.given()
					.contentType(ContentType.JSON)
					.header("Authorization","Bearer " +token)
					.body(payload)
					.log().all()
					.when()
					.post(ProgramEndpoints.endpoint.PROGRAMPOST.getPath());

	
			programId = response.jsonPath().getInt("programId");
			programName= response.jsonPath().getString("programName");
			
			RStatuscode= response.getStatusCode();
		
			return response;

		}
		
		public  int getCreatepgResponseCode()
		{
			return RStatuscode;
		}


		public Response ProgrmInvalidEndpoint(P_02_ProgramPayload payload) throws IOException {
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
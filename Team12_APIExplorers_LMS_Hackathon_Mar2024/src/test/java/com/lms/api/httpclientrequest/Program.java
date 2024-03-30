package com.lms.api.httpclientrequest;

import java.io.IOException;

import com.lms.api.Payload.P_02_ProgramPayload;
import com.lms.api.endpoints.ProgramEndpoints;
import com.lms.api.utilities.RestUtils;

import io.restassured.RestAssured;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Program extends RestUtils{
	 int  RStatuscode =0; 

	public  Response PostRequest(P_02_ProgramPayload payload) throws IOException {
		System.out.println("This is token from utils "+token);
		
	Response	response = RestAssured.given()
			.baseUri(baseURL.getString("baseUri"))
			.header("Authorization", "Bearer " + token)
			.log().all()
			.contentType("application/json")
			.body(payload)
			.when()
			.post(ProgramEndpoints.endpoint.PROGRAMPOST.getPath())
			.then()
			.log().all().extract().response();
  programId=response.jsonPath().getInt("programId");
  payload.setProgramId(programId);
    //System.out.println(programId);
	//ProgramPayload.setProgramId(response.jsonPath().getInt("programId"));
	programName=response.jsonPath().getString("programName");
	 payload.setProgramName(programName);
	RStatuscode=response.getStatusCode();
	return response;

	}
	public  int getCreatepgResponseCode()
	{
		return RStatuscode;
	}
}

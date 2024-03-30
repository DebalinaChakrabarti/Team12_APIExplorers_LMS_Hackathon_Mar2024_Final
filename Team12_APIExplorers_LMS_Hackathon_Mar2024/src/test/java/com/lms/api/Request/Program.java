package com.lms.api.Request;

import static io.restassured.RestAssured.baseURI;
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
					.post(ProgramEndpoints.endpoint.PROGRAMPOST.getPath())
					.then()
					.log().all().extract().response();

	
			programId = response.jsonPath().getInt("programId");
			programName= response.jsonPath().getString("programName");
			System.out.println("programId " +programId);
			RStatuscode= response.getStatusCode();
		
			return response;

		}
		
		public  int getCreatepgResponseCode()
		{
			return RStatuscode;
		}


		public Response getAllPrograms()
		{
			Response response=RestAssured
					.given()
					.contentType(ContentType.JSON)
					.header("Authorization", "Bearer " + token)
					.log().all()
					.when()
					.get(ProgramEndpoints.endpoint.GETALLPRMS.getPath());
					
			RStatuscode =response.getStatusCode();
			return response;
		}

		public  int getAllprgmResponseCode()
		{
			return RStatuscode;
		}
		
		
		public Response getPrgmbyProgramId()
		{
			Response response=RestAssured
					.given()
					.contentType(ContentType.JSON)
					.header("Authorization", "Bearer " + token)
					.log().all()
					.when()
					.get(ProgramEndpoints.endpoint.GETPGBYPROGRAMID.getPath()+programId );
			RStatuscode=response.getStatusCode();
			return response;
		}

		public  int getPgrmByIdResponseCode()
		{
			return RStatuscode;
		}
		
		public Response getAllProgramswithUsers()
		{
			Response response=RestAssured
					.given()
					.contentType(ContentType.JSON)
					.header("Authorization", "Bearer " + token)
					.log().all()
					.when()
					.get(ProgramEndpoints.endpoint.GETALLPGWITHUSERS.getPath());
					
			RStatuscode =response.getStatusCode();
			return response;
		}

		public  int getAllprgmwithusersResponseCode()
		{
			return RStatuscode;
		}
		
		//update program by id 
		public Response updateProgramByID(P_02_ProgramPayload updatepayload) throws IOException
		{
			Response response=RestAssured
					.given()
					.header("Authorization", "Bearer " + token)
					.log().all()
					.contentType("application/json")
					.body(updatepayload)
					.when()
					.put(ProgramEndpoints.endpoint.UPDATEBYPGRMID.getPath()+programId)
					.then()
					.log().all().extract().response();
			
			programId = response.jsonPath().getInt("programId");
			programName= response.jsonPath().getString("programName");
			System.out.println("programId " +programId);
			RStatuscode= response.getStatusCode();
			return response; 
		}

		public int UpdatePrgrmResponseCode()
		{
			return RStatuscode;
		}

		
		//update program by id 
				public Response updateProgramByName(P_02_ProgramPayload updatenamepayload) throws IOException
				{
					Response response=RestAssured
							.given()
							.header("Authorization", "Bearer " + token)
							.log().all()
							.contentType("application/json")
							.body(updatenamepayload)
							.when()
							.put(ProgramEndpoints.endpoint.UPDATEBYPGRMNAME.getPath()+programName)
							.then()
							.log().all().extract().response();
					
					programId = response.jsonPath().getInt("programId");
					programName= response.jsonPath().getString("programName");
					System.out.println("programId " +programId);
					RStatuscode= response.getStatusCode();
					return response; 
				}

				public int UpdatePrgrmnameResponseCode()
				{
					return RStatuscode;
				}

				public Response deleteProgramById()
				{
					Response response=RestAssured
							.given()
							.header("Authorization", "Bearer " + token)
							.log().all()
							.when()
							.delete(ProgramEndpoints.endpoint.DELETEBYPRGMID.getPath()+programId);
					RStatuscode=response.getStatusCode();
					return response;
				}

				public int deletePgmresponseCode()
				{
					return RStatuscode;
				}
				
				public Response deleteProgramByName()
				{
					Response response=RestAssured
							.given()
							.header("Authorization", "Bearer " + token)
							.log().all()
							.when()
							.delete(ProgramEndpoints.endpoint.DELETEBYPRGMNAME.getPath()+programName);
					RStatuscode=response.getStatusCode();
					return response;
				}

				public int deletePgmNameresponseCode()
				{
					return RStatuscode;
				}
				
				
				
				
//		public Response ProgrmInvalidEndpoint(P_02_ProgramPayload payload) throws IOException {
//			response = RestAssured
//			.given()
//			.contentType(ContentType.JSON)
//			.header("Authorization","Bearer" +token)
//			.body(payload)
//			.log().all()
//			.when()
//			.post(ProgramEndpoints.endpoint.INVALIDPROGRAMPOST.getPath())
//			.then()
//			.assertThat()
//			.statusCode(404)
//			.extract()
//			.response();
//			
//			return response;
//		}

		
	}
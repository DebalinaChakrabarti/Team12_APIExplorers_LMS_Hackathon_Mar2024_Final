package com.lms.api.Request;

import static io.restassured.RestAssured.baseURI;
import java.io.IOException;

import org.testng.Assert;

//import com.jayway.jsonpath.JsonPath;
import com.lms.api.Endpoints.ProgramEndpoints;
import com.lms.api.Payload.P_02_ProgramPayload;
import com.lms.api.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

	public class Program extends RestUtils {
		
		int RStatuscode=0; 
		String Rmessage ="";
		
		
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
					.log().all()
					.body(JsonSchemaValidator.matchesJsonSchema(programPostjson)) //Schema Validation
					.extract().response();

	
			programId = response.jsonPath().getInt("programId");
			programName= response.jsonPath().getString("programName");
			System.out.println("programId " +programId);
			
			//Data Validation
		    Assert.assertEquals(payload.getProgramDescription(), response.jsonPath().getString("programDescription"));
		    Assert.assertEquals(payload.getProgramName(), response.jsonPath().getString("programName"));
		    Assert.assertEquals(payload.getProgramStatus(), response.jsonPath().getString("programStatus"));
			
		    RStatuscode= response.getStatusCode();
		   
		
			return response;

		}
		
		public int getCreatepgResponseCode()
		{
			return RStatuscode;
		}
		
		//Post without auth 
		
		public Response PostwithoutAuthRequest(P_02_ProgramPayload payload) throws IOException {
			System.out.println("This is token from utils "+token);
			Response response = RestAssured
					.given()
					.contentType(ContentType.JSON)
					//.header("Authorization","Bearer " +token) //without Auth
					.body(payload)
					.log().all()
					.when()
					.post(ProgramEndpoints.endpoint.PROGRAMPOST.getPath())
					.then()
					.log().all()
					.extract().response();

			
		    RStatuscode= response.getStatusCode();
		    Rmessage= response.getBody().jsonPath().get("error");
		
			return response;

		}
		
		public int getCreatewoauthResponseCode()
		{
			return RStatuscode;
			
		}
		public String getCreatewoauthResponsemess()
		{
			 return Rmessage;
		}
		
		//Invalid endpoint
		public Response PostInvalidEPRequest(P_02_ProgramPayload payload) throws IOException {
			System.out.println("This is token from utils "+token);
			Response response = RestAssured
					.given()
					.contentType(ContentType.JSON)
					.header("Authorization","Bearer " +token)
					.body(payload)
					.log().all()
					.when()
					.post(ProgramEndpoints.endpoint.INVALIDPROGRAMPOST.getPath())
					.then()
					.log().all().extract().response();

	
			RStatuscode= response.getStatusCode();
		
			return response;

		}
		
		public  int getpgInvalidEPResponseCode()
		{
			return RStatuscode;
		}

		//Post using existing Pgm Name
		public Response PostRequestExsistingPName(P_02_ProgramPayload payload) throws IOException {
			
			Response response = RestAssured
					.given()
					.contentType(ContentType.JSON)
					.header("Authorization","Bearer " +token)
					.body(payload)
					.log().all()
					.when()
					.post(ProgramEndpoints.endpoint.PROGRAMPOST.getPath())
					.then()
					.log().all()
					.extract().response();

			RStatuscode= response.getStatusCode();
		
			return response;

		}
		
		public  int getExistPNameResponseCode()
		{
			return RStatuscode;
		}
		
		//Post by missing pgm name in body
		public Response postmissingpgname(P_02_ProgramPayload payload) throws IOException {
			
			Response response = RestAssured
					.given()
					.contentType(ContentType.JSON)
					.header("Authorization","Bearer " +token)
					.body(payload)
					.log().all()
					.when()
					.post(ProgramEndpoints.endpoint.PROGRAMPOST.getPath());

			RStatuscode= response.getStatusCode();
		
			return response;

		}
		
		public  int getMissingPNameResponseCode()
		{
			return RStatuscode;
		}
		
		//Post using incorrect method
		public Response postPGIncorrectMethod(P_02_ProgramPayload payload) throws IOException {
			
			Response response = RestAssured
					.given()
					.contentType(ContentType.JSON)
					.header("Authorization","Bearer " +token)
					.body(payload)
					.log().all()
					.when()
					.get(ProgramEndpoints.endpoint.PROGRAMPOST.getPath());

			RStatuscode= response.getStatusCode();
		
			return response;

		}
		
		public  int getPGIncorrectMethodResponseCode()
		{
			return RStatuscode;
		}
		
		//Post PGname starting numeric
		
		public Response postPGnamenum(P_02_ProgramPayload payload) throws IOException {
			
			Response response = RestAssured
					.given()
					.contentType(ContentType.JSON)
					.header("Authorization","Bearer " +token)
					.body(payload)
					.log().all()
					.when()
					.post(ProgramEndpoints.endpoint.PROGRAMPOST.getPath())
					.then()
					.log().all()
					.extract().response();

			RStatuscode= response.getStatusCode();
		
			return response;

		}
		
		public  int getPGNameNumResponseCode()
		{
			return RStatuscode;
		}
		
		//Post missing additional fields request body
		
		public Response postmissingaddReqbody(P_02_ProgramPayload invalidbodypayload) throws IOException {
			
			Response response = RestAssured
					.given()
					.contentType(ContentType.JSON)
					.header("Authorization","Bearer " +token)
					.body(invalidbodypayload)
					.log().all()
					.when()
					.post(ProgramEndpoints.endpoint.PROGRAMPOST.getPath())
					.then()
					.log().all()
					.extract().response();

			RStatuscode= response.getStatusCode();
		
			return response;

		}
		
		public  int getMissaddReqbodyResponseCode()
		{
			return RStatuscode;
		}
		
		//Get All Programs
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
		
		//Get all prgms without auth 
		
		public Response getAllProgramswOAuth()
		{
			Response response=RestAssured
					.given()
					.contentType(ContentType.JSON)
				//	.header("Authorization", "Bearer " + token)
					.log().all()
					.when()
					.get(ProgramEndpoints.endpoint.GETALLPRMS.getPath());
					
			RStatuscode =response.getStatusCode();
			return response;
		}

		public  int getAllprgmwoauthResponseCode()
		{
			return RStatuscode;
		}
		
			
		//Get All programs with invalid Endpoint
		public Response getAllInvalidEPPrograms()
		{
			Response response=RestAssured
					.given()
					.contentType(ContentType.JSON)
					.header("Authorization", "Bearer " + token)
					.log().all()
					.when()
					.get(ProgramEndpoints.endpoint.INVALIDGET.getPath())
					.then()
					.log().all()
					.extract().response();
					
			RStatuscode =response.getStatusCode();
			return response;
		}

		public  int getAllprgmInvalidEPResponseCode()
		{
			return RStatuscode;
		}
		
		//Get All programs with invalid method
		
		public Response getAllInvalidMetPrograms()
		{
			Response response=RestAssured
					.given()
					.contentType(ContentType.JSON)
					.header("Authorization", "Bearer " + token)
					.log().all()
					.when()
					.post(ProgramEndpoints.endpoint.GETALLPRMS.getPath())
					.then()
					.log().all()
					.extract().response();
					
			RStatuscode =response.getStatusCode();
			return response;
		}

		public  int getAllprgmInvalidMeResponseCode()
		{
			return RStatuscode;
		}
		
		//Get program by id
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
		
		//Get Program by id without authorization
		public Response getPrgmbyProgramIdWoAuth()
		{
			Response response=RestAssured
					.given()
					.contentType(ContentType.JSON)
					//.header("Authorization", "Bearer " + token)
					.log().all()
					.when()
					.get(ProgramEndpoints.endpoint.GETPGBYPROGRAMID.getPath()+programId );
			RStatuscode=response.getStatusCode();
			return response;
		}

		public  int getPgrmByIdwoauthResponseCode()
		{
			return RStatuscode;
		}
		
		//Get Program with invalid program id
		public Response getPrgmbyInvalidProgramId()
		{
			Response response=RestAssured
					.given()
					.contentType(ContentType.JSON)
					.header("Authorization", "Bearer " + token)
					.log().all()
					.when()
					.get(ProgramEndpoints.endpoint.GETPGBYPROGRAMID.getPath()+InvalidprogramId )
					.then()
					.log().all()
					.extract().response();
			RStatuscode=response.getStatusCode();
			return response;
		}

		public  int getPgrmByInvalidIdResponseCode()
		{
			return RStatuscode;
		}
		
		//Get Program with invalid Baseurl
		public Response getPgrmbyinvalidbaseurl()
		{
			Response response=RestAssured
					.given()
					.contentType(ContentType.JSON)
					.header("Authorization", "Bearer " + token)
					.log().all()
					.when()
					.get(ProgramEndpoints.endpoint.GETPGBYPROGRAMID.getPath()+programId )
					.then()
					.log().all()
					.extract().response();
			RStatuscode=response.getStatusCode();
			return response;
		}

		public  int getPgrmByInvalidBaseResponseCode()
		{
			return RStatuscode;
		}
		
		//Get with pgm Id with invalid Endpoint
		
		public Response getpgmIdinvalidEP()
		{
			Response response=RestAssured
					.given()
					.contentType(ContentType.JSON)
					.header("Authorization", "Bearer " + token)
					.log().all()
					.when()
					.get(ProgramEndpoints.endpoint.GETBYPGMIDINVALIDEP.getPath()+programId )
					.then()
					.log().all()
					.extract().response();
			RStatuscode=response.getStatusCode();
			return response;
		}

		public  int getPgrmByInvalidEPResponseCode()
		{
			return RStatuscode;
		}
		
		//Get All programs with Users
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
		
		//Get all prgms with users with invalid EP 
		public Response getAllPgmUsersInavlidEP()
		{
			Response response=RestAssured
					.given()
					.contentType(ContentType.JSON)
					.header("Authorization", "Bearer " + token)
					.log().all()
					.when()
					.get(ProgramEndpoints.endpoint.GETALLPGUSERSINVALIDEP.getPath())
					.then()
					.log().all()
					.extract().response();
					
			RStatuscode =response.getStatusCode();
			return response;
		}

		public  int getAllprgmuserInvalidEPIResponseCode()
		{
			return RStatuscode;
		}
		
		//Get all prgm users with invalid method 
		public Response getAllPgmUsersInavlidMethod()
		{
			Response response=RestAssured
					.given()
					.contentType(ContentType.JSON)
					.header("Authorization", "Bearer " + token)
					.log().all()
					.when()
					.post(ProgramEndpoints.endpoint.GETALLPGWITHUSERS.getPath())
					.then()
					.log().all()
					.extract().response();
							
			RStatuscode =response.getStatusCode();
			return response;
		}

		public  int getAllprgmuserInvalidMetResponseCode()
		{
			return RStatuscode;
		}
		
		//Get all prgm users without auth
		
		public Response getAllProgramswithUserswoauth()
		{
			Response response=RestAssured
					.given()
					.contentType(ContentType.JSON)
					//.header("Authorization", "Bearer " + token)
					.log().all()
					.when()
					.get(ProgramEndpoints.endpoint.GETALLPGWITHUSERS.getPath());
					
			RStatuscode =response.getStatusCode();
			Rmessage= response.getBody().jsonPath().get("error");
			return response;
		}

		public  int getAllprgmwithuserswoauthResponseCode()
		{
			return RStatuscode;
		}
		
		public String getAllprgmwithuserswoauthResponsemess()
		{
			return Rmessage;
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
					.log().all()
					.body(JsonSchemaValidator.matchesJsonSchema(programPostjson))
					.extract().response();
			
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

		//Update using invalid pgm id 
		public Response updateProgramInvalidPgmID(P_02_ProgramPayload updatepayload) throws IOException
		{
			Response response=RestAssured
					.given()
					.header("Authorization", "Bearer " + token)
					.log().all()
					.contentType("application/json")
					.body(updatepayload)
					.when()
					.put(ProgramEndpoints.endpoint.UPDATEBYPGRMID.getPath()+InvalidprogramId)
					.then()
					.log().all()
					.extract().response();

			RStatuscode= response.getStatusCode();
			return response; 
		}

		public int UpdatePrgrmInvalidIDResponseCode()
		{
			return RStatuscode;
		}
		
		//Update using invalid request body
		public Response putinvalidReqbody(P_02_ProgramPayload updatepayload) throws IOException
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
					.log().all()
					.extract().response();

			RStatuscode= response.getStatusCode();
			return response; 
		}

		public int UpdateinvalidbodyResponseCode()
		{
			return RStatuscode;
		}
		
		//update pgm with missing field request body 
		public Response updatepgmwithoutbody(P_02_ProgramPayload updatemissingfieldpayload) throws IOException
		{
			Response response=RestAssured
					.given()
					.header("Authorization", "Bearer " + token)
					.log().all()
					.contentType("application/json")
					.body(updatemissingfieldpayload)
					.when()
					.put(ProgramEndpoints.endpoint.UPDATEBYPGRMID.getPath()+programId)
					.then()
					.log().all()
					.extract().response();

			RStatuscode= response.getStatusCode();
			return response; 
		}

		public int UpdatePrgrmWobodyResponseCode()
		{
			return RStatuscode;
		}
		
		//Upadte pgmwith pgm id with invalid baseurl
		public Response updateProgramByIDinvalidbase(P_02_ProgramPayload updatepayload) throws IOException
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
					.log().all()
					.extract().response();
			
		
			RStatuscode= response.getStatusCode();
			return response; 
		}

		public int UpdatePrgrminvalidbaseResponseCode()
		{
			return RStatuscode;
		}
		
		//Update using invalid method 
		public Response updatepgminvalidmethod(P_02_ProgramPayload updatepayload) throws IOException
		{
			Response response=RestAssured
					.given()
					.header("Authorization", "Bearer " + token)
					.log().all()
					.contentType("application/json")
					.body(updatepayload)
					.when()
					.get(ProgramEndpoints.endpoint.UPDATEBYPGRMID.getPath()+programId)
					.then()
					.log().all()
					.extract().response();
			
		
			RStatuscode= response.getStatusCode();
			return response; 
		}
		public int UpdatePrgrminvalidmetResponseCode()
		{
			return RStatuscode;
		}
		
		//Update by Pgm id without auth
		
		public Response updateprgnwithoutauth(P_02_ProgramPayload updatepayload) throws IOException
		{
			Response response=RestAssured
					.given()
					//.header("Authorization", "Bearer " + token)
					.log().all()
					.contentType("application/json")
					.body(updatepayload)
					.when()
					.put(ProgramEndpoints.endpoint.UPDATEBYPGRMID.getPath()+programId)
					.then()
					.log().all()
					.extract().response();
			
			RStatuscode= response.getStatusCode();
			Rmessage=response.getBody().jsonPath().get("error");
			return response; 
		}

		public int UpdatepgrmidwoauthResponseCode()
		{
			return RStatuscode;
		}
		public String UpdatepgrmidwoauthResponsemess()
		{
			return Rmessage;
		}
		
		//update program by name 
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
							.log().all()
							.body(JsonSchemaValidator.matchesJsonSchema(programPostjson))
							.extract().response();
					
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

		//Update using invalid pgname
				public Response updateinvalidprgmname(P_02_ProgramPayload updatenamepayload) throws IOException
				{
					Response response=RestAssured
							.given()
							.header("Authorization", "Bearer " + token)
							.log().all()
							.contentType("application/json")
							.body(updatenamepayload)
							.when()
							.put(ProgramEndpoints.endpoint.UPDATEBYPGRMNAME.getPath()+InvalidprogramName)
							.then()
							.log().all()
							.extract().response();
					
					RStatuscode= response.getStatusCode();
					return response; 
				}

				public int UpdateinvalidPrgrmnameResponseCode()
				{
					return RStatuscode;
				}	
		
		//Update using prgm name missing fields
				
				public Response updatemissingfieldprgmname(P_02_ProgramPayload updatemissingfieldpayload) throws IOException
				{
					Response response=RestAssured
							.given()
							.header("Authorization", "Bearer " + token)
							.log().all()
							.contentType("application/json")
							.body(updatemissingfieldpayload)
							.when()
							.put(ProgramEndpoints.endpoint.UPDATEBYPGRMNAME.getPath()+InvalidprogramName)
							.then()
							.log().all()
							.extract().response();
					
					RStatuscode= response.getStatusCode();
					return response; 
				}

				public int UpdatemissfieldpgnameResponseCode()
				{
					return RStatuscode;
				}
				
		//Update prgm name as num
				public Response upadtePGnamenum(P_02_ProgramPayload updatenamepayload) throws IOException
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
							.log().all()
							.extract().response();
					
					
					RStatuscode= response.getStatusCode();
					return response; 
				}

				public int UpdatenumpgnameResponseCode()
				{
					return RStatuscode;
				}
		
		//Update prgm with description starting with num 
				public Response updatePgdesnum(P_02_ProgramPayload updatenamepayload) throws IOException
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
							.log().all()
							.extract().response();
					
					
					RStatuscode= response.getStatusCode();
					return response; 
				}

				public int UpdatenumpgdesResponseCode()
				{
					return RStatuscode;
				}
				
		//Update prgm status 
				public Response updateprgmstatus(P_02_ProgramPayload updatenamepayload) throws IOException
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
							.log().all()
							.body(JsonSchemaValidator.matchesJsonSchema(programPostjson))
							.extract().response();
					
					RStatuscode= response.getStatusCode();
					return response; 
				}

				public int UpdatestatusResponseCode()
				{
					return RStatuscode;
				}	
				
		//delete using pgrm name
				public Response deleteProgramByName()
				{
					Response response=RestAssured
							.given()
							.header("Authorization", "Bearer " + token)
							.log().all()
							.when()
							.delete(ProgramEndpoints.endpoint.DELETEBYPRGMNAME.getPath()+programName)
							.then()
							.log().all()
							.extract().response();
					RStatuscode=response.getStatusCode();
					return response;
				}

				public int deletePgmNameresponseCode()
				{
					return RStatuscode;
				}
				
		// delete using invalid pgm name
				public Response deletePgrminvalidname()
				{
					Response response=RestAssured
							.given()
							.header("Authorization", "Bearer " + token)
							.log().all()
							.when()
							.delete(ProgramEndpoints.endpoint.DELETEBYPRGMNAME.getPath()+InvalidprogramName)
							.then()
							.log().all()
							.extract().response();
					RStatuscode=response.getStatusCode();
					return response;
				}

				public int deletePgmInvalidNameresponseCode()
				{
					return RStatuscode;
				}
			
			//delete by prgm name without auth
				public Response deleteProgramByNamewoAuth()
				{
					Response response=RestAssured
							.given()
							//.header("Authorization", "Bearer " + token)
							.log().all()
							.when()
							.delete(ProgramEndpoints.endpoint.DELETEBYPRGMNAME.getPath()+programName)
							.then()
							.log().all()
							.extract().response();
					RStatuscode=response.getStatusCode();
					Rmessage=response.getBody().jsonPath().get("error");
					return response;
				}

				public int DelpgrmnamewoauthResponseCode()
				{
					return RStatuscode;
				}
				public String DelpgrmnamewoauthResponseMess()
				{
					return Rmessage;
				}
				
				//Delete using prgm id
				public Response deleteProgramById()
				{
					Response response=RestAssured
							.given()
							.header("Authorization", "Bearer " + token)
							.log().all()
							.when()
							.delete(ProgramEndpoints.endpoint.DELETEBYPRGMID.getPath()+programId)
							.then()
							.log().all()
							.extract().response();
					RStatuscode=response.getStatusCode();
					return response;
				}

				public int deletePgmresponseCode()
				{
					return RStatuscode;
				}
		//Delete using invalid prgm id 
				public Response deleteProgramByinvalidId()
				{
					Response response=RestAssured
							.given()
							.header("Authorization", "Bearer " + token)
							.log().all()
							.when()
							.delete(ProgramEndpoints.endpoint.DELETEBYPRGMID.getPath()+InvalidprogramId)
							.then()
							.log().all()
							.extract().response();
					RStatuscode=response.getStatusCode();
					return response;
				}

				public int deletePgminvalidIdresponseCode()
				{
					return RStatuscode;
				}	
				
		//Delete by prgm id without auth
				public Response deleteProgramByIDwoAuth()
				{
					Response response=RestAssured
							.given()
						//	.header("Authorization", "Bearer " + token)
							.log().all()
							.when()
							.delete(ProgramEndpoints.endpoint.DELETEBYPRGMID.getPath()+programId)
							.then()
							.log().all()
							.extract().response();
					RStatuscode=response.getStatusCode();
					Rmessage=response.getBody().jsonPath().get("error");
					return response;
				}

				public int DelpgrmidwoauthResponseCode()
				{
					return RStatuscode;
				}
				public String DelpgrmidwoauthResponsemess()
				{
					return Rmessage;
				}
		
	}
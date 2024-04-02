package com.lms.api.Request;
import java.io.IOException;

import com.lms.api.Endpoints.BatchEndpoints;
import com.lms.api.Payload.P_02_BatchPayload;

import com.lms.api.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BatchRequest extends RestUtils{

	int responseCode=0;
	String statusline;
	public Response createNewBatch(P_02_BatchPayload payLoad) 
	{
try {
		Response response=RestAssured.given()
				//.baseUri(rb_routes.getString("baseUrl"))
				.header("Authorization", "Bearer " + token)
				.log().all()
				.contentType("application/json")
				.body(payLoad)
				.when() 
				.post(BatchEndpoints.endpoint.CREATEBATCH.getPath())
				.then()
				.log().all().extract().response();
		responseCode=response.getStatusCode();
		if(responseCode==201)
		{
				batchId=response.jsonPath().getInt("batchId"); 
				payLoad.setBatchId(batchId);
				batchName=response.jsonPath().getString("batchName");
				payLoad.setBatchName(batchName);
		}	
		
	}catch(Exception e) 
	 {
	e.printStackTrace(); 
	 }
		return response; 
	}
	//invalid endpoint
public Response createBatch_InvalidEndPoint(P_02_BatchPayload payload)
{
	Response response=RestAssured.given()
			.baseUri(rb_routes.getString("BaseUrl"))
			.header("Authorization", "Bearer " + token)
			.log().all()
			.contentType("application/json")
			.body(payload)
			.when() 
			.post(BatchEndpoints.endpoint.CreateBatch_invalidEndpoint.getPath())
			.then()
			.log().all().extract().response();
	responseCode=response.getStatusCode();
	return response; 
}
	
	public  int getResponseCode()
	{
		return responseCode;
	}
	
	
	public Response getAllBatches()
	{
		Response response=RestAssured.given()
				.baseUri(rb_routes.getString("BaseUrl"))
				.header("Authorization", "Bearer " + token)
				.log().all()
				.when()
				.get(BatchEndpoints.endpoint.GETALLBATCHES.getPath());
		responseCode=response.getStatusCode();
		return response;
	}

	public Response getAllBatches_invalidEndpoint()
	{
		Response response=RestAssured.given()
				.baseUri(rb_routes.getString("BaseUrl"))
				.header("Authorization", "Bearer " + token)
				.log().all()
				.when()
				.get(BatchEndpoints.endpoint.GetAllBatches_InvalidEndpoint.getPath());
		responseCode=response.getStatusCode();
		return response;
	}
	
	public  int getAllbatchesResponseCode()
	{
		return responseCode;
	}

	public Response getBatchbyBatchId()
	{
		Response response=RestAssured.given()
				.baseUri(rb_routes.getString("BaseUrl"))
				.header("Authorization", "Bearer " + token)
				.log().all()
				.when()
				.get(BatchEndpoints.endpoint.GETBATCHBYBATCHID.getPath()+batchId)
				.then()
				.log().all().extract().response();
		responseCode=response.getStatusCode();
		return response;
	}

	public  int getBatchByIdResponseCode()
	{
		return responseCode;
	}

	public Response getBatchBy_Name()
	{
		Response response=RestAssured.given()
				.baseUri(rb_routes.getString("BaseUrl"))
				.header("Authorization", "Bearer " + token)
				.log().all()
				.when()
				.get(BatchEndpoints.endpoint.GETBATCHBYBATCHNAME.getPath()+batchName);
		responseCode=response.getStatusCode();
		return response;
	}

	public  int getBatchByNameResponseCode()
	{
		return responseCode;
	}

	public Response getBatchBy_ProgramId() throws IOException
	{
		Response response=RestAssured.given()
				.baseUri(rb_routes.getString("BaseUrl"))
				.header("Authorization", "Bearer " + token)
				.log().all()
				.when()
				.get(BatchEndpoints.endpoint.GETBATCHBYPROGRAMID.getPath()+BatchPayload.getProgramId())
				.then()
				.log().all().extract().response();
		responseCode=response.getStatusCode();
		return response;
	}

	public int getBatchby_programId_ResponseCode()
	{
		return responseCode;
	}

	//update batch by id 
	public Response updateBatchByID(P_02_BatchPayload payLoad) throws IOException 
	{

		Response response=RestAssured.given()
				.baseUri(rb_routes.getString("BaseUrl"))
				.header("Authorization", "Bearer " + token)
				.log().all()
				.contentType("application/json")
				.body(BatchPayload)
				.when()
				.put(BatchEndpoints.endpoint.UPDATEBYBATCHID.getPath()+batchId)
				.then()
				.log().all().extract().response();
		responseCode=response.getStatusCode();
		return response; 
	}

	public int UpdateBatch_ResponseCode()
	{
		return responseCode;
	}

	public Response  deleteBatchById()
	{
		Response response=RestAssured.given()
				.baseUri(rb_routes.getString("BaseUrl"))
				.header("Authorization", "Bearer " + token)
				.log().all()
				.when()
				.delete(BatchEndpoints.endpoint.DELETEBYBATCHID.getPath()+batchId)
				.then()
				.log().all().extract().response();
		responseCode=response.getStatusCode();
		return response;
	}

	public int deleteBatch_responseCode()
	{
		return responseCode;
	}

}

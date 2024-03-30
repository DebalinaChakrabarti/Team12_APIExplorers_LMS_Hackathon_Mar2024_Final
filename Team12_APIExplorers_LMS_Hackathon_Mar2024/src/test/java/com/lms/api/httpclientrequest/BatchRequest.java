package com.lms.api.httpclientrequest;


import java.io.IOException;
import com.lms.api.Payload.P_03_BatchPayload;
import com.lms.api.endpoints.BatchEndpoints;
import com.lms.api.utilities.RestUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BatchRequest extends RestUtils{

	int responseCode=0;
	String statusline;
	public Response createNewBatch(P_03_BatchPayload payload) throws IOException
	{
try {
		Response response=RestAssured.given()
				.baseUri(baseURL.getString("baseUri"))
				.header("Authorization", "Bearer " + token)
				.log().all()
				.contentType("application/json")
				.body(payload)
				.when()
				.post(BatchEndpoints.endpoint.CREATEBATCH.getPath())
				.then()
				.log().all().extract().response();
	
		batchId=response.jsonPath().getInt("batchId");
	payload.setBatchId(batchId);
		batchName=response.jsonPath().getString("batchName");
		payload.setBatchName(batchName);
		responseCode=response.getStatusCode();
	}catch(Exception e) {
	e.printStackTrace();
}
		return response; 
	}

	public  int getResponseCode()
	{
		return responseCode;
	}
	
	
	public Response getAllBatches()
	{
		Response response=RestAssured.given()
				.baseUri(baseURL.getString("baseUri"))
				.header("Authorization", "Bearer " + token)
				.log().all()
				.when()
				.get(BatchEndpoints.endpoint.GETALLBATCHES.getPath());
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
				.baseUri(baseURL.getString("baseUri"))
				.header("Authorization", "Bearer " + token)
				.log().all()
				.when()
				.get(BatchEndpoints.endpoint.GETBATCHBYBATCHID.getPath()+batchId);
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
				.baseUri(baseURL.getString("baseUri"))
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
				.baseUri(baseURL.getString("baseUri"))
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
	public Response updateBatchByID(P_03_BatchPayload payLoad) throws IOException 
	{

		Response response=RestAssured.given()
				.baseUri(baseURL.getString("baseUri"))
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
				.baseUri(baseURL.getString("baseUri"))
				.header("Authorization", "Bearer " + token)
				.log().all()
				.when()
				.delete(BatchEndpoints.endpoint.DELETEBYBATCHID.getPath()+batchId);
		responseCode=response.getStatusCode();
		return response;
	}

	public int deleteBatch_responseCode()
	{
		return responseCode;
	}

}

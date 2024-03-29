package com.lms.api.httpclientrequest;


import java.io.IOException;

import com.lms.api.endpoints.BatchEndpoints;
import com.lms.api.utilities.RestUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BatchRequest extends RestUtils{

	int responseCode=0;

	public Response createNewBatch() throws IOException
	{
		BatchPayload.setBatchDescription(xlutils.getCellData("BatchPostdata",1,0));
		BatchPayload.setBatchName(xlutils.getCellData("BatchPostdata",1,1));
		BatchPayload.setBatchNoOfClasses(xlutils.getCellData("BatchPostdata",1,2));
		BatchPayload.setBatchStatus(xlutils.getCellData("BatchPostdata",1,3));
		BatchPayload.setProgramId(Integer.parseInt(xlutils.getCellData("BatchPostdata",1,4)));


		Response response=RestAssured.given()
				.baseUri(baseURL.getString("baseUri"))
				.header("Authorization", "Bearer " + token)
				.log().all()
				.contentType("application/json")
				.body(BatchPayload)
				.when()
				.post(BatchEndpoints.endpoint.CREATEBATCH.getPath());
		batchId=response.jsonPath().getInt("batchId");
		batchName=response.jsonPath().getString("batchName");
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

		BatchPayload.setProgramId(Integer.parseInt(xlutils.getCellData("BatchPostdata",1,4)));

		Response response=RestAssured.given()
				.baseUri(baseURL.getString("baseUri"))
				.header("Authorization", "Bearer " + token)
				.log().all()
				.when()
				.get(BatchEndpoints.endpoint.GETBATCHBYPROGRAMID.getPath()+programId);
		responseCode=response.getStatusCode();
		return response;
	}

	public int getBatchby_programId_ResponseCode()
	{
		return responseCode;
	}

	//update batch by id 
	public Response updateBatchByID() throws IOException 
	{
		BatchPayload.setBatchDescription(xlutils.getCellData("BatchUpdateData", 1, 0));
		BatchPayload.setBatchName( xlutils.getCellData("BatchUpdateData", 1, 1));
		BatchPayload.setBatchNoOfClasses(xlutils.getCellData("BatchUpdateData", 1, 2));
		BatchPayload.setBatchStatus(xlutils.getCellData("BatchUpdateData", 1, 3));
		BatchPayload.setProgramId(Integer.parseInt(xlutils.getCellData("BatchUpdateData",1,4)));
		BatchPayload.setProgramName(xlutils.getCellData("BatchUpdateData", 1, 5));

		Response response=RestAssured.given()
				.baseUri(baseURL.getString("baseUri"))
				.header("Authorization", "Bearer " + token)
				.log().all()
				.contentType("application/json")
				.body(BatchPayload)
				.when()
				.put(BatchEndpoints.endpoint.UPDATEBYBATCHID.getPath()+batchId);
		batchId=response.jsonPath().getInt("batchId");
		batchName=response.jsonPath().getString("batchName");
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

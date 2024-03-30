package com.lms.api.StepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import com.lms.api.RequestBody.BatchModuleBody;
import com.lms.api.httpclientrequest.BatchRequest;
import com.lms.api.utilities.RestUtils;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

public class ProgramBatchModuleSD extends RestUtils{
	int responseCode=0;
	BatchRequest batchRequest=new BatchRequest();
	
	@Given("Admin creates POST Request  with valid data in request body")
	public void admin_creates_post_request_with_valid_data_in_request_body() {
		log.info("admin creates post request to create new batch");
	   	}

	@When("Admin sends HTTPS Request with endpoint")
	public void admin_sends_https_request_with_endpoint() throws IOException {
		batchRequest.createNewBatch(BatchModuleBody.CreateBatch_ValidData_Body());
		log.info("Post request sent to create new batch");
	}
	
	@Then("Admin receives {int} Created Status with response body")
	public void admin_receives_created_status_with_response_body(Integer int1) {
		log.info("created  batch response code is "+batchRequest.getResponseCode());
		Assert.assertEquals(batchRequest.getResponseCode(),int1);
		log.info("*********batch created*********");
	}
	
	@Given("Admin creates GET Request")
	public void admin_creates_get_request() {
		log.info("admin creates get request to get all  batches");
	}

	@When("Admin sends HTTPS Get Request with endpoint")
	public void admin_sends_https_get_request_with_endpoint() {
	batchRequest.getAllBatches();
		log.info("get request sent to get all batches");
	}

	@Then("Admin receives {int} OK Status with response body")
	public void admin_receives_ok_status_with_response_body(Integer int1) {
		log.info("response code is "+batchRequest.getAllbatchesResponseCode());
		Assert.assertEquals(batchRequest.getAllbatchesResponseCode(),int1);
		log.info("200 code received to get all batches");
	}

	@Given("Admin creates GET Request with valid Batch ID")
	public void admin_creates_get_request_with_valid_batch_id() {
		log.info("admin creates get request to get batch with  batch id");
	}

	@When("Admin sends Get Request with endpoint")
	public void admin_sends_get_request_with_endpoint() {
		
		batchRequest.getBatchbyBatchId();
		log.info("get request sent to get batch by id");
	}
	@Then("Admin receives {int} OK Status with response in the response body")
	public void admin_receives_ok_status_with_response_in_the_response_body(Integer int1) {
		log.info("response code is "+batchRequest.getBatchByIdResponseCode());
		Assert.assertEquals(batchRequest.getBatchByIdResponseCode(), int1);
		log.info("200 code received to get batch by id");
	}

	@Given("Admin creates GET Request with valid Batch Name")
	public void admin_creates_get_request_with_valid_batch_name() {
		log.info("request to get batch with  batch Name");
	   
	}

	@When("Admin sends Get batch Request with endpoint")
	public void admin_sends_get_batch_request_with_endpoint() {
		batchRequest.getBatchBy_Name();
		log.info("SENT request to get batch with  batch Name");
	}

	@Then("Admin receives {int} Status code with response body")
	public void admin_receives_status_code_with_response_body(Integer int1) {
		log.info("response code is "+batchRequest.getBatchByNameResponseCode());
	   Assert.assertEquals(batchRequest.getBatchByNameResponseCode(), int1);
	   log.info("200 code received to get batch by name");
	}

	@Given("Admin creates GET Request with valid Program Id")
	public void admin_creates_get_request_with_valid_program_id() {
		log.info("request to get batch by Program Id");
	   
	}

	@When("Admin sends HTTPS Request to get batch by program Id with endpoint")
	public void admin_sends_https_request_to_get_batch_by_program_id_with_endpoint() throws IOException {
	   batchRequest.getBatchBy_ProgramId();
	   log.info("SENT request to get batch by program Id");
	}

	@Then("Admin receives status code {int} OK Status with response body")
	public void admin_receives_status_code_ok_status_with_response_body(Integer int1) {
		log.info("response code is "+batchRequest.getBatchby_programId_ResponseCode());
	 Assert.assertEquals(batchRequest.getBatchby_programId_ResponseCode(), int1);
	   
	}

	@Given("Admin creates PUT Request with valid BatchId and Data")
	public void admin_creates_put_request_with_valid_batch_id_and_data() {
		log.info("request to update batch");
	   
	}

	@When("Admin sends HTTPS Request to update with endpoint")
	public void admin_sends_https_request_to_update_with_endpoint() throws IOException {
	 batchRequest.updateBatchByID(BatchModuleBody.updateBatch_validdata_Body());
	 log.info("SENT request to update batch");
	}

	@Then("Admin receives {int} OK Status with updated value in response body.")
	public void admin_receives_ok_status_with_updated_value_in_response_body(Integer int1) {
		log.info("response code to update batch is: "+batchRequest.UpdateBatch_ResponseCode());
	   Assert.assertEquals(batchRequest.UpdateBatch_ResponseCode(),int1);
	   log.info("batch upadated");
	}

	@Given("Admin creates DELETE Request with valid BatchId")
	public void admin_creates_delete_request_with_valid_batch_id() {
		log.info("request to delete batch");
	   
	}
	@When("Admin sends HTTPS Request to delete with endpoint")
	public void admin_sends_https_request_to_delete_with_endpoint() {
		batchRequest.deleteBatchById();
		log.info("request SENT to update batch");
	   
	}
	@Then("Admin receives {int} Ok status with message")
	public void admin_receives_ok_status_with_message(Integer int1) {
		log.info("response code to delete batch is "+batchRequest.deleteBatch_responseCode());
	   Assert.assertEquals(batchRequest.deleteBatch_responseCode(), int1);
	   log.info("batch deleted");
	}


}

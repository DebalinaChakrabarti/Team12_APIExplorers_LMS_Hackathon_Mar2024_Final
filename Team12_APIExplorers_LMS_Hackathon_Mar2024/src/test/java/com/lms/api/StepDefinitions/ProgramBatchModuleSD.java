package com.lms.api.StepDefinitions;

import java.io.IOException;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import org.testng.Assert;

import com.lms.api.RequestBody.BatchModuleBody;
import com.lms.api.Request.BatchRequest;
import com.lms.api.utilities.RestUtils;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

public class ProgramBatchModuleSD extends RestUtils{
	int responseCode=0;
	BatchRequest batchRequest=new BatchRequest();
	
	@Given("Admin creates POST Request  with valid data in request body")
	public void admin_creates_post_request_with_valid_data_in_request_body() {
		String BaseURI = rb_routes.getString("BaseUrl");
		baseURI = BaseURI;
		log.info("admin creates post request to create new batch");
	   	}

	@When("Admin sends HTTPS Request with endpoint to create batch")
	public void admin_sends_https_request_with_endpoint_to_create_batch() throws IOException {
		batchRequest.createNewBatch(BatchModuleBody.CreateBatch_ValidData_Body());  
		log.info("Post request sent to create new batch");
	}
	
	@Then("Admin receives {int} Created Status with response body")
	public void admin_receives_created_status_with_response_body(Integer statusCode) {
		log.info("created  batch response code is "+batchRequest.getResponseCode());
	
		Assert.assertEquals(batchRequest.getResponseCode(),statusCode);
		log.info("*********batch created*********");
	}

	@Given("Admin creates POST Request  with existing value in request body")
	public void admin_creates_post_request_with_existing_value_in_request_body() {
		
		log.info("create new batch with existing data");
	}

	@When("Admin sends HTTPS POST Request with endpoint to create batch")
	public void admin_sends_https_post_request_with_endpoint_to_create_batch() throws IOException {
		batchRequest.createNewBatch(BatchModuleBody.createBatch_existingData());
		log.info("Post request sent to create  batch with EXISTING DATA");
	}

	@Then("Admin receives {int} Bad Request Status with message in the response body")
	public void admin_receives_bad_request_status_with_message_in_the_reponse_body(Integer int1) {
	    Assert.assertEquals(batchRequest.getResponseCode(), int1);
	    log.info("400 code received");
	}
	
	@Given("Admin creates POST Request  with invalid data in request body")
	public void admin_creates_post_request_with_invalid_data_in_request_body() {
		log.info("create new batch with missing Mandatory fields ");
	}

	@When("Admin sends POST Request with endpoint to create batch")
	public void admin_sends_post_request_with_endpoint_to_create_batch() throws IOException {
		batchRequest.createNewBatch(BatchModuleBody.createBatch_missingMandatoryFields());
		log.info("Post request sent to create  batch with MISSING MANDATORY FIELDS");
	}

	@Then("Admin receives {int} Bad Request Status with message")
	public void admin_receives_bad_request_status_with_message(Integer int1) {
		  Assert.assertEquals(batchRequest.getResponseCode(), int1);
		    log.info("400 code received");
	}
	
	@Given("Admin creates POST Request")
	public void admin_creates_post_request() {
		log.info("create new batch with INVALID ENDPOINTS ");
	}

	@When("Admin sends HTTPS Request with invalid endpoint")
	public void admin_sends_https_request_with_invalid_endpoint() throws IOException {
	batchRequest.createBatch_InvalidEndPoint(BatchModuleBody.CreateBatch_ValidData_Body());
	log.info("Post request sent to create  batch with invalid Endpoint");
	}

	@Then("Admin receives {int} not found Status")
	public void admin_receives_not_found_status(Integer int1) {
		  Assert.assertEquals(batchRequest.getResponseCode(), int1);
		    log.info("404 code received");
	}

	@Given("Admin creates POST Request with missing additional fields")
	public void admin_creates_post_request_with_missing_additional_fields() {
		log.info("create new batch with missing additional fields");
	   
	}

	@When("Admin sends HTTPS Request with valid endpoint to create batch")
	public void admin_sends_https_request_with_valid_endpoint_to_create_batch() throws IOException {
		batchRequest.createNewBatch(BatchModuleBody.createBatch_missingAditionalFields());
	   
	}

	@Then("Admin receives {int} Created Status with response")
	public void admin_receives_created_status_with_response(Integer int1) {
	 
		Assert.assertEquals(batchRequest.getResponseCode(), int1);
	    log.info("201 code received");
	}

	@Given("Admin creates POST Request with invalid data fields in request body")
	public void admin_creates_post_request_with_invalid_data_fields_in_request_body() {
		log.info("create new batch with invalid data fields");
	   
	}

	@When("Admin sends HTTPS POST Request with valid endpoint")
	public void admin_sends_https_post_request_with_valid_endpoint() throws IOException {
		batchRequest.createNewBatch(BatchModuleBody.createBatch_InvalidData());
	   
	}
	
	@Then("Admin receives {int} Bad Request Status with message and boolean success")
	public void admin_receives_bad_request_status_with_message_and_boolean_success(Integer int1) {
		Assert.assertEquals(batchRequest.getResponseCode(), int1);
	    log.info("400 code received");
	   
	}

	@Given("Admin creates GET Request")
	public void admin_creates_get_request() {
		log.info("admin creates get request to get all  batches");
	}

	@When("Admin sends HTTPS Get Request with endpoint to get batch")
	public void admin_sends_https_get_request_with_endpoint_to_get_batch() {
	batchRequest.getAllBatches();
		log.info("get request sent to get all batches");
	}

	@Then("Admin receives {int} OK Status with response body")
	public void admin_receives_ok_status_with_response_body(Integer int1) {
		log.info("response code is "+batchRequest.getAllbatchesResponseCode());
		Assert.assertEquals(batchRequest.getAllbatchesResponseCode(),int1);
		log.info("200 code received to get all batches");
	}

	@Given("Admin creates GET Request with invalid endpoint")
	public void admin_creates_get_request_with_invalid_endpoint() {
		log.info("admin creates get request to get all  batches with invalid endpoint");
	}

	@When("Admin sends HTTPS GET Request with invalid endpoint to get all batches")
	public void admin_sends_https_get_request_with_invalid_endpoint_to_get_all_batches() {
	   batchRequest.getAllBatches_invalidEndpoint();
	   log.info("get request sent to get all batches with invalid endpoint");
	}

	@Then("Admin receives {int} status with error message Not Found")
	public void admin_receives_status_with_error_message_not_found(Integer int1) {
		Assert.assertEquals(batchRequest.getAllbatchesResponseCode(),int1);
		log.info("404 code received to get all batches");
	}

	@Given("Admin creates GET Request with valid Batch ID")
	public void admin_creates_get_request_with_valid_batch_id() {
		log.info("admin creates get request to get batch with  batch id");
	}

	@When("Admin sends Get Request with endpoint for batch module")
	public void admin_sends_get_request_with_endpoint_for_batch_module() {
		
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

	@When("Admin sends Get batch Request with endpoint for batch module")
	public void admin_sends_get_batch_request_with_endpoint_for_batch_module() {
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

	@Then("Admin receives {int} OK Status with updated value in response body for update request.")
	public void admin_receives_ok_status_with_updated_value_in_response_body_for_update_request(Integer int1) {
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
	@Then("Admin receives {int} Ok status with message to delete batch module")
	public void admin_receives_ok_status_with_message_to_delete_batch_module(Integer int1) {
		log.info("response code to delete batch is "+batchRequest.deleteBatch_responseCode());
	   Assert.assertEquals(batchRequest.deleteBatch_responseCode(), int1);
	   log.info("batch deleted");
	}

	@When("Admin sends HTTPS GET Request with valid id")
	public void admin_sends_https_get_request_with_valid_id() {
		batchRequest.getBatchbyBatchId();
	}

	@Then("Admin receives {int} OK Status with  batchStatus field {string} in the response body.")
	public void admin_receives_ok_status_with_batch_status_field_in_the_response_body(Integer int1, String string) {
		Assert.assertEquals(batchRequest.getBatchByIdResponseCode(), int1);
		String status=batchRequest.getBatchbyBatchId().jsonPath().getString("batchStatus");
		Assert.assertEquals(status,string);
		log.info("200 code received to get batch by id");
	}

}

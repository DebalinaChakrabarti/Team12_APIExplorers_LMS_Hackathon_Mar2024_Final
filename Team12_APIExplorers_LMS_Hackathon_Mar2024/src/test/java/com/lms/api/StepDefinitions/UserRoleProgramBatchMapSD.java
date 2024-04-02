package com.lms.api.StepDefinitions;

import static io.restassured.RestAssured.baseURI;

import org.testng.Assert;

import com.lms.api.Request.UserRoleProgramBatchMap;
import com.lms.api.utilities.RestUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class UserRoleProgramBatchMapSD extends RestUtils{

	@Given("Admin creates GET Request to retrieve all Admins assigned to programs\\/batches with Authorization to bearer token")
	public void admin_creates_get_request_to_retrieve_all_admins_assigned_to_programs_batches_with_authorization_to_bearer_token() {

		if(baseURI.isBlank())
			baseURI = rb_routes.getString("BaseUrl");
		
		log.info("*** User sets BaseURL for UserRoleProgramBatchMap ***" + baseURI);

	}

	@When("Admin sends HTTPS GET Request to retrieve all Admins assigned to programs\\/batches with Authorization to bearer token")
	public void admin_sends_https_get_request_to_retrieve_all_admins_assigned_to_programs_batches_with_authorization_to_bearer_token() {

	}

	@Then("Admin receives statuscode {int} OK for Role Program Batch Map")
	public void admin_receives_statuscode_ok_for_role_program_batch_map(Integer expectedStatusCode) {
		Response response = UserRoleProgramBatchMap.getAllRoleProgramBatchMap();
		Assert.assertEquals(response.getStatusCode(), expectedStatusCode);

		log.info("*** getAllRoleProgramBatchMap Status Code *** " + response.getStatusCode());
		log.info("*** getAllRoleProgramBatchMap Response Body *** " + response.getBody().asString());
	}

	@Given("Admin creates GET Request to retrieve all Admins assigned to programs\\/batches with authorization to No Auth")
	public void admin_creates_get_request_to_retrieve_all_admins_assigned_to_programs_batches_with_authorization_to_no_auth() {
		if(baseURI.isBlank())
			baseURI = rb_routes.getString("BaseUrl");
		
		log.info("*** User sets BaseURL for UserRoleProgramBatchMap ***" + baseURI);
	}

	@When("Admin sends HTTPS Request without authorization")
	public void admin_sends_https_request_without_authorization() {
	}

	@Then("Admin receives status {int} with Unauthorized message for Role Program Batch Map")
	public void admin_receives_status_with_unauthorized_message_for_role_program_batch_map(Integer expectedStatusCode) {
		Response response = UserRoleProgramBatchMap.getAllRoleProgramBatchMapWithoutAuthorization();
		Assert.assertEquals(response.getStatusCode(), expectedStatusCode);
		Assert.assertEquals(response.getBody().jsonPath().get("error"), "Unauthorized");

			log.info("*** getAllRoleProgramBatchMapWithoutAuthorization Status Code *** " + response.getStatusCode());
			log.info("*** getAllRoleProgramBatchMapWithoutAuthorization Response Body *** " + response.getBody().asString());
	
	}

	@Given("Admin creates GET Request to retrieve Admin assigned to Program\\/Batch by AdminId with Authorization to bearer token")
	public void admin_creates_get_request_to_retrieve_admin_assigned_to_program_batch_by_admin_id_with_authorization_to_bearer_token() {
		if(baseURI.isBlank())
			baseURI = rb_routes.getString("BaseUrl");
		
		log.info("*** get All RoleProgramBatchMap By Admin ID *** "+ baseURI);
	}

	@When("Admin sends HTTPS Request to get program batches for valid AdminId")
	public void admin_sends_https_request_to_get_program_batches_for_valid_admin_id() {
	}

	@Then("Admin will receive {int} OK for Role Program Batch Map")
	public void admin_will_receive_ok_for_role_program_batch_map(Integer expectedStatusCode) {
		Response response = UserRoleProgramBatchMap.getAllRoleProgramBatchMapByAdminID();
		Assert.assertEquals(response.getStatusCode(), expectedStatusCode);

			log.info("*** getAllRoleProgramBatchMapByAdminID Status Code *** " + response.getStatusCode());
			log.info("*** getAllRoleProgramBatchMapByAdminID Response Body *** " + response.getBody().asString());
	
	}
	@Given("Admin creates GET Request to retrieve Admin assigned to Program\\/Batch by invalid AdminID with Authorization to bearer token")
	public void admin_creates_get_request_to_retrieve_admin_assigned_to_program_batch_by_invalid_admin_id_with_authorization_to_bearer_token() {
		if(baseURI.isBlank())
			baseURI = rb_routes.getString("BaseUrl");
		
		log.info("*** get RoleProgramBatchMap By Invalid Admin ID *** "+baseURI);
	}

	@When("Admin sends HTTPS Request to get program batches for invalid AdminId")
	public void admin_sends_https_request_to_get_program_batches_for_invalid_admin_id() {
	}

	@Then("Admin receives {int} with message for Role Program Batch Map")
	public void admin_receives_with_message_for_role_program_batch_map(Integer expectedStatusCode){
		Response response = UserRoleProgramBatchMap.getRoleProgramBatchMapByInvalidAdminID();
		Assert.assertEquals(response.getStatusCode(), expectedStatusCode);

			log.info("*** getRoleProgramBatchMapByInvalidAdminID Status Code *** " + response.getStatusCode());
			log.info("*** getRoleProgramBatchMapByInvalidAdminID Response Body *** " + response.getBody().asString());
	}
	
	@Given("Admin creates GET Request to retrieve Admin assigned to Program\\/Batch by valid AdminID with authorization to No Auth")
	public void admin_creates_get_request_to_retrieve_admin_assigned_to_program_batch_by_valid_admin_id_with_authorization_to_no_auth() {
		if(baseURI.isBlank())
			baseURI = rb_routes.getString("BaseUrl");
		
		log.info("*** get RoleProgramBatchMap By Admin ID with No Auth *** "+baseURI);

	}

	@When("Admin sends HTTPS Request to get Program\\/Batch by valid Admin Id without authorization")
	public void admin_sends_https_request_to_get_program_batch_by_valid_admin_id_without_authorization() {
	}

	@Then("Admin will receive status {int} with Unauthorized message for Role Program Batch Map")
	public void admin_will_receive_status_with_unauthorized_message_for_role_program_batch_map(Integer expectedStatusCode) {
		Response response = UserRoleProgramBatchMap.getAllProgramBatchByAdminIDWithoutAuthorization();
		Assert.assertEquals(response.getStatusCode(), expectedStatusCode);
		Assert.assertEquals(response.getBody().jsonPath().get("error"), "Unauthorized");

			log.info("*** getAllProgramBatchByAdminIDWithoutAuthorization Status Code *** " + response.getStatusCode());
			log.info("*** getAllProgramBatchByAdminIDWithoutAuthorization Response Body *** " + response.getBody().asString());
		
	}
	
	@Given("Admin creates DELETE Request to delete Admin assigned to program\\/batch by AdminId with Authorization to bearer token")
	public void admin_creates_delete_request_to_delete_admin_assigned_to_program_batch_by_admin_id_with_authorization_to_bearer_token() {
		if(baseURI.isBlank())
			baseURI = rb_routes.getString("BaseUrl");
		
		log.info("*** Delete RoleProgramBatchMap By Admin ID  *** "+baseURI);
	}

	@When("Admin sends HTTPS Request to Delete program\\/batch by Admin Id")
	public void admin_sends_https_request_to_delete_program_batch_by_admin_id() {
	}

	@Then("Admin receives Status Code {int} OK after delete operation for Role Program Batch Map")
	public void admin_receives_status_code_ok_after_delete_operation_for_role_program_batch_map(Integer expectedStatusCode) {
		Response response = UserRoleProgramBatchMap.deleteProgramBatchByAdminID();
		Assert.assertEquals(response.getStatusCode(), expectedStatusCode);

			log.info("*** deleteProgramBatchByAdminID Status Code *** " + response.getStatusCode());
			log.info("*** deleteProgramBatchByAdminID Response Body *** " + response.getBody().asString());
	}

	@Given("Admin creates DELETE Request to delete Admin assigned to program\\/batch by invalid AdminId with Authorization to bearer token")
	public void admin_creates_delete_request_to_delete_admin_assigned_to_program_batch_by_invalid_admin_id_with_authorization_to_bearer_token() {
		if(baseURI.isBlank())
			baseURI = rb_routes.getString("BaseUrl");
		
		log.info("*** Delete RoleProgramBatchMap By Invalid Admin ID  *** "+baseURI);
	}

	@When("Admin sends HTTPS Request to delete program\\/batch by invalid Admin Id")
	public void admin_sends_https_request_to_delete_program_batch_by_invalid_admin_id() {
	}

	@Then("Admin will receive {int} with message for Role Program Batch Map")
	public void admin_will_receive_with_message_for_role_program_batch_map(Integer expectedStatusCode) {
		Response response = UserRoleProgramBatchMap.deleteProgramBatchByInvalidAdminID();
		Assert.assertEquals(response.getStatusCode(), expectedStatusCode);

			log.info("*** deleteProgramBatchByInvalidAdminID Status Code *** " + response.getStatusCode());
			log.info("*** deleteProgramBatchByInvalidAdminID Response Body *** " + response.getBody().asString());
	}

	@Given("Admin creates DELETE Request to delete Admin assigned to program\\/batch by valid AdminId with authorization to No Auth")
	public void admin_creates_delete_request_to_delete_admin_assigned_to_program_batch_by_valid_admin_id_with_authorization_to_no_auth() {
		if(baseURI.isBlank())
			baseURI = rb_routes.getString("BaseUrl");
		
		log.info("*** Delete RoleProgramBatchMap By Admin ID Without Authorization *** "+baseURI);
	}

	@When("Admin sends HTTPS Request to delete program\\/batch by Admin id without Authorization")
	public void admin_sends_https_request_to_delete_program_batch_by_admin_id_without_authorization() {
	}

	@Then("Admin will receive status code {int} with Unauthorized message for Role Program Batch Map")
	public void admin_will_receive_status_code_with_unauthorized_message_for_role_program_batch_map(Integer expectedStatusCode) {
		Response response = UserRoleProgramBatchMap.deleteProgramBatchByAdminIDWithoutAuthorization();
		Assert.assertEquals(response.getStatusCode(), expectedStatusCode);
		Assert.assertEquals(response.getBody().jsonPath().get("error"), "Unauthorized");

			log.info("*** deleteProgramBatchByAdminIDWithoutAuthorization Status Code *** " + response.getStatusCode());
			log.info("*** deleteProgramBatchByAdminIDWithoutAuthorization Response Body *** " + response.getBody().asString());
	}


}

package com.lms.api.StepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import com.lms.api.Request.UserModule;
import com.lms.api.utilities.RestUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserModuleSD extends RestUtils {

	UserModule userModule = new UserModule();

	@Given("Admin creates POST request with all mandatory fields for User Module")
	public void admin_creates_post_request_with_all_mandatory_fields_for_user_module() {
		log.info("Admin creates POST request with all mandatory fields");
	}

	@When("Admin sends HTTPS Request with endpoint for User Module")
	public void admin_sends_https_request_with_endpoint_for_user_module() {
		log.info("Admin sends user post Request with endpoint");
	}

	@Then("Admin receives {int} Created Status with response body for User Module")
	public void admin_receives_created_status_with_response_body_for_user_module(Integer int1) throws IOException {
		response = userModule.userModulePostRequest();
		Assert.assertEquals(response.getStatusCode(), int1);

	}

	@Given("Admin creates GET Request for User Module")
	public void admin_creates_get_request_for_user_module() {
		log.info("**Admin creates Get Request ***");
	}

	@When("Admin sends HTTPS Request with GET All Roles endpoint for User Module")
	public void admin_sends_https_request_with_get_all_roles_endpoint_for_user_module() {
		log.info("***admin sends request with Get All roles endpoint****");
	}

	@Then("Admin receives {int} OK  for User Module")
	public void admin_receives_ok_for_user_module(Integer int1) {
		response = userModule.getAllRoles();
		Assert.assertEquals(response.statusCode(), int1);
	}


	@When("Admin sends HTTPS Request with valid endpoint for User Module")
	public void admin_sends_https_request_with_valid_endpoint_for_user_module() {
		log.info("****Admin sends request with valid endpoint to Get all Admins****");
	}

	@Then("Admin receives {int} OK Status with response body for User Module")
	public void admin_receives_ok_status_with_response_body_for_user_module(Integer int1) {
		response = userModule.getAllAdmins();
		Assert.assertEquals(response.statusCode(), int1);
		log.info("**Admin receives OK status with response body****");
	}

	@Given("Admin creates GET Request with valid AdminId")
	public void admin_creates_get_request_with_valid_admin_id() {
		log.info("Admin creates GET Request with valid AdminId");
	}

	@Then("Admin  receices {int} OK")
	public void admin_receices_ok(Integer int1) {
		response = userModule.getInfoByAdminId();
		Assert.assertEquals(response.getStatusCode(), int1);
	}

	@Given("Admin creates GET Request for active admins")
	public void admin_creates_get_request_for_active_admins() {
		log.info("Admin creates GET Request for active admins");
	}

	@When("Admin sends HTTPS Request with Get ALL Active Users endpoint for User Module")
	public void admin_sends_https_request_with_get_all_active_users_endpoint_for_user_module() {
		log.info("Admin sends HTTPS Request with Get ALL Active Users endpoint");
	}

	@Then("Admin receives {int} OK with all Active Admins response body for User Module")
	public void admin_receives_ok_with_all_active_admins_response_body_for_user_module(Integer int1)
			throws IOException {
		response = userModule.getAllActiveAdmins();
		Assert.assertEquals(response.statusCode(), int1);
	}

	@Then("Admin  receices {int} OK With count of all active and inactive admins for User Module")
	public void admin_receices_ok_with_count_of_all_active_and_inactive_admins_for_user_module(Integer int1)
			throws IOException {
		log.info("***Admin sends request to count of all active and inactive admins***");
		response = userModule.getCountOfAllActiveAndInactiveAdmins();
		Assert.assertEquals(response.statusCode(), int1);
	}

	@Given("Admin creates GET Request with valid batch Id for User Module")
	public void admin_creates_get_request_with_valid_batch_id_for_user_module() {
		log.info("Admin creates GET Request with valid batch Id");
	}

	@When("Admin sends HTTPS Request with endpoint to get Admins by program batch for valid batchId for User Module")
	public void admin_sends_https_request_with_endpoint_to_get_admins_by_program_batch_for_valid_batch_id_for_user_module() {
		log.info("Admin sends HTTPS Request with endpoint to get Admins by program batch for valid batchId");
	}

	@Then("Admin receives {int} OK for admins by program batches for valid adminId for User Module")
	public void admin_receives_ok_for_admins_by_program_batches_for_valid_admin_id_for_user_module(Integer int1)
			throws IOException {
		response = userModule.getAdminsByProgramBatches();
		Assert.assertEquals(response.statusCode(), int1);

	}

	@Given("Admin creates GET Request to get admins with valid program Id for User Module")
	public void admin_creates_get_request_to_get_admins_with_valid_program_id_for_user_module() {
		log.info("Admin creates GET Request to get admins with valid program Id");
	}

	@When("Admin sends HTTPS Request with endpoint to get the Admins for valid program Id for User Module")
	public void admin_sends_https_request_with_endpoint_to_get_the_admins_for_valid_program_id_for_user_module() {
		log.info("Admin sends HTTPS Request with endpoint to get the Admins for valid program Id");
	}

	@Then("Admin receives {int} OK to get the Admins for valid program Id for User Module")
	public void admin_receives_ok_to_get_the_admins_for_valid_program_id_for_user_module(Integer int1)
			throws IOException {
		response = userModule.getAdminForProgram();
		Assert.assertEquals(response.statusCode(), int1);
	}

	@Given("Admin creates GET Request with valid role ID  to retreive Admins by valid role ID")
	public void admin_creates_get_request_with_valid_role_id_to_retreive_admins_by_valid_role_id() {
		log.info("Admin creates GET Request with valid role ID  to retreive Admins by valid role ID");
	}

	@When("Admin sends HTTPS Request with endpoint to retreive Admins by valid role ID")
	public void admin_sends_https_request_with_endpoint_to_retreive_admins_by_valid_role_id() {
		log.info("Admin sends HTTPS Request with endpoint  to retreive Admins by valid role ID");
	}

	@Then("Admin receives {int} OK when retreived Admins by valid role ID for User Module")
	public void admin_receives_ok_when_retreived_admins_by_valid_role_id_for_user_module(Integer int1)
			throws IOException {
		log.info("Admin receives {int} OK when retreived Admins by valid role ID");
		response = userModule.getAdminbyRoleID();
		Assert.assertEquals(response.statusCode(), int1);
	}

	@Given("Admin creates GET Request to retrieve all Admins with roles")
	public void admin_creates_get_request_to_retrieve_all_admins_with_roles() {
		log.info("Admin creates GET Request to retrieve all Admins with roles");
	}

	@When("Admin sends HTTPS Request with endpoint to retrieve all Admins with roles")
	public void admin_sends_https_request_with_endpoint_to_retrieve_all_admins_with_roles() {
		log.info("Admin sends HTTPS Request with endpoint to retrieve all Admins with roles");
	}

	@Then("Admin receives {int} OK Status with response body after retrieved all Admins with roles for User Module")
	public void admin_receives_ok_status_with_response_body_after_retrieved_all_admins_with_roles_for_user_module(
			Integer int1) throws IOException {
		log.info("Admin receives {int} OK Status with response body after retrieved all Admins with roles");
		response = userModule.getAdminWithRoles();
		Assert.assertEquals(response.statusCode(), int1);
	}

	@Given("Admin creates GET Request to retrieve all Admins with filters")
	public void admin_creates_get_request_to_retrieve_all_admins_with_filters() {
		log.info("Admin creates GET Request to retrieve all Admins with filters");
	}

	@When("Admin sends HTTPS Request with endpoint to retrieve all Admins with filters")
	public void admin_sends_https_request_with_endpoint_to_retrieve_all_admins_with_filters() {
		log.info("Admin sends HTTPS Request with endpoint to retrieve all Admins with filters");
	}

	@Then("Admin receives {int} OK after retrieved all Admins with filters")
	public void admin_receives_ok_after_retrieved_all_admins_with_filters(Integer int1) {
		response = userModule.getAdminWithFilters();
		Assert.assertEquals(response.statusCode(), int1);
		log.info("Admin receives {int} OK after retrieved all Admins with filters");

	}

	/*****************************************************************/

	@Given("Admin creates PUT Request with valid request body for User Module")
	public void admin_creates_put_request_with_valid_request_body_for_user_module() {
		log.info("Admin creates PUT Request with valid request body");
	}

	@When("Admin sends HTTPS Request with endpoint to update Admin roleId by valid AdminId")
	public void admin_sends_https_request_with_endpoint_to_update_admin_role_id_by_valid_admin_id() {
		log.info("Admin sends HTTPS Request with endpoint to update Admin roleId by valid AdminId");
	}

	@Then("Admin receives {int} OK  Status with response body to update Admin roleId")
	public void admin_receives_ok_status_with_response_body_to_update_admin_role_id(Integer int1) throws IOException {
		response = userModule.putUpdateAdminRoleId();
		Assert.assertEquals(response.statusCode(), int1);
	}

	@Given("Admin creates PUT Request with valid data in request body to update role status")
	public void admin_creates_put_request_with_valid_data_in_request_body_to_update_role_status() {
		log.info("Admin creates PUT Request with valid data in request body to update role status");
	}

	@When("Admin sends HTTPS Request with endpoint to update role status")
	public void admin_sends_https_request_with_endpoint_to_update_role_status() {
		log.info("Admin sends HTTPS Request with endpoint to update role status");

	}

	@Then("Admin receives {int} Ok Status with response message after update of role status for User Module")
	public void admin_receives_ok_status_with_response_message_after_update_of_role_status_for_user_module(Integer int1)
			throws IOException {
		log.info("Admin receives {int} Ok Status with response message after update of role status");
		response = userModule.updateAdminRoleStatusByAdminId();
		Assert.assertEquals(response.statusCode(), int1);
	}

	@Given("Admin creates PUT Request with valid data in request body to assign Admin with program\\/batch by Admin Id")
	public void admin_creates_put_request_with_valid_data_in_request_body_to_assign_admin_with_program_batch_by_admin_id() {
		log.info(
				"Admin creates PUT Request with valid data in request body to assign Admin with program\\/batch by Admin Id");
	}

	@When("Admin sends HTTPS Request with endpoint to assign Admin with program\\/batch by Admin Id")
	public void admin_sends_https_request_with_endpoint_to_assign_admin_with_program_batch_by_admin_id() {
		log.info("Admin sends HTTPS Request with endpoint to assign Admin with program\\/batch by Admin Id");
	}

	@Then("Admin receives {int} Ok Status with response message to assign Admin to with program\\/batch by Admin Id")
	public void admin_receives_ok_status_with_response_message_to_assign_admin_to_with_program_batch_by_admin_id(
			Integer int1) throws IOException {
		log.info(
				"Admin receives {int} Ok Status with response message to assign Admin to with program\\/batch by Admin Id");
		response = userModule.UpdateAdminRoleProgramBatchStatus();
		Assert.assertEquals(response.statusCode(), int1);

	}

	/*******************************************************/

	@Given("Admin creates PUT Request with valid data in request body \\(values only in mandatory fields)")
	public void admin_creates_put_request_with_valid_data_in_request_body_values_only_in_mandatory_fields() {
		log.info("Admin creates PUT Request with valid data in request body \\(values only in mandatory fields)");
	}

	@When("Admin sends HTTPS request with endpoiint  to update Admin details with Admin id and mandatory fields")
	public void admin_sends_https_request_with_endpoiint_to_update_admin_details_with_admin_id_and_mandatory_fields() {
		log.info(
				"Admin sends HTTPS request with endpoiint  to update Admin details with Admin id and mandatory fields");
	}

	@Then("Admin receives {int} Ok status with message after update Admin details with Admin id and mandatory fields")
	public void admin_receives_ok_status_with_message_after_update_admin_details_with_admin_id_and_mandatory_fields(
			Integer int1) throws IOException {
		log.info(
				"Admin receives {int} Ok status with message after update Admin details with Admin id and mandatory fields");
		response = userModule.putUpdateAdmininfo();
		Assert.assertEquals(response.statusCode(), int1);

	}

}

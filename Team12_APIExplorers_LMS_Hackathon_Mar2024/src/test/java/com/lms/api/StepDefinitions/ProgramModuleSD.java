package com.lms.api.StepDefinitions;

import static io.restassured.RestAssured.baseURI;

import java.io.IOException;

import org.testng.Assert;

import com.lms.api.Request.Program;
import com.lms.api.RequestBody.ProgramModuleBody;
import com.lms.api.utilities.RestUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.restassured.response.Response;

public class ProgramModuleSD extends RestUtils {
	
	int RStatuscode =0;
	Program program = new Program();

	@Given("Admin creates POST Request for the LMS with request body")
	public void admin_creates_post_request_for_the_lms_with_request_body() {
		String BaseURI = rb_routes.getString("BaseUrl");
		baseURI = BaseURI;
		log.info("***User sends request with BaseURL***");

	}

	@When("Admin sends HTTPS Request and  request Body with endpoint")
	public void admin_sends_https_request_and_request_body_with_endpoint() throws IOException {
	   
	   program.PostRequest(ProgramModuleBody.PostProgramBody());
	   
	}

	@Then("Admin receives {int} Created Status with response body.")
	public void admin_receives_created_status_with_response_body(Integer ExpectedStatuscode) throws IOException{
		
		log.info("created program response code is "+program.getCreatepgResponseCode());
		Assert.assertEquals(program.getCreatepgResponseCode(),ExpectedStatuscode);
		log.info("*********Program created*********");
		
	}
	
		
/*	@When("Admin sends HTTPS Request and  request Body with invalid endpoint")
	public void admin_sends_https_request_and_request_body_with_invalid_endpoint() throws IOException {
		
	    	program.ProgrmInvalidEndpoint(ProgramModuleBody.PostProgramBody());
	}
		
	@Then("Admin receives {int} not found  Status with message and boolean success details")
	public void admin_receives_not_found_status_with_message_and_boolean_success_details(Integer status_code)throws IOException {
//		Response response = Program.ProgrmInvalidEndpoint(ProgramModuleBody.PostProgramBody());
//		if (status_code == 404) {
//
//			response.then().assertThat().statusCode(status_code).log().all();
//
//			log.info("Program with invalid endpoint " + response.getStatusCode());
//			log.info("Program with invalid endpoint " + response.getBody().asString());
//		} 
	}
	
	@Then("Admin receives {int} Bad Request Status with message and boolean success details")
	public void admin_receives_bad_request_status_with_message_and_boolean_success_details(Integer status_code)throws IOException {
//		Response response = Program.PostRequest(ProgramModuleBody.PostProgramBody());
//		if (status_code == 400) {
//
//			response.then().assertThat().statusCode(status_code).log().all();
//
//			log.info("Program name already exists " + response.getStatusCode());
//			log.info("Program name already exists " + response.getBody().asString()); 
//		} 
	}*/
	
	@Given("Admin creates GET Request for the LMS API")
	public void admin_creates_get_request_for_the_lms_api() {
		String BaseURI = rb_routes.getString("BaseUrl");
		baseURI = BaseURI;
		log.info("***User sends request with BaseURL***");

	}

	@When("Admin sends HTTPS Request with endpoint")
	public void admin_sends_https_request_with_endpoint() {
	    program.getAllPrograms();
	}

	@Then("Admin receives {int} OK Status with response body.")
	public void admin_receives_ok_status_with_response_body(Integer ExpectedStatuscode) {
		log.info("GET all programs response code is "+program.getCreatepgResponseCode());
		Assert.assertEquals(program.getAllprgmResponseCode(),ExpectedStatuscode);
		log.info("*********Get ALL Programs *********");
	}
	
	@Given("Admin creates GET Request for the LMS API	with valid Program ID")
	public void admin_creates_get_request_for_the_lms_api_with_valid_program_id() {
		String BaseURI = rb_routes.getString("BaseUrl");
		baseURI = BaseURI;
		log.info("***User sends request with BaseURL***");
	}

	@When("Admin sends Get program Request with endpoint")
	public void admin_sends_get_program_request_with_endpoint() {
	    program.getPrgmbyProgramId();
	}

	@Then("Admin receives {int} OK Status code with response body.")
	public void admin_receives_ok_status_code_with_response_body(Integer ExpectedStatuscode) {
		log.info("GET program using programId response code is "+program.getPgrmByIdResponseCode());
		Assert.assertEquals(program.getPgrmByIdResponseCode(),ExpectedStatuscode);
		log.info("*********Get Program by Program ID *********");
	}
	
	@Given("Admin creates GET Request for the LMS API	for Users")
	public void admin_creates_get_request_for_the_lms_api_for_users() {
		String BaseURI = rb_routes.getString("BaseUrl");
		baseURI = BaseURI;
		log.info("***User sends request with BaseURL***");
	}

	@When("Admin sends Get All programs with users Request with endpoint")
	public void admin_sends_get_all_programs_with_users_request_with_endpoint() {
	    program.getAllProgramswithUsers();
	}

	@Then("Admin receives {int} OK Status with response body of Users")
	public void admin_receives_ok_status_with_response_body_of_users(Integer ExpectedStatuscode) {
		log.info("GET program for all users response code is "+program.getAllprgmwithusersResponseCode());
		Assert.assertEquals(program.getAllprgmwithusersResponseCode(),ExpectedStatuscode);
		log.info("*********Get Programs for All Users *********");
	}

	@Given("Admin creates PUT Request for the LMS API endpoint with request Body with mandatory , additional  fields.")
	public void admin_creates_put_request_for_the_lms_api_endpoint_with_request_body_with_mandatory_additional_fields() {
		String BaseURI = rb_routes.getString("BaseUrl");
		baseURI = BaseURI;
		log.info("***User sends request with BaseURL***");
	}

	@When("Admin sends Put Request with valid endpoint")
	public void admin_sends_put_request_with_valid_endpoint()throws IOException {
		program.updateProgramByID(ProgramModuleBody.UpdateByIDProgramBody());
	}

	@Then("Admin receives {int} OK Status with updated value in response body.")
	public void admin_receives_ok_status_with_updated_value_in_response_body(Integer ExpectedStatuscode) {
		log.info("Update program with program Id response code is "+program.UpdatePrgrmResponseCode());
		Assert.assertEquals(program.UpdatePrgrmResponseCode(),ExpectedStatuscode);
		log.info("*********Update Program By Program Id *********");
	}
	
	@Given("Admin creates PUT Request with Program Name for the LMS API endpoint with valid request Body with mandatory , additional  fields.")
	public void admin_creates_put_request_with_program_name_for_the_lms_api_endpoint_with_valid_request_body_with_mandatory_additional_fields() {
		String BaseURI = rb_routes.getString("BaseUrl");
		baseURI = BaseURI;
		log.info("***User sends request with BaseURL***");
	}

	@When("Admin sends Put Request with Program name with valid endpoint")
	public void admin_sends_put_request_with_program_name_with_valid_endpoint() throws IOException {
		program.updateProgramByName(ProgramModuleBody.UpdateByProgramNameBody());
	}

	@Then("Admin receives {int} OK Status code with updated value in response body.")
	public void admin_receives_ok_status_code_with_updated_value_in_response_body(Integer ExpectedStatuscode) {
		log.info("Update program with program name response code is "+program.UpdatePrgrmnameResponseCode());
		Assert.assertEquals(program.UpdatePrgrmnameResponseCode(),ExpectedStatuscode);
		log.info("*********Update Program By Program Id *********");
	}
	
	@Given("Admin creates DELETE Request for the LMS API endpoint  and  valid programName")
	public void admin_creates_delete_request_for_the_lms_api_endpoint_and_valid_program_name() {
		String BaseURI = rb_routes.getString("BaseUrl");
		baseURI = BaseURI;
		log.info("***User sends request with BaseURL***");
	}

	@When("Admin sends Delete by ProgramName Request with endpoint")
	public void admin_sends_delete_by_program_name_request_with_endpoint() {
	    program.deleteProgramById();
	}

	@Then("Admin receives {int} Ok status with message")
	public void admin_receives_ok_status_with_message(Integer ExpectedStatuscode) {
		log.info("Delete program with program ID response code is "+program.deletePgmresponseCode());
		Assert.assertEquals(program.deletePgmresponseCode(),ExpectedStatuscode);
		log.info("*********Deelete Program By Program Id *********");
	}

	@Given("Admin creates DELETE Request for the LMS API endpoint  and  valid program ID")
	public void admin_creates_delete_request_for_the_lms_api_endpoint_and_valid_program_id() {
		String BaseURI = rb_routes.getString("BaseUrl");
		baseURI = BaseURI;
		log.info("***User sends request with BaseURL***");
	}

	@When("Admin sends Delete Request By Program Name with endpoint")
	public void admin_sends_delete_request_by_program_name_with_endpoint() {
	    program.deleteProgramByName();
	}

	@Then("Admin receives {int} Ok status with message for delete by program name")
	public void admin_receives_ok_status_with_message_for_delete_by_program_name(Integer ExpectedStatuscode) {
		log.info("Delete program with program Name response code is "+program.deletePgmNameresponseCode());
		Assert.assertEquals(program.deletePgmNameresponseCode(),ExpectedStatuscode);
		log.info("*********Deelete Program By Program Id *********");
	}
}

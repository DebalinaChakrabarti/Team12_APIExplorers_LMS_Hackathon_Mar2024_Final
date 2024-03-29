package com.lms.api.StepDefinitions;

import static io.restassured.RestAssured.baseURI;

import java.io.IOException;
import com.lms.api.Request.Program;
import com.lms.api.RequestBody.ProgramModuleBody;
import com.lms.api.utilities.RestUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

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
	public void admin_receives_created_status_with_response_body(Integer int1) throws IOException{
		
		log.info("created program response code is "+program.getCreatepgResponseCode());
	//	Assert.assertEquals(program.getResponseCode(),int1);
		log.info("*********batch created*********");
		
	}
	
	@When("Admin sends HTTPS Request and  request Body with invalid endpoint")
	public void admin_sends_https_request_and_request_body_with_invalid_endpoint() throws IOException {
		
	    Program program2 = new Program();
		program2.ProgrmInvalidEndpoint(ProgramModuleBody.PostProgramBody());
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
	}
	
	
}

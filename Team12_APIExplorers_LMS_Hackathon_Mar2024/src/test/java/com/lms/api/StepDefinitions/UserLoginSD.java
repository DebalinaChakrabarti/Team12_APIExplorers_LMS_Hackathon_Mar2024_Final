package com.lms.api.StepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import com.lms.api.RequestBody.UserLoginBody;

import com.lms.api.httpclientrequest.UserLoginRequest;
import com.lms.api.utilities.RestUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;


public class UserLoginSD extends RestUtils{

	UserLoginRequest UserLogin=new UserLoginRequest();
	
	@Given("User send request for the LMS API endPoint")
	public void user_send_request_for_the_lms_api_end_point() {

		log.info("***User sends request with BaseURL***");

	}

	@When("User send post request with valid email id and password")
	public void user_send_post_request_with_valid_email_id_and_password() throws IOException {

		UserLogin.PostRequest(UserLoginBody.PostBody());

	}

	@Then("The user should receive a successful response with status code {int}")
	public void the_user_should_receive_a_successful_response_with_status_code(Integer statuscode) throws IOException {
		Response response = UserLogin.PostRequest(UserLoginBody.PostBody());
		if (statuscode == 200) {

			response.then().assertThat().statusCode(statuscode).log().all();

			log.info("Client registered successfully " + response.getStatusCode());
			log.info("Client registered successfully " + response.getBody().asString());
		} else {
			log.info("Registration failed");
			log.error("Not Found: 404");
		}

	}
//	int responseCode=0;
//	LoginControllerRequest loginRequest=new LoginControllerRequest();
//	
//	@Given("Admin creates request with valid credentials")
//	public void admin_creates_request_with_valid_credentials() {
//		log.info("admin creates POST request to generate token");
//	}
//	
//	@When("Admin calls Post Https method  with valid endpoint")
//	public void admin_calls_post_https_method_with_valid_endpoint() {
//		loginRequest.generateToken();
//		log.info("Post request sent to generate token");
//	}
//
//	@Then("Admin receives {int} created with auto generated token")
//	public void admin_receives_created_with_auto_generated_token(Integer int1) {
//		loginRequest.printtoken();
//		responseCode=loginRequest.getResponseCode();
//		Assert.assertEquals(responseCode, int1);
//		log.info("token generated");
	
}

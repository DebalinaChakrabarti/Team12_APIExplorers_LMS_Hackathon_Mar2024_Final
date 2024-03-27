package com.lms.api.StepDefinitions;

import static io.restassured.RestAssured.baseURI;

import java.io.IOException;

import com.lms.api.httpclientrequest.UserLoginController;
import com.lms.api.utilities.RestUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;

public class UserLoginControllerSD extends RestUtils {

	@Given("User send request for the LMS API endPoint")
	public void user_send_request_for_the_lms_api_end_point() {

		String BaseURI = rb_routes.getString("BaseUrl");

		// manually included static import statement in order to use the baseURI field
		// of RestAssured class
		baseURI = BaseURI;
		log.info("***User sends request with BaseURL***");

	}

	@When("User send post request with valid email id and password")
	public void user_send_post_request_with_valid_email_id_and_password() throws IOException {

		UserLoginController.clientRegister();
		UserLoginPayload.setToken(response.path("token"));
		log.info("********captured access token " + UserLoginPayload.getToken());
		log.info("***Client posted request with valid email and password***");

	}

	@Then("The user should receive a successful response with status code {int}")
	public void the_user_should_receive_a_successful_response_with_status_code(Integer statuscode) {
		if (statuscode == 200) {

			response.then().assertThat().statusCode(statuscode).log().all();

			log.info("Client registered successfully " + response.getStatusCode());
			log.info("Client registered successfully " + response.getBody().asString());
		} else {
			log.info("Registration failed");
			log.error("Not Found: 404");
		}

	}

//	@Then("the response should confirm expected schema")
//	public void the_response_should_confirm_expected_schema() {
//	
//		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("ClientPostJson"));
//	}

	@Given("User send request for the LMS API endpoint")
	public void user_send_request_for_the_lms_api_endpoint() {
	}

	@When("User send post request with invalid email id and password")
	public void user_send_post_request_with_invalid_email_id_and_password() {
	}

	@Then("The user should receive a status code {int}")
	public void the_user_should_receive_a_status_code(Integer int1) {
	}

	@Then("The response body should contain an error message Invalid request body")
	public void the_response_body_should_contain_an_error_message_invalid_request_body() {
	}

}

package com.lms.api.StepDefinitions;

import java.io.IOException;

import com.lms.api.Request.UserLogin;
import com.lms.api.RequestBody.UserLoginBody;
import com.lms.api.utilities.RestUtils;
import static io.restassured.RestAssured.baseURI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class UserLoginSD extends RestUtils {

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

		// UserLoginController.clientRegister();
		UserLogin.PostRequest(UserLoginBody.PostBody());
		
		

	}

	@Then("The user should receive a successful response with status code {int}")
	public void the_user_should_receive_a_successful_response_with_status_code(Integer statuscode) throws IOException {
		// Response response=UserLoginController.clientRegister();
		// Response response=UserLogin.PostRequest();
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

	@Given("Admin creates request with valid credentials")
	public void admin_creates_request_with_valid_credentials() throws IOException {
		UserLogin.PostRequest(UserLoginBody.PostBody());
	}

	@When("Admin calls Post Https method  with invalid endpoint")
	public void admin_calls_post_https_method_with_invalid_endpoint() throws IOException {
		UserLogin.PostInvalidEndpoint(UserLoginBody.PostBody());
	}

	@Then("Admin receives {int} unauthorized")
	public void admin_receives_unauthorized(Integer statuscode) throws IOException {
		Response response = UserLogin.PostInvalidEndpoint(UserLoginBody.PostBody());
		if (statuscode == 401) {

			response.then().assertThat().statusCode(statuscode).log().all();

			log.info("***Invalid Endpoint*** " + response.getStatusCode());
			log.info("***Invalid Endpoint*** " + response.getBody().asString());
		} else {
			log.info("Registration failed");
			log.error("Unauthorized : 401");
		}

	}

	/*
	 * @Given("Admin creates request with invalid credentials") public void
	 * admin_creates_request_with_invalid_credentials() { // Write code here that
	 * turns the phrase above into concrete actions throw new
	 * io.cucumber.java.PendingException(); }
	 * 
	 * @When("Admin calls Post Https method  with valid endpoint") public void
	 * admin_calls_post_https_method_with_valid_endpoint() { // Write code here that
	 * turns the phrase above into concrete actions throw new
	 * io.cucumber.java.PendingException(); }
	 * 
	 * @Then("Admin receives {int} Bad request") public void
	 * admin_receives_bad_request(Integer int1) { // Write code here that turns the
	 * phrase above into concrete actions throw new
	 * io.cucumber.java.PendingException(); }
	 */

}

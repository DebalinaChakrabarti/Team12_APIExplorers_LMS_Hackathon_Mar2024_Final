package com.lms.api.StepDefinitions;

import org.testng.Assert;

import com.lms.api.httpclientrequest.LoginControllerRequest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class UserLoginControllerSD {

	int responseCode=0;
	LoginControllerRequest loginRequest=new LoginControllerRequest();
	
	@Given("Admin creates request with valid credentials")
	public void admin_creates_request_with_valid_credentials() {
		//add logs
	}
	
	@When("Admin calls Post Https method  with valid endpoint")
	public void admin_calls_post_https_method_with_valid_endpoint() {
		loginRequest.generateToken();
	}

	@Then("Admin receives {int} created with auto generated token")
	public void admin_receives_created_with_auto_generated_token(Integer int1) {
		loginRequest.printtoken();
		responseCode=loginRequest.getResponseCode();
		Assert.assertEquals(responseCode, int1);
	}
}

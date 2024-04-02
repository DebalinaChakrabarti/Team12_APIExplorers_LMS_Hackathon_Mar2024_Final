package com.lms.api.StepDefinitions;

import static io.restassured.RestAssured.baseURI;

import org.testng.Assert;

import com.lms.api.Request.UserLoginLogout;
import com.lms.api.utilities.RestUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class UserLogoutSD extends RestUtils {

	@Given("Admin creates request")
	public void admin_creates_request() {
		String BaseURI = rb_routes.getString("BaseUrl");

		baseURI = BaseURI;
		log.info("***User sends request with BaseURL***");
	}

	@When("Admin calls Get Https method with valid endpoint")
	public void admin_calls_get_https_method_with_valid_endpoint() {
	  UserLoginLogout.getLogout();
	    log.info("****Admin Logged Out Successfully****");
	    System.out.println("****Admin Logged Out Successfully****");
	    
	}

	@Then("Admin receives {int} ok  and response with {string}")
	public void admin_receives_ok_and_response_with(Integer int1, String string) {
		
	    Assert.assertEquals(response.getStatusCode(), int1);
	    Assert.assertEquals(response.getBody().asString(), string);
	    log.info("*****Status code from response****"+response.getStatusCode());
	    System.out.println("*****Status code from response****"+response.getStatusCode());
	    System.out.println("*****Status code from response****"+response.getBody().asString());
	    log.info("*****Status code from response****"+response.getBody().asString());
	}

	@When("Admin calls Get Https method withinvalid endpoint")
	public void admin_calls_get_https_method_withinvalid_endpoint() {
	  UserLoginLogout.getLogoutWithInvalidEndpoint();
	  log.info("****Admin trying to get logout with invalid endpoint****");
	    System.out.println("****Admin trying to get logout with invalid endpoint****");
	    
	}

	@Then("Admin receives {int} Not found")
	public void admin_receives_not_found(Integer int1) {
		Response response=UserLoginLogout.getLogoutWithInvalidEndpoint();
		Assert.assertEquals(response.getStatusCode(), int1);
		log.info("***401 Unauthorized****");
	}

	@Then("Admin receives {int}  unauthorized")
	public void admin_receives_unauthorized(Integer int1) {
		Response response=UserLoginLogout.getLogoutWithNoAuth();
		Assert.assertEquals(response.statusCode(), int1);
		log.info("***Admin sent get logout request without giving authorization***");
		log.info("**401 Unauthorized**");
	   	}



}

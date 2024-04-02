package com.lms.api.StepDefinitions;

import static io.restassured.RestAssured.baseURI;
import java.io.IOException;
import org.testng.Assert;
import com.lms.api.Request.UserLoginLogout;
import com.lms.api.RequestBody.UserLoginBody;
import com.lms.api.utilities.RestUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserLoginSD extends RestUtils {
	@Given("Admin creates request with valid credentials")
	public void admin_creates_request_with_valid_credentials() {
		String BaseURI = rb_routes.getString("BaseUrl");
		baseURI = BaseURI;
		log.info("***User sends request with BaseURL***");

	}

	@When("Admin calls Post Https method  with valid endpoint")
	public void admin_calls_post_https_method_with_valid_endpoint() throws IOException {
		log.info("Admin calls post request method with valid endpoint");
	}

	@Then("Admin receives {int} created with auto generated token")
	public void admin_receives_created_with_auto_generated_token(Integer int1) throws IOException {
		response = UserLoginLogout.PostRequest(UserLoginBody.PostBody());
		Assert.assertEquals(response.statusCode(), int1);
		Assert.assertTrue(response.getBody().jsonPath().get("token").toString().length() > 0,
				"Token is not present or empty");
		token = response.getBody().jsonPath().get("token");
		System.out.println("****Generated token and userId are*** " + token );
		log.info("****Generated token and userId are*** " + token );
		log.info("***Admin Logged in Successfully");

	}

	@When("Admin calls Post Https method  with invalid endpoint")
	public void admin_calls_post_https_method_with_invalid_endpoint() throws IOException {
		
		log.info("**Admin called post method with invalid end point**");
		System.out.println("**Admin called post method with invalid end point**");
	}

	@Then("Admin receives {int} unauthorized")
	public void admin_receives_unauthorized(Integer int1) throws IOException {
		response = UserLoginLogout.PostInvalidEndpoint(UserLoginBody.PostBody());
		Assert.assertEquals(response.statusCode(), int1);
		log.error("Unauthorized");
		log.info("***401 Unauthorized");
		System.out.println("*** 401 Unauthorized***");
	}

	@Given("Admin creates request with invalid credentials")
	public void admin_creates_request_with_invalid_credentials() throws IOException {
		//UserLoginLogout.PostRequest(UserLoginBody.PostInvalidCredentials());
		
		log.info("**Admin created request with invalid credentails**");
		System.out.println("**Admin created request with invalid credentails**");
	}

	@Then("Admin receives {int} Bad request")
	public void admin_receives_bad_request(Integer int1) throws IOException {
		//response = UserLoginLogout.PostRequest(UserLoginBody.PostInvalidCredentials());
		response = UserLoginLogout.PostInvalidCredentials();
		Assert.assertEquals(response.statusCode(), int1);
		log.info("***Bad credentials***");
		log.info("****success false****");
		


	}
}

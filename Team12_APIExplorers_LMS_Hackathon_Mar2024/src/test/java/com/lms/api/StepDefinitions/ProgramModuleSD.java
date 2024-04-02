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

	//Post Program
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
	
	//Post request without Authorization
	@When("Admin sends Post Request and request Body with endpoint without Authorization")
	public void admin_sends_post_request_and_request_body_with_endpoint_without_authorization()throws IOException {
		program.PostwithoutAuthRequest(ProgramModuleBody.PostProgramBody());
	}

	@Then("Admin receives {int} Unauthorized error for post")
	public void admin_receives_unauthorized_error_for_post(Integer ExpectedStatuscode) {
		log.info("creat program without auth response code is "+program.getCreatewoauthResponseCode());
		Assert.assertEquals(program.getCreatewoauthResponseCode(),ExpectedStatuscode);
		Assert.assertEquals(program.getCreatewoauthResponsemess(),"Unauthorized");
		
	}
	
	//Post using Invalid Endpoint
	@When("Admin sends HTTPS Request and  request Body with invalid endpoint")
	public void admin_sends_https_request_and_request_body_with_invalid_endpoint() throws IOException {
		program.PostInvalidEPRequest(ProgramModuleBody.PostProgramBody());
	}

	@Then("Admin receives {int} not found  Status with message and boolean success details")
	public void admin_receives_not_found_status_with_message_and_boolean_success_details(Integer ExpectedStatuscode) {
		log.info("Created program with invalid response code is "+program.getpgInvalidEPResponseCode());
		Assert.assertEquals(program.getpgInvalidEPResponseCode(),ExpectedStatuscode);
	}
	
	//Post with Existing program name
	@When("Admin sends Post Request with exsisting prgm name and  request Body with endpoint")
	public void admin_sends_post_request_with_exsisting_prgm_name_and_request_body_with_endpoint() throws IOException {
		program.PostRequestExsistingPName(ProgramModuleBody.PostByExistProgramNameBody());
	}
	@Then("Admin receives {int} Bad Request Status with message and boolean success details")
	public void admin_receives_bad_request_status_with_message_and_boolean_success_details(Integer ExpectedStatuscode) {
		log.info("created program with existing Prgmname response code is "+program.getExistPNameResponseCode());
		Assert.assertEquals(program.getExistPNameResponseCode(),ExpectedStatuscode);
	}
	
	//Post with missing Pgrm name in body

	@When("Admin sends Post Request and missing Pgm Name in request Body with endpoint")
	public void admin_sends_post_request_and_missing_pgm_name_in_request_body_with_endpoint() throws IOException  {
		program.postmissingpgname(ProgramModuleBody.PostByMissingProgramNameBody());
	}

	@Then("Admin receives {int} Bad Request Status for missing value")
	public void admin_receives_bad_request_status_for_missing_value(Integer ExpectedStatuscode) { 
		log.info("created program with existing Prgmname response code is "+program.getMissingPNameResponseCode());
		Assert.assertEquals(program.getMissingPNameResponseCode(),ExpectedStatuscode);
	}
	
	//Post incorrect Method
	@When("Admin sends Get Request instead of post and  request Body with endpoint")
	public void admin_sends_get_request_instead_of_post_and_request_body_with_endpoint()throws IOException {
		program.postPGIncorrectMethod(ProgramModuleBody.PostProgramBody());
	}

	@Then("Admin receives {int} Method Not Allowed")
	public void admin_receives_method_not_allowed(Integer ExpectedStatuscode) {
		log.info("created program with existing Prgmname response code is "+program.getPGIncorrectMethodResponseCode());
		Assert.assertEquals(program.getPGIncorrectMethodResponseCode(),ExpectedStatuscode);
	}
	
	//Post PGname starting with number
	@When("Admin sends Post Request and Pgm Name starting with Number in request Body with endpoint")
	public void admin_sends_post_request_and_pgm_name_starting_with_number_in_request_body_with_endpoint()throws IOException  {
	    program.postPGnamenum(ProgramModuleBody.PostByProgramNameNumBody());
	}

	@Then("Admin receives {int} Bad Request Status for Pgm name starting with number")
	public void admin_receives_bad_request_status_for_pgm_name_starting_with_number(Integer ExpectedStatuscode) {
		log.info("created program with existing Prgmname response code is "+program.getPGNameNumResponseCode());
		Assert.assertEquals(program.getPGNameNumResponseCode(),ExpectedStatuscode);
	    
	}

	//Post with missing additional field
	@When("Admin sends Post Request with request Body with missing additional field with endpoint")
	public void admin_sends_post_request_with_request_body_with_missing_additional_field_with_endpoint() {
	    try {
			program.postmissingaddReqbody(ProgramModuleBody.PostBymissingadditionalBody());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("Admin receives {int} ok for missing additional fields in program post request body")
	public void admin_receives_ok_for_missing_additional_fields_in_program_post_request_body(Integer ExpectedStatuscode) {
		log.info("created program with existing Prgmname response code is "+program.getMissaddReqbodyResponseCode());
		Assert.assertEquals(program.getMissaddReqbodyResponseCode(),ExpectedStatuscode);
	}
	
	
	//Get All Programs
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
		log.info("GET all programs response code is "+program.getAllprgmResponseCode());
		Assert.assertEquals(program.getAllprgmResponseCode(),ExpectedStatuscode);
		log.info("*********Get ALL Programs *********");
	}
	
	//Get all programs without auth
	@When("Admin sends Get Request and request Body with endpoint without Authorization")
	public void admin_sends_get_request_and_request_body_with_endpoint_without_authorization() {
		program.getAllProgramswOAuth();
	}

	@Then("Admin receives {int} Unauthorized error for put")
	public void admin_receives_unauthorized_error_for_put(Integer ExpectedStatuscode) {
		log.info("GET all programs without auth response code is "+program.getAllprgmwoauthResponseCode());
		Assert.assertEquals(program.getAllprgmwoauthResponseCode(),ExpectedStatuscode); 
	}
	
	//Get with invalid Endpoint
	@When("Admin sends Get Request and  request Body with invalid endpoint")
	public void admin_sends_get_request_and_request_body_with_invalid_endpoint() {
		program.getAllInvalidEPPrograms();
	}

	@Then("Admin receives {int} not found Status for GET with message and boolean success details")
	public void admin_receives_not_found_status_for_get_with_message_and_boolean_success_details(Integer ExpectedStatuscode) {
		log.info("GET all programs response code is "+program.getAllprgmInvalidEPResponseCode());
		Assert.assertEquals(program.getAllprgmInvalidEPResponseCode(),ExpectedStatuscode);
		log.info("*********Get ALL Programs Inavlid EP *********");
	}
	
	//Get using invalid method
	@When("Admin sends Post Request instead of get and  request Body with endpoint")
	public void admin_sends_post_request_instead_of_get_and_request_body_with_endpoint() {
		program.getAllInvalidMetPrograms();
	}

	@Then("Admin receives {int} Method Not Allowed message")
	public void admin_receives_method_not_allowed_message(Integer ExpectedStatuscode) {
		log.info("GET all programs response code is "+program.getAllprgmInvalidMeResponseCode());
		Assert.assertEquals(program.getAllprgmInvalidMeResponseCode(),ExpectedStatuscode);
		log.info("*********Get ALL Programs Inavlid EP *********");
	}
	
	//Get Using Pgm ID
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
	
	//Get using pgm by pgm id without Auth
	@When("Admin sends Get Request by pgm id and request Body with endpoint without Authorization")
	public void admin_sends_get_request_by_pgm_id_and_request_body_with_endpoint_without_authorization() {
		program.getPrgmbyProgramIdWoAuth();
	}

	@Then("Admin receives {int} Unauthorized error for put by pgm id")
	public void admin_receives_unauthorized_error_for_put_by_pgm_id(Integer ExpectedStatuscode) {
		log.info("GET program using programId response code is "+program.getPgrmByIdwoauthResponseCode());
		Assert.assertEquals(program.getPgrmByIdwoauthResponseCode(),ExpectedStatuscode);
	}
	
	//Get Using invalid Pgrm Id
	@When("Admin sends Get Request with invlaid ID and endpoint")
	public void admin_sends_get_request_with_invlaid_id_and_endpoint() {
	    program.getPrgmbyInvalidProgramId();
	}

	@Then("Admin receives {int} Not Found Status for invalid PG Id with message and boolean success details")
	public void admin_receives_not_found_status_for_invalid_pg_id_with_message_and_boolean_success_details(Integer ExpectedStatuscode) {
		log.info("GET program using by Invalid programId response code is "+program.getPgrmByInvalidIdResponseCode());
		Assert.assertEquals(program.getPgrmByInvalidIdResponseCode(),ExpectedStatuscode);
		log.info("*********Get Program by Invalid Program ID *********");
	}
	
	//Get request using invalid baseurl
	@Given("Admin creates GET Request for the LMS API	with invalid baseURI")
	public void admin_creates_get_request_for_the_lms_api_with_invalid_base_uri() {
		String InvalidBaseURI = rb_routes.getString("InvalidBaseURL");
		baseURI = InvalidBaseURI;
		log.info("***User sends get request with BaseURL***");
	}

	@When("Admin sends Get Request Request with endpoint")
	public void admin_sends_get_request_request_with_endpoint() {
	    program.getPgrmbyinvalidbaseurl();
	}

	@Then("Admin receives {int} Not Found Status for invalid baseurl with message and boolean success details")
	public void admin_receives_not_found_status_for_invalid_baseurl_with_message_and_boolean_success_details(Integer ExpectedStatuscode) {
		log.info("GET program using programId invalid baseurl response code is "+program.getPgrmByInvalidBaseResponseCode());
		Assert.assertEquals(program.getPgrmByInvalidBaseResponseCode(),ExpectedStatuscode);
	}
	
	//Get all prgms with invalid endpoint
	@When("Admin sends Get Request with pgm Id and  request Body with invalid endpoint")
	public void admin_sends_get_request_with_pgm_id_and_request_body_with_invalid_endpoint() {
	    program.getpgmIdinvalidEP();
	}

	@Then("Admin receives {int} Not Found Status for Get with Pgm Id with message and boolean success details")
	public void admin_receives_not_found_status_for_get_with_pgm_id_with_message_and_boolean_success_details(Integer ExpectedStatuscode) {
	    log.info("GET program using programId response code is "+program.getPgrmByInvalidEPResponseCode());
		Assert.assertEquals(program.getPgrmByInvalidEPResponseCode(),ExpectedStatuscode);
	}
	
	//Get All programs with users
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

	//Get all pgm with users with invalid EP
	
	@When("Admin sends Get Request for all users with request Body with invalid endpoint")
	public void admin_sends_get_request_for_all_users_with_request_body_with_invalid_endpoint() {
	    program.getAllPgmUsersInavlidEP();
	}

	@Then("Admin receives {int} Not Found Status for Get w for all users with message and boolean success details")
	public void admin_receives_not_found_status_for_get_w_for_all_users_with_message_and_boolean_success_details(Integer ExpectedStatuscode) {
		log.info("GET program for all users invalid EP response code is "+program.getAllprgmuserInvalidEPIResponseCode());
		Assert.assertEquals(program.getAllprgmuserInvalidEPIResponseCode(),ExpectedStatuscode);
	}
	
	//Get all users invalid method
	@When("Admin sends post all users Request instead of get with endpoint")
	public void admin_sends_post_all_users_request_instead_of_get_with_endpoint() {
	    program.getAllPgmUsersInavlidMethod();
	}

	@Then("Admin receives {int} Method Not Allowed for get all users invalid method")
	public void admin_receives_method_not_allowed_for_get_all_users_invalid_method(Integer ExpectedStatuscode) {
		log.info("GET program for all users Invalid method response code is "+program.getAllprgmuserInvalidMetResponseCode());
		Assert.assertEquals(program.getAllprgmuserInvalidMetResponseCode(),ExpectedStatuscode);
	}
	
	//Get all users without auth
	@When("Admin sends HTTPS Request with endpoint without auth")
	public void admin_sends_https_request_with_endpoint_without_auth() {
		program.getAllProgramswithUserswoauth();  
	}

	@Then("Admin receives {int} Status with response body as Unauthorized")
	public void admin_receives_status_with_response_body_as_unauthorized(Integer ExpectedStatuscode) {
		log.info("GET program for all users without auth response code is "+program.getAllprgmwithuserswoauthResponseCode());
		Assert.assertEquals(program.getAllprgmwithuserswoauthResponseCode(),ExpectedStatuscode);
		Assert.assertEquals(program.getAllprgmwithuserswoauthResponsemess(),"Unauthorized");
	}
	
	//Update using Prgm Id
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
	
	//Update using invalid pgm id

	@When("Admin sends Put Request with invalid prgm Id and valid endpoint")
	public void admin_sends_put_request_with_invalid_prgm_id_and_valid_endpoint() throws IOException {
	    program.updateProgramInvalidPgmID(ProgramModuleBody.UpdateByIDProgramBody());
	}
	
	@Then("Admin receives {int} Not Found Status for update pgm invalid pgm id with message and boolean success details")
	public void admin_receives_not_found_status_for_update_pgm_invalid_pgm_id_with_message_and_boolean_success_details(Integer ExpectedStatuscode) {
		log.info("Update program with invalid program Id response code is "+program.UpdatePrgrmInvalidIDResponseCode());
		Assert.assertEquals(program.UpdatePrgrmInvalidIDResponseCode(),ExpectedStatuscode);
	}
	

	//Update with missing fields in request body

	@When("Admin sends Put Request missing mandate field and valid endpoint")
	public void admin_sends_put_request_missing_mandate_field_and_valid_endpoint() throws IOException {
		program.updatepgmwithoutbody(ProgramModuleBody.UpdateByMissingrequestBody());
	}

	@Then("Admin receives {int} Bad Request Status for put for missing mandate field with message and boolean success details")
	public void admin_receives_bad_request_status_for_put_for_missing_mandate_field_with_message_and_boolean_success_details(Integer ExpectedStatuscode) {
		log.info("Update program without requet body response code is "+program.UpdatePrgrmWobodyResponseCode());
		Assert.assertEquals(program.UpdatePrgrmWobodyResponseCode(),ExpectedStatuscode);
	}
	
	//Update with invalid baseurl
	@Given("Admin creates PUT Request for the LMS API endpoint with request Body with mandatory , additional  fields with invalid baseurl")
	public void admin_creates_put_request_for_the_lms_api_endpoint_with_request_body_with_mandatory_additional_fields_with_invalid_baseurl() {
		String InvalidBaseURI = rb_routes.getString("InvalidBaseURL");
		baseURI = InvalidBaseURI;
		log.info("***User sends put request with invalid BaseURL***");
	}

	@When("Admin sends Put Request with invalid baseurl valid endpoint")
	public void admin_sends_put_request_with_invalid_baseurl_valid_endpoint() throws IOException {
	    program.updateProgramByIDinvalidbase(ProgramModuleBody.UpdateByIDProgramBody());
	}

	@Then("Admin receives {int} Not Found Status for put invalid baseurl with message and boolean success details")
	public void admin_receives_not_found_status_for_put_invalid_baseurl_with_message_and_boolean_success_details(Integer ExpectedStatuscode) {
		log.info("Update program with invalid baseurl response code is "+program.UpdatePrgrminvalidbaseResponseCode());
		Assert.assertEquals(program.UpdatePrgrminvalidbaseResponseCode(),ExpectedStatuscode);
	}
	
	//Update using invalid method
	@When("Admin sends get request instead of put Request with valid endpoint")
	public void admin_sends_get_request_instead_of_put_request_with_valid_endpoint()throws IOException {
	    program.updatepgminvalidmethod(ProgramModuleBody.UpdateByIDProgramBody());
	}

	@Then("Admin receives {int} Method Not Allowed for using get instead of put")
	public void admin_receives_method_not_allowed_for_using_get_instead_of_put(Integer ExpectedStatuscode) {
		log.info("Update program with invalid method response code is "+program.UpdatePrgrminvalidmetResponseCode());
		Assert.assertEquals(program.UpdatePrgrminvalidmetResponseCode(),ExpectedStatuscode);
	}
	
	//Update PRGM using PRGM iD without auth
	@When("Admin sends Put Request with endpoint without auth")
	public void admin_sends_put_request_with_endpoint_without_auth() throws IOException {
	    program.updateprgnwithoutauth(ProgramModuleBody.UpdateByIDProgramBody());
	}

	@Then("Admin receives {int} Status with response body as Unauthorized for put by pgm id")
	public void admin_receives_status_with_response_body_as_unauthorized_for_put_by_pgm_id(Integer ExpectedStatuscode) {
		log.info("GET program for all users without auth response code is "+program.getAllprgmwithuserswoauthResponseCode());
		Assert.assertEquals(program.UpdatepgrmidwoauthResponseCode(),ExpectedStatuscode);
		Assert.assertEquals(program.UpdatepgrmidwoauthResponsemess(),"Unauthorized");	}
	
	//Update using Prgm Name
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
	
	//Update with invalid pg name
	@When("Admin sends Put Request with invalid Program name with valid endpoint")
	public void admin_sends_put_request_with_invalid_program_name_with_valid_endpoint()throws IOException {
	    program.updateinvalidprgmname(ProgramModuleBody.UpdateByProgramNameBody());	
	    }

	@Then("Admin receives {int} Not Found Status for put with invalid pg namewith message and boolean success details")
	public void admin_receives_not_found_status_for_put_with_invalid_pg_namewith_message_and_boolean_success_details(Integer ExpectedStatuscode) {
		log.info("Update program with program name response code is "+program.UpdateinvalidPrgrmnameResponseCode());
		Assert.assertEquals(program.UpdateinvalidPrgrmnameResponseCode(),ExpectedStatuscode);
	}
	
	//Update by pgn name using missing mandate field
	@Given("Admin creates PUT Request for the LMS API with missing mandatory fields")
	public void admin_creates_put_request_for_the_lms_api_with_missing_mandatory_fields() {
		String BaseURI = rb_routes.getString("BaseUrl");
		baseURI = BaseURI;
		log.info("***User sends request with BaseURL***");
	}

	@When("Admin sends Put Request with valid prgom name with valid endpoint")
	public void admin_sends_put_request_with_valid_prgom_name_with_valid_endpoint() throws IOException {
		 program.updatemissingfieldprgmname(ProgramModuleBody.UpdateByMissingrequestBody());	
	}

	@Then("Admin receives {int} Bad Request Status for missing field with message and boolean success details")
	public void admin_receives_bad_request_status_for_missing_field_with_message_and_boolean_success_details(Integer ExpectedStatuscode) {
	    log.info("Update program with missing field with program name response code is "+program.UpdatemissfieldpgnameResponseCode());
		Assert.assertEquals(program.UpdatemissfieldpgnameResponseCode(),ExpectedStatuscode);
	}
	
	//Update with pgnname starting with number
	@When("Admin sends Put Request and Pgm Name starting with Number in request Body with endpoint")
	public void admin_sends_put_request_and_pgm_name_starting_with_number_in_request_body_with_endpoint()throws IOException {
		 program.upadtePGnamenum(ProgramModuleBody.PostByProgramNameNumBody());
	}

	@Then("Admin receives {int} Bad Request Status for put Pgm name starting with number")
	public void admin_receives_bad_request_status_for_put_pgm_name_starting_with_number(Integer ExpectedStatuscode) {
		log.info("Update program with program name as num response code is "+program.UpdatenumpgnameResponseCode());
		Assert.assertEquals(program.UpdatenumpgnameResponseCode(),ExpectedStatuscode);
	}

	//Update with prgm description starting with num
	@When("Admin sends Put Request and Pgm Descrip starting with Number in request Body with endpoint")
	public void admin_sends_put_request_and_pgm_descrip_starting_with_number_in_request_body_with_endpoint()throws IOException {
	    program.updatePgdesnum(ProgramModuleBody.UpdateByPgDesnumrequestBody());
	}

	@Then("Admin receives {int} Bad Request Status for put Pgm descrip starting with number")
	public void admin_receives_bad_request_status_for_put_pgm_descrip_starting_with_number(Integer ExpectedStatuscode) {
		log.info("Update program with program descrip as num response code is "+program.UpdatenumpgdesResponseCode());
		Assert.assertEquals(program.UpdatenumpgdesResponseCode(),ExpectedStatuscode);
	}
	
	//Update prgm status
	@When("Admin sends Put Request for status change with valid endpoint")
	public void admin_sends_put_request_for_status_change_with_valid_endpoint() throws IOException {
	    program.updateprgmstatus(ProgramModuleBody.UpdateByProgramNamestatusBody());
	}

	@Then("Admin receives {int} OK Status with updated prgm status value in response body.")
	public void admin_receives_ok_status_with_updated_prgm_status_value_in_response_body(Integer ExpectedStatuscode) {
		log.info("Update program status response code is "+program.UpdatestatusResponseCode());
		Assert.assertEquals(program.UpdatestatusResponseCode(),ExpectedStatuscode);
	}
	
	//Delete Using Pgm Name
	@Given("Admin creates DELETE Request for the LMS API endpoint  and  valid programName")
	public void admin_creates_delete_request_for_the_lms_api_endpoint_and_valid_program_name() {
		String BaseURI = rb_routes.getString("BaseUrl");
		baseURI = BaseURI;
		log.info("***User sends delete request with BaseURL***");
	}

	@When("Admin sends Delete by ProgramName Request with endpoint")
	public void admin_sends_delete_by_program_name_request_with_endpoint() {
	    program.deleteProgramByName();
	}

	@Then("Admin receives {int} Ok status with message")
	public void admin_receives_ok_status_with_message(Integer ExpectedStatuscode) {
		log.info("Delete program with program name response code is "+program.deletePgmresponseCode());
		Assert.assertEquals(program.deletePgmresponseCode(),ExpectedStatuscode);
		log.info("*********Deelete Program By Program Id *********");
	}
	
	//Delete usiong invalid pgrm name
	@Given("Admin creates DELETE Request for the LMS API endpoint  and invalid programName")
	public void admin_creates_delete_request_for_the_lms_api_endpoint_and_invalid_program_name() {
		String BaseURI = rb_routes.getString("BaseUrl");
		baseURI = BaseURI;
		log.info("***User sends delete request for invalid pgrn name with BaseURL***");
	}

	@When("Admin sends Delete by invalid ProgramName Request with endpoint")
	public void admin_sends_delete_by_invalid_program_name_request_with_endpoint() {
		program.deletePgrminvalidname();
	}

	@Then("Admin receives {int} Not Found Status for delete invalid pgnamewith message and boolean success details")
	public void admin_receives_not_found_status_for_delete_invalid_pgnamewith_message_and_boolean_success_details(Integer ExpectedStatuscode) {
		log.info("Delete program with program name response code is "+program.deletePgmInvalidNameresponseCode());
		Assert.assertEquals(program.deletePgmInvalidNameresponseCode(),ExpectedStatuscode);
	}
	
	//Delete by pgrm name without auth
	@When("Admin sends delete Request by program name with endpoint without auth")
	public void admin_sends_delete_request_by_program_name_with_endpoint_without_auth() {
		program.deleteProgramByNamewoAuth();
	}

	@Then("Admin receives {int} Status with response body as Unauthorized for delete by pgm name")
	public void admin_receives_status_with_response_body_as_unauthorized_for_delete_by_pgm_name(Integer ExpectedStatuscode) {
		log.info("GET program for all users without auth response code is "+program.getAllprgmwithuserswoauthResponseCode());
		Assert.assertEquals(program.DelpgrmnamewoauthResponseCode(),ExpectedStatuscode);
		Assert.assertEquals(program.DelpgrmnamewoauthResponseMess(),"Unauthorized");	
	}

	//Delete Using Pgm Id
	@Given("Admin creates DELETE Request for the LMS API endpoint  and  valid program ID")
	public void admin_creates_delete_request_for_the_lms_api_endpoint_and_valid_program_id() {
		String BaseURI = rb_routes.getString("BaseUrl");
		baseURI = BaseURI;
		log.info("***User sends request with BaseURL***");
	}

	@When("Admin sends Delete Request By Program Name with endpoint")
	public void admin_sends_delete_request_by_program_name_with_endpoint() {
	    program.deleteProgramById();
	}

	@Then("Admin receives {int} Ok status with message for delete by program name")
	public void admin_receives_ok_status_with_message_for_delete_by_program_name(Integer ExpectedStatuscode) {
		log.info("Delete program with program Id response code is "+program.deletePgmNameresponseCode());
		Assert.assertEquals(program.deletePgmNameresponseCode(),ExpectedStatuscode);
		log.info("*********Deelete Program By Program Id *********");
	}
	
	@Given("Admin creates DELETE Request for the LMS API endpoint  and invalid programId")
	public void admin_creates_delete_request_for_the_lms_api_endpoint_and_invalid_program_id() {
		String BaseURI = rb_routes.getString("BaseUrl");
		baseURI = BaseURI;
		log.info("***User sends request with BaseURL***");
	}

	@When("Admin sends Delete by invalid ProgramID Request with endpoint")
	public void admin_sends_delete_by_invalid_program_id_request_with_endpoint() {
		 program.deleteProgramByinvalidId();
	}

	@Then("Admin receives {int} Not Found Status for delete invalid pgid with message and boolean success details")
	public void admin_receives_not_found_status_for_delete_invalid_pgid_with_message_and_boolean_success_details(Integer ExpectedStatuscode) {
		log.info("Delete program with program Id response code is "+program.deletePgminvalidIdresponseCode());
		Assert.assertEquals(program.deletePgminvalidIdresponseCode(),ExpectedStatuscode);
	}
	

	@When("Admin sends delete Request by program id with endpoint without auth")
	public void admin_sends_delete_request_by_program_id_with_endpoint_without_auth() {
	    program.deleteProgramByIDwoAuth();
	}
	
	@Then("Admin receives {int} Status with response body as Unauthorized for delete by pgm id")
	public void admin_receives_status_with_response_body_as_unauthorized_for_delete_by_pgm_id(Integer ExpectedStatuscode) {
		log.info("GET program for all users without auth response code is "+program.getAllprgmwithuserswoauthResponseCode());
		Assert.assertEquals(program.DelpgrmidwoauthResponseCode(),ExpectedStatuscode);
		Assert.assertEquals(program.DelpgrmidwoauthResponsemess(),"Unauthorized");	
	}
}

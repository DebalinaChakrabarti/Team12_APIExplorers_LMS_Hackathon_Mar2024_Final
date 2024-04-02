package com.lms.api.Request;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.json.JSONObject;

import com.lms.api.Endpoints.UserModuleEndpoints;
import com.lms.api.Payload.UpdateAdminRoleIdPayload;
import com.lms.api.Payload.UpdateRoleProgramBatchStatusPayload;
import com.lms.api.Payload.UserRoleProgramBatchesPayload;
import com.lms.api.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserModule extends RestUtils {

	// Post Request

	@SuppressWarnings("unchecked")
	public Response userModulePostRequest() throws IOException {

		UserModulePayload.setUserComments(xlutils.getCellData("UserModule", 1, 0));
		UserModulePayload.setUserEduPg(xlutils.getCellData("UserModule", 1, 1));
		UserModulePayload.setUserEduUg(xlutils.getCellData("UserModule", 1, 2));
		UserModulePayload.setUserFirstName(xlutils.getCellData("UserModule", 1, 3));
		UserModulePayload.setUserLastName(xlutils.getCellData("UserModule", 1, 4));
		UserModulePayload.setUserLinkedinUrl(xlutils.getCellData("UserModule", 1, 5));
		UserModulePayload.setUserLocation(xlutils.getCellData("UserModule", 1, 6));
		UserLoginUserModulePayload.setLoginStatus(xlutils.getCellData("UserModule", 1, 7));
		UserLoginUserModulePayload.setPassword(xlutils.getCellData("UserModule", 1, 8));
		// UserLoginUserModulePayload.setUserLoginEmail(xlutils.getCellData("UserModule",
		// 4, 9));
		log.info("****receiving emailid from method that generates unique and random emailid****");
		UserLoginUserModulePayload.setUserLoginEmail(getUniqueEmail());
		UserModulePayload.setUserLogin(UserLoginUserModulePayload);
		UserModulePayload.setUserMiddleName(xlutils.getCellData("UserModule", 1, 10));
		// UserModulePayload.setUserPhoneNumber(Long.parseLong(xlutils.getCellData("UserModule",
		// 4, 11)));
		log.info("****receiving phone number from method that generates random phonenumber****");
		UserModulePayload.setUserPhoneNumber(getUniquePhoneNumber());
		UserRoleMap_UserModulePayload.setRoleId(xlutils.getCellData("UserModule", 1, 12));
		UserRoleMap_UserModulePayload.setUserRoleStatus(xlutils.getCellData("UserModule", 1, 13));
		List<com.lms.api.Payload.UserRoleMap_UserModulePayload> userRoleMaps = new ArrayList<>();
		userRoleMaps.add(UserRoleMap_UserModulePayload);
		UserModulePayload.setUserRoleMaps(userRoleMaps);
		UserModulePayload.setUserTimeZone(xlutils.getCellData("UserModule", 1, 14));
		UserModulePayload.setUserVisaStatus(xlutils.getCellData("UserModule", 1, 15));

		RequestSpecification request = RestAssured.given().baseUri(rb_routes.getString("BaseUrl"))
				.body(UserModulePayload).header("Authorization", "Bearer " + token);
		request.contentType("application/json");

		request.then().log().all();

		response = request.when().post(UserModuleEndpoints.endpoint.PostUserWithRole.getPath());
		
		response.then().log().all();
		userId = response.getBody().jsonPath().get("userId");
		roleId=xlutils.getCellData("UserModule", 1, 12);
		return response;

	}

	public long getUniquePhoneNumber() {
		Random random = new Random();
		long min = 1000000000L; // Smallest 10-digit number
		long max = 9999999999L; // Largest 10-digit number

		long randomLong = min + ((long) (random.nextDouble() * (max - min + 1)));

		return randomLong;
	}

	public String getUniqueEmail() {

		java.util.Random random = new java.util.Random();
		int random_int = random.nextInt(400);
		String randomEmail = "sudha" + random_int + "@gmail.com";
		return randomEmail;
	}

	public Response getAllRoles() {
		RequestSpecification request = RestAssured.given().baseUri(rb_routes.getString("BaseUrl"))
				.header("Authorization", "Bearer " + token);
		request.contentType("application/json");
		request.then().log().all();

		response = request.when().get(UserModuleEndpoints.endpoint.GetAllRoles.getPath());

		response.then().log().all();

		return response;
	}

	public Response getAllAdmins() {
		RequestSpecification request = RestAssured.given().baseUri(rb_routes.getString("BaseUrl"))
				.header("Authorization", "Bearer " + token);
		request.contentType("application/json");
		request.then().log().all();

		//roleId = "R01";

		response = request.when().get(UserModuleEndpoints.endpoint.GetAllAdmins.getPath() + roleId);
		response.then().log().all();

		return response;
	}

	public Response getInfoByAdminId() {
		RequestSpecification request = RestAssured.given().baseUri(rb_routes.getString("BaseUrl"))
				.header("Authorization", "Bearer " + token);
		request.contentType("application/json");
		request.then().log().all();

		//userId = "U1707";

		response = request.when().get(UserModuleEndpoints.endpoint.GetByAdminId.getPath() + userId);
		response.then().log().all();

		return response;
	}

	public Response getAllActiveAdmins() throws IOException {
		response = RestAssured.given().baseUri(rb_routes.getString("BaseUrl"))
				.header("Authorization", "Bearer " + token).contentType("application/json").log().all().when()
				.get(UserModuleEndpoints.endpoint.GetAllActiveUsers.getPath()).then().log().all().extract().response();

		return response;

	}

	public Response getCountOfAllActiveAndInactiveAdmins() throws IOException {
		//roleId = "";
	
		response = RestAssured.given().baseUri(rb_routes.getString("BaseUrl"))
				.header("Authorization", "Bearer " + token)
				//.queryParam(roleId, "R01")
				.queryParam(roleId, xlutils.getCellData("UserModule", 1, 12))
				.contentType("application/json")
				.log().all().when().get(UserModuleEndpoints.endpoint.CountOfUsers.getPath()).then().log().all()
				.extract().response();

		return response;

	}

	public Response getAdminsByProgramBatches() throws IOException {
		//batchId = 8647;
		Response response = RestAssured.given().baseUri(rb_routes.getString("BaseUrl"))
				.header("Authorization", "Bearer " + token).contentType("application/json").log().all().when()
				.get(UserModuleEndpoints.endpoint.AdminsByProgramBatches.getPath() + batchId).then().log().all()
				.extract().response();

		return response;

	}

	public Response getAdminForProgram() throws IOException {
		//programId = 16220;
		Response response = RestAssured.given().baseUri(rb_routes.getString("BaseUrl"))
				.header("Authorization", "Bearer " + token).contentType("application/json").log().all().when()
				.get(UserModuleEndpoints.endpoint.GetAdminForProgram.getPath() + programId).then().log().all().extract()
				.response();

		return response;

	}

	public Response getAdminbyRoleID() throws IOException {
		//roleId = "R01";
		Response response = RestAssured.given().baseUri(rb_routes.getString("BaseUrl"))
				.header("Authorization", "Bearer " + token).contentType("application/json").log().all().when()
				.get(UserModuleEndpoints.endpoint.GetAdminByRoleId.getPath() + roleId).then().log().all().extract()
				.response();

		return response;

	}

	public Response getAdminWithRoles() throws IOException {

		Response response = RestAssured.given().baseUri(rb_routes.getString("BaseUrl"))
				.header("Authorization", "Bearer " + token).contentType("application/json").log().all().when()
				.get(UserModuleEndpoints.endpoint.GetAdminWithRoles.getPath()).then().log().all().extract().response();

		return response;

	}

	public Response getAdminWithFilters() {
		RequestSpecification request = RestAssured.given().baseUri(rb_routes.getString("BaseUrl"))
				.header("Authorization", "Bearer " + token);
		request.contentType("application/json");
		request.then().log().all();

		//roleId = "R01";

		response = request.when().get(UserModuleEndpoints.endpoint.GetAllAdmins.getPath() + roleId);
		response.then().log().all();

		JSONObject user = new JSONObject(response);
		String educationLevel = user.getString("userEduUg");
		if (educationLevel.equals("BE")) {
			System.out.println("Bachelors");

		} else {
			System.out.println("Not having Bachelors degree");
		}

		return response;

	}

	public Response putUpdateAdminRoleId() throws IOException {
		List<String> roleIdList = new ArrayList<String>();

		roleIdList.add(xlutils.getCellData("UserUpdateRoleStatus", 2, 0));
		UpdateAdminRoleIdPayload objUpdateAdminRoleIdPayload = new UpdateAdminRoleIdPayload();
		objUpdateAdminRoleIdPayload.setUserRoleList(roleIdList);
		roleId = xlutils.getCellData("UserUpdateRoleStatus", 2, 0);
		Response response = RestAssured.given().header("Authorization", "Bearer " + token).log().all()
				.contentType("application/json").body(objUpdateAdminRoleIdPayload).when()
				.put(UserModuleEndpoints.endpoint.UpdateAdminRoleId.getPath() + userId).then().log().all().extract()
				.response();

		return response;

	}

	public Response updateAdminRoleStatusByAdminId() throws IOException {

		UserRoleMap_UserModulePayload.setRoleId(xlutils.getCellData("UserUpdateRoleStatus", 1, 0));
		UserRoleMap_UserModulePayload.setUserRoleStatus(xlutils.getCellData("UserUpdateRoleStatus", 1, 1));

		Response response = RestAssured.given().header("Authorization", "Bearer " + token).log().all()
				.contentType("application/json").body(UserRoleMap_UserModulePayload).when()
				.put(UserModuleEndpoints.endpoint.UpdateUserRoleStatus.getPath() + userId).then().log().all().extract()
				.response();

		return response;

	}

	public Response UpdateAdminRoleProgramBatchStatus() throws IOException {
		UserRoleProgramBatchesPayload objUserRoleProgramBatchesPayload = new UserRoleProgramBatchesPayload();
		objUserRoleProgramBatchesPayload.setBatchId(batchId);
		objUserRoleProgramBatchesPayload.setUserRoleProgramBatchStatus("Active");
		UpdateRoleProgramBatchStatusPayload objUpdateRoleProgramBatchStatusPayload = new UpdateRoleProgramBatchStatusPayload();
		objUpdateRoleProgramBatchStatusPayload.setProgramId(programId);
		objUpdateRoleProgramBatchStatusPayload.setRoleId(roleId);
		List<UserRoleProgramBatchesPayload> roleProgramBatchList = new ArrayList<UserRoleProgramBatchesPayload>();

		roleProgramBatchList.add(objUserRoleProgramBatchesPayload);

		objUpdateRoleProgramBatchStatusPayload.setUserRoleProgramBatches(roleProgramBatchList);
		Response response = RestAssured.given().header("Authorization", "Bearer " + token).log().all()
				.contentType("application/json").body(objUpdateRoleProgramBatchStatusPayload).when()
				.put(UserModuleEndpoints.endpoint.UpdateAdminRoleProgramBatchStatus.getPath() + userId).then().log()
				.all().extract().response();

		return response;

	}

	public Response putUpdateAdmininfo() throws IOException {

		UserModulePayload.setUserFirstName(xlutils.getCellData("UserModule", 2, 3));
		UserModulePayload.setUserLastName(xlutils.getCellData("UserModule", 2, 4));
		UserModulePayload.setUserPhoneNumber(getUniquePhoneNumber());
		UserModulePayload.setUserTimeZone(xlutils.getCellData("UserModule", 2, 14));
		UserModulePayload.setUserVisaStatus(xlutils.getCellData("UserModule", 2, 15));

		Response response = RestAssured.given().header("Authorization", "Bearer " + token).log().all()
				.contentType("application/json").body(UserModulePayload).when()
				.put(UserModuleEndpoints.endpoint.UpdateAdmininfo.getPath() + userId).then().log().all().extract()
				.response();

		return response;

	}

}

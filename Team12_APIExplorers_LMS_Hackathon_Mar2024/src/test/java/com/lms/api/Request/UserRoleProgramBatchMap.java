package com.lms.api.Request;

import java.io.IOException;

import com.lms.api.Endpoints.RoleProgramBatchMapEndpoints;
import com.lms.api.Endpoints.UserLoginEndpoints;
import com.lms.api.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserRoleProgramBatchMap extends RestUtils {
	
	
	public static Response getAllRoleProgramBatchMap()
	{
		
	return	response = RestAssured
				.given()
				.header("Content-Type", "application/json")
				.header("Authorization", "Bearer " + token)
				.log().all()
				.when()
				.get(RoleProgramBatchMapEndpoints.endpoint.GETROLEPROGRAMBATCHMAP.getPath())
				.then()
				.log().all().extract().response();

	
	//		return response;
////		String GetallPatients= getUrl().getString("GetallPatients");
////		return response=RestAssured.given(requestSpecification).auth().oauth2(oAuthtoken)
////		.when().get(GetallPatients).then()
////		.log().all().extract().response();
	}

	
	public static Response getAllRoleProgramBatchMapWithoutAuthorization()
	{
		
	return	response = RestAssured
				.given()
				.header("Content-Type", "application/json")
				.log().all()
				.when()
				.get(RoleProgramBatchMapEndpoints.endpoint.GETROLEPROGRAMBATCHMAP.getPath())
				.then()
				.log().all().extract().response();

	}

	
	public static Response getAllRoleProgramBatchMapByAdminID()
	{
		
	return	response = RestAssured
				.given()
				.header("Content-Type", "application/json")
				.header("Authorization", "Bearer " + token)
				.log().all()
				.when()
				.get(RoleProgramBatchMapEndpoints.endpoint.GETROLEPROGRAMBATCHMAPBYADMINID.getPath()+userId)
				.then()
				.log().all().extract().response();
	}
	
	public static Response getRoleProgramBatchMapByInvalidAdminID() throws IOException
	{
	String invalidAdminID = xlutils.getCellData("RoleMapController", 1, 0);	
	
	return	response = RestAssured
				.given()
				.header("Content-Type", "application/json")
				.header("Authorization", "Bearer " + token)
				.log().all()
				.when()
				.get(RoleProgramBatchMapEndpoints.endpoint.GETROLEPROGRAMBATCHMAPBYADMINID.getPath()+invalidAdminID)
				.then()
				.log().all().extract().response();
	}

	public static Response getAllProgramBatchByAdminIDWithoutAuthorization()
	{
		
	return	response = RestAssured
				.given()
				.header("Content-Type", "application/json")
				.log().all()
				.when()
				.get(RoleProgramBatchMapEndpoints.endpoint.GETROLEPROGRAMBATCHMAPBYADMINID.getPath()+userId)
				.then()
				.log().all().extract().response();
	}
	
	public static Response deleteProgramBatchByAdminID()
	{
		
	return	response = RestAssured
				.given()
				.header("Content-Type", "application/json")
				.header("Authorization", "Bearer " + token)
				.log().all()
				.when()
				.delete(RoleProgramBatchMapEndpoints.endpoint.DELETEROLEPROGRAMBATCHMAP.getPath()+userId)
				.then()
				.log().all().extract().response();
	}
	
	public static Response deleteProgramBatchByInvalidAdminID() throws IOException
	{
	String invalidAdminID = xlutils.getCellData("RoleMapController", 1, 0);	
	
	return	response = RestAssured
			.given()
			.header("Content-Type", "application/json")
			.header("Authorization", "Bearer " + token)
			.log().all()
			.when()
			.delete(RoleProgramBatchMapEndpoints.endpoint.DELETEROLEPROGRAMBATCHMAP.getPath()+invalidAdminID)
			.then()
			.log().all().extract().response();
	
	}

	public static Response deleteProgramBatchByAdminIDWithoutAuthorization()
	{
		
	return	response = RestAssured
				.given()
				.header("Content-Type", "application/json")
				.log().all()
				.when()
				.delete(RoleProgramBatchMapEndpoints.endpoint.DELETEROLEPROGRAMBATCHMAP.getPath()+userId)
				.then()
				.log().all().extract().response();
	}
}

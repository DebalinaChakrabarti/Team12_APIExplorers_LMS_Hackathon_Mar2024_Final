package com.lms.api.httpclientrequest;

import java.io.IOException;

import com.lms.api.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserLoginController extends RestUtils {
	
	
	
	
	// Registering Client
	public static Response clientRegister() throws IOException
	{
		UserLoginPayload.setUserLoginEmailId(xlutils.getCellData("API_Authentication", 1, 0));
		UserLoginPayload.setPassword(xlutils.getCellData("API_Authentication", 1, 1));
		

	
		RequestSpecification request=RestAssured.given().auth().none()
				.body(UserLoginPayload);
		request.header("Content-Type", "application/json");
		request.then().log().all();
		
		response=request.when().post(rb_routes.getString("Login_Endpoint"));
		response.then().log().all();
		
		return response;
	}
	
	/*public static Response User_Login(User_Login_POJO userpayload)
	{
		String Login_Post= getURL().getString("User_Login_Post");
		Response tkn= given().auth().none()
				 .contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(userpayload)
				.when()
				.post(Login_Post);
		System.out.println(tkn);
		return tkn;
	}
	*/
	
	

}

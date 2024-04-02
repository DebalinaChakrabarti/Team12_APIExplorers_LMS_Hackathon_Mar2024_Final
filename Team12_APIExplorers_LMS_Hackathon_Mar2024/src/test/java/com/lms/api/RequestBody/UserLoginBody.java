package com.lms.api.RequestBody;

import java.io.IOException;

import com.lms.api.Payload.P_01_UserLoginPayload;
import com.lms.api.utilities.RestUtils;

public class UserLoginBody extends RestUtils{

	public static P_01_UserLoginPayload PostBody() throws IOException  
	{
		
		UserLoginPayload.setUserLoginEmailId(xlutils.getCellData("API_Authentication", 1, 0));
		UserLoginPayload.setPassword(xlutils.getCellData("API_Authentication",1,1));
		System.out.println("*******UserLoginPayload**********"+UserLoginPayload);
		return UserLoginPayload;

	}
	
	public static P_01_UserLoginPayload PostInvalidCredentials() throws IOException
	{
		System.out.println("*****Sending invalid credentials*********");
		log.info("*****Sending invalid credentials*********");
		UserLoginPayload.setUserLoginEmailId(xlutils.getCellData("API_Authentication", 2, 0));
		UserLoginPayload.setPassword(xlutils.getCellData("API_Authentication",2,1));
		return UserLoginPayload;
	}
	
}

package com.lms.api.utilities;


import java.io.File;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lms.api.Payload.P_01_UserLoginPayload;
import com.lms.api.Payload.P_02_BatchPayload;
import com.lms.api.Payload.P_02_ProgramPayload;
import com.lms.api.Payload.P_03_UserRoleMap;
import com.lms.api.Payload.P_04_UserPayload;
import com.lms.api.Payload.UserLoginUserModulePayload;
import com.lms.api.Payload.UserModulePayload;
import com.lms.api.Payload.UserRoleMap_UserModulePayload;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestUtils {

	public static ResourceBundle rb_routes = ResourceBundle.getBundle("routes");

	public static Logger log = LogManager.getLogger();

	//Schema and excel path
	public static ResourceBundle path = ResourceBundle.getBundle("path");
	public static XLReader xlutils=new XLReader(path.getString("XLpath"));
	
	//client post json path
	
	public static File ClientPostJson=xlutils.getJSONFile(path.getString("ClientRegisterJson"));
	public static File programPostjson = xlutils.getJSONFile(path.getString("programPostSchemajson"));

	/*//program schema path
	public static File programPutjson = xlutils.getJSONFile(path.getString("programPutSchemajson"));
	public static File programPostjson = xlutils.getJSONFile(path.getString("programPostSchemajson"));	

	//batch schema path
	public static File postbatchJson = xlutils.getJSONFile(path.getString("postbatchJson"));			
	public static File getbatchbynameJson = xlutils.getJSONFile(path.getString("getbatchbynameJson"));
	public static File getbatchIDJson = xlutils.getJSONFile(path.getString("getbatchIDJson"));
	public static File updatebatchIDJson = xlutils.getJSONFile(path.getString("batchupdatebyIDJson"));

	//user schema path
	public static File getAllUserjson= xlutils.getJSONFile(path.getString("getAllUserjson"));
	public static File getUserByIDjson= xlutils.getJSONFile(path.getString("getUserByIDjson"));
	public static File getUserByRolejson= xlutils.getJSONFile(path.getString("getUserByRolejson"));
	public static File postUserjson= xlutils.getJSONFile(path.getString("postUserjson"));
	public static File putUserByIdjson= xlutils.getJSONFile(path.getString("putUserByIdjson"));
	public static File putUserStatusRolejson= xlutils.getJSONFile(path.getString("putUserStatusRolejson"));

	//assignment schema path
	public static File postAssignmentJson = xlutils.getJSONFile(path.getString("postAssignmentJson"));	
	public static File GetByIdJson = xlutils.getJSONFile(path.getString("GetByIdJson"));

	//assignment schema path
	public static File AssignSubmitPostjson = xlutils.getJSONFile(path.getString("AssignSubmitPostjson"));
	public static File AssignSubmitUserIDjson = xlutils.getJSONFile(path.getString("AssignSubUserIDjson"));
	public static File AssignSubmitgradeIDjson = xlutils.getJSONFile(path.getString("AssignSubGradeIDjson"));*/

	
		//PayLoad Objects
		public static P_02_ProgramPayload ProgramPayload = new P_02_ProgramPayload();
		public static P_02_BatchPayload BatchPayload = new P_02_BatchPayload();
		public static P_04_UserPayload UserPayload = new P_04_UserPayload();
		public static P_03_UserRoleMap UserRoleMap = new P_03_UserRoleMap();
		public static P_01_UserLoginPayload UserLoginPayload = new P_01_UserLoginPayload();
		public static UserModulePayload UserModulePayload=new UserModulePayload();
		public static UserLoginUserModulePayload UserLoginUserModulePayload=new UserLoginUserModulePayload();
		public static  UserRoleMap_UserModulePayload UserRoleMap_UserModulePayload=new UserRoleMap_UserModulePayload();
	public static RequestSpecification request;
	public static Response response;


	
	public static String extractResponse;
	public static String token;
	
	
	
	
	public static String AdminUser;
	public static String StudentUser;	
	public static String StaffUser; 
	public static int statusCode;
	public static int responseBody;
	public static String userId;
	public static Integer batchId=8647;
	public static String roleId;
	public static Integer programId;
	public static int InvalidprogramId = 456544855;
	public static String InvalidprogramName = "Star Wars Universe";
	public static String programName;


}

package com.lms.api.RequestBody;

import java.io.IOException;

import com.lms.api.Payload.P_02_ProgramPayload;
import com.lms.api.utilities.RestUtils;

public class ProgramModuleBody extends RestUtils{

	public static P_02_ProgramPayload PostProgramBody() throws IOException  
	{
		ProgramPayload.setProgramName(xlutils.getCellData("ProgramModule", 1, 0));
		ProgramPayload.setProgramStatus(xlutils.getCellData("ProgramModule",1,1));
		ProgramPayload.setProgramDescription(xlutils.getCellData("ProgramModule",1,2));
		System.out.println("*******ProgramModulePayload**********" +ProgramPayload);
		return ProgramPayload;

	}
	
}


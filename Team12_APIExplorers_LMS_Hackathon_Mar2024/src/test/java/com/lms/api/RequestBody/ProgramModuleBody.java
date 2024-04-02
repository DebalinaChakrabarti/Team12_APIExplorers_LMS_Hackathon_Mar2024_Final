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
	public static P_02_ProgramPayload UpdateByIDProgramBody() throws IOException  
	{
		ProgramPayload.setProgramName(xlutils.getCellData("ProgramModule", 2, 0));
		ProgramPayload.setProgramStatus(xlutils.getCellData("ProgramModule",2,1));
		ProgramPayload.setProgramDescription(xlutils.getCellData("ProgramModule",2,2));
		System.out.println("*******ProgramModuleUpdateByNamePayload**********" +ProgramPayload);
		return ProgramPayload;

		
	}
	
	public static P_02_ProgramPayload UpdateByProgramNameBody() throws IOException  
	{
		ProgramPayload.setProgramName(xlutils.getCellData("ProgramModule", 3, 0));
		ProgramPayload.setProgramStatus(xlutils.getCellData("ProgramModule",3,1));
		ProgramPayload.setProgramDescription(xlutils.getCellData("ProgramModule",3,2));
		System.out.println("*******ProgramModuleUpdateByNamePayload**********" +ProgramPayload);
		return ProgramPayload;

		
	}
	public static P_02_ProgramPayload PostByExistProgramNameBody() throws IOException  
	{
		ProgramPayload.setProgramName(xlutils.getCellData("ProgramModule", 4, 0));
		ProgramPayload.setProgramStatus(xlutils.getCellData("ProgramModule",4,1));
		ProgramPayload.setProgramDescription(xlutils.getCellData("ProgramModule",4,2));
		System.out.println("*******PostByExistProgramNameBody**********" +ProgramPayload);
		return ProgramPayload;

		
	}
	
	public static P_02_ProgramPayload PostByMissingProgramNameBody() throws IOException  
	{
		ProgramPayload.setProgramName(xlutils.getCellData("ProgramModule", 5, 0));
		ProgramPayload.setProgramStatus(xlutils.getCellData("ProgramModule",5,1));
		ProgramPayload.setProgramDescription(xlutils.getCellData("ProgramModule",5,2));
		System.out.println("*******PostByMissingProgramNameBody**********" +ProgramPayload);
		return ProgramPayload;

		
	}
	
	public static P_02_ProgramPayload PostByProgramNameNumBody() throws IOException  
	{
		ProgramPayload.setProgramName(xlutils.getCellData("ProgramModule", 6, 0));
		ProgramPayload.setProgramStatus(xlutils.getCellData("ProgramModule",6,1));
		ProgramPayload.setProgramDescription(xlutils.getCellData("ProgramModule",6,2));
		System.out.println("*******PostByProgramNameNumBody**********" +ProgramPayload);
		return ProgramPayload;
	}
	
	public static P_02_ProgramPayload PostBymissingadditionalBody() throws IOException  
	{
		ProgramPayload.setProgramName(xlutils.getCellData("ProgramModule", 7, 0));
		ProgramPayload.setProgramStatus(xlutils.getCellData("ProgramModule",7,1));
		ProgramPayload.setProgramDescription(xlutils.getCellData("ProgramModule",7,2));
		System.out.println("*******PostByInvalidrequestBody**********" +ProgramPayload);
		return ProgramPayload;
	}
	
	public static P_02_ProgramPayload UpdateByMissingrequestBody() throws IOException  
	{
		ProgramPayload.setProgramName(xlutils.getCellData("ProgramModule", 8, 0));
		ProgramPayload.setProgramStatus(xlutils.getCellData("ProgramModule",8,1));
		ProgramPayload.setProgramDescription(xlutils.getCellData("ProgramModule",8,2));
		System.out.println("*******UpdateByMissingrequestBody**********" +ProgramPayload);
		return ProgramPayload;
	}
	
	public static P_02_ProgramPayload UpdateByPgDesnumrequestBody() throws IOException  
	{
		ProgramPayload.setProgramName(xlutils.getCellData("ProgramModule", 9, 0));
		ProgramPayload.setProgramStatus(xlutils.getCellData("ProgramModule",9,1));
		ProgramPayload.setProgramDescription(xlutils.getCellData("ProgramModule",9,2));
		System.out.println("*******UpdateByMissingrequestBody**********" +ProgramPayload);
		return ProgramPayload;
	} 
	
	public static P_02_ProgramPayload UpdateByProgramNamestatusBody() throws IOException  
	{
		ProgramPayload.setProgramName(xlutils.getCellData("ProgramModule", 10, 0));
		ProgramPayload.setProgramStatus(xlutils.getCellData("ProgramModule",10,1));
		ProgramPayload.setProgramDescription(xlutils.getCellData("ProgramModule",10,2));
		System.out.println("*******UpdateByMissingrequestBody**********" +ProgramPayload);
		return ProgramPayload;
	}
}


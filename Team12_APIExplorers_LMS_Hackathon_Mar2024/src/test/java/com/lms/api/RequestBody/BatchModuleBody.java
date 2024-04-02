package com.lms.api.RequestBody;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;

import com.lms.api.Payload.P_02_BatchPayload;
//import com.lms.api.Payload.P_03_BatchPayload;
import com.lms.api.utilities.RestUtils;

public class BatchModuleBody extends RestUtils
{
	public static  P_02_BatchPayload CreateBatch_ValidData_Body() throws IOException
	{
		BatchPayload.setBatchDescription(xlutils.getCellData("BatchPostdata",1,0));
		BatchPayload.setBatchName(xlutils.getCellData("BatchPostdata",1,1)+RandomStringUtils.randomNumeric(3));
		BatchPayload.setBatchNoOfClasses(xlutils.getCellData("BatchPostdata",1,2));
		BatchPayload.setBatchStatus(xlutils.getCellData("BatchPostdata",1,3));
		BatchPayload.setProgramId(ProgramPayload.getProgramId());

		return BatchPayload;
	}
	
	public static P_02_BatchPayload createBatch_existingData()
	{
		BatchPayload.setBatchDescription(BatchPayload.getBatchDescription());
		BatchPayload.setBatchName(BatchPayload.getBatchName());
		BatchPayload.setBatchNoOfClasses(BatchPayload.getBatchNoOfClasses());
		BatchPayload.setBatchStatus(BatchPayload.getBatchStatus());
	    BatchPayload.setProgramId(BatchPayload.getProgramId()); 
	    return BatchPayload;
	}
	
	public static P_02_BatchPayload createBatch_missingMandatoryFields() throws IOException
	{
		BatchPayload.setBatchDescription(xlutils.getCellData("BatchPostdata",2,0));
		BatchPayload.setBatchName(xlutils.getCellData("BatchPostdata",2,1));
		BatchPayload.setBatchNoOfClasses(xlutils.getCellData("BatchPostdata",2,2));
		BatchPayload.setBatchStatus(xlutils.getCellData("BatchPostdata",2,3));
	 //  BatchPayload.setProgramId(BatchPayload.getProgramId()); 
		 return BatchPayload;
	}
	
	public static P_02_BatchPayload createBatch_missingAditionalFields() throws IOException
	{
		BatchPayload.setBatchDescription(xlutils.getCellData("BatchPostdata",3,0));
		BatchPayload.setBatchName(xlutils.getCellData("BatchPostdata",3,1));
		BatchPayload.setBatchNoOfClasses(xlutils.getCellData("BatchPostdata",3,2));
		BatchPayload.setBatchStatus(xlutils.getCellData("BatchPostdata",3,3));
		BatchPayload.setProgramId(ProgramPayload.getProgramId());

		return BatchPayload;
	}
	
	public static P_02_BatchPayload createBatch_InvalidData() throws IOException
	{
		BatchPayload.setBatchDescription(xlutils.getCellData("BatchPostdata",4,0));
		BatchPayload.setBatchName(xlutils.getCellData("BatchPostdata",4,1));
		BatchPayload.setBatchNoOfClasses(xlutils.getCellData("BatchPostdata",4,2));
		BatchPayload.setBatchStatus(xlutils.getCellData("BatchPostdata",4,3));
		BatchPayload.setProgramId(ProgramPayload.getProgramId());

		return BatchPayload;
	}
	public static P_02_BatchPayload updateBatch_validdata_Body() throws IOException 
	{
	BatchPayload.setBatchDescription(xlutils.getCellData("BatchUpdateData", 1, 0));
	BatchPayload.setBatchName( xlutils.getCellData("BatchUpdateData", 1, 1)+RandomStringUtils.randomNumeric(3));
	BatchPayload.setBatchNoOfClasses(xlutils.getCellData("BatchUpdateData", 1, 2));
	BatchPayload.setBatchStatus(xlutils.getCellData("BatchUpdateData", 1, 3));
	//BatchPayload.setProgramId(Integer.parseInt(xlutils.getCellData("BatchUpdateData",1,4)));
	BatchPayload.setProgramId(programId);
	BatchPayload.setProgramName(xlutils.getCellData("BatchUpdateData", 1, 5));
	return BatchPayload; 
	}
}

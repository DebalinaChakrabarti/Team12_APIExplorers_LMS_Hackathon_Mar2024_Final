package com.lms.api.Payload;

import com.google.gson.annotations.SerializedName;

public class UserRoleProgramBatchesPayload {
	 @SerializedName("batchId")
	   int batchId;

	   @SerializedName("userRoleProgramBatchStatus")
	   String userRoleProgramBatchStatus;


	    public void setBatchId(int batchId) {
	        this.batchId = batchId;
	    }
	    public int getBatchId() {
	        return batchId;
	    }
	    
	    public void setUserRoleProgramBatchStatus(String userRoleProgramBatchStatus) {
	        this.userRoleProgramBatchStatus = userRoleProgramBatchStatus;
	    }
	    public String getUserRoleProgramBatchStatus() {
	        return userRoleProgramBatchStatus;
	    }
	    
	}


package com.lms.api.Payload;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class UpdateRoleProgramBatchStatusPayload {
	   @SerializedName("programId")
	   int programId;

	   @SerializedName("roleId")
	   String roleId;

	   @SerializedName("userRoleProgramBatches")
	   List<UserRoleProgramBatchesPayload> userRoleProgramBatches;


	    public void setProgramId(int programId) {
	        this.programId = programId;
	    }
	    public int getProgramId() {
	        return programId;
	    }
	    
	    public void setRoleId(String roleId) {
	        this.roleId = roleId;
	    }
	    public String getRoleId() {
	        return roleId;
	    }
	    
	    public void setUserRoleProgramBatches(List<UserRoleProgramBatchesPayload> userRoleProgramBatches) {
	        this.userRoleProgramBatches = userRoleProgramBatches;
	    }
	    public List<UserRoleProgramBatchesPayload> getUserRoleProgramBatches() {
	        return userRoleProgramBatches;
	    }
	   
}

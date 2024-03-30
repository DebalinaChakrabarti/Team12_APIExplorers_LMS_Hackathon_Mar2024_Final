package com.lms.api.Payload;

public class P_06_UserRoleProgramBatchMapPayload {

	private int batchId;
	private int programId;
	private String roleId;
	private String userId;
	private String userRoleProgramBatchStatus;
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public int getBatchId() {
		return batchId;
	}
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
	public int getProgramId() {
		return programId;
	}
	public void setProgramId(int programId) {
		this.programId = programId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserRoleProgramBatchStatus() {
		return userRoleProgramBatchStatus;
	}
	public void setUserRoleProgramBatchStatus(String userRoleProgramBatchStatus) {
		this.userRoleProgramBatchStatus = userRoleProgramBatchStatus;
	}
	
}

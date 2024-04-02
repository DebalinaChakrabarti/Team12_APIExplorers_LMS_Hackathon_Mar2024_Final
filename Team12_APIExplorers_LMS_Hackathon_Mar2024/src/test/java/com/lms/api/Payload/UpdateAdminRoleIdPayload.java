package com.lms.api.Payload;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class UpdateAdminRoleIdPayload {
	@SerializedName("userRoleList")
	   List<String> userRoleList;


	    public void setUserRoleList(List<String> userRoleList) {
	        this.userRoleList = userRoleList;
	    }
	    public List<String> getUserRoleList() {
	        return userRoleList;
	    }
	   	    
	}




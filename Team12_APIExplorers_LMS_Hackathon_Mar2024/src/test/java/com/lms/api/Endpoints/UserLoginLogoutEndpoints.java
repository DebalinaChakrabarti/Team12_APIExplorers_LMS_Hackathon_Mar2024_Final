package com.lms.api.Endpoints;

public class UserLoginLogoutEndpoints {
	
	public enum endpoint	{
		LOGINPOST("/login"),
		PostInvalid_LoginEndpoint("/Logins"),
		GetLogout("/logoutlms"),
		InvalidGetLogout("/loguot");
		private final String path;
		
		endpoint(String path) {
			this.path=path;
		}
		
		public String getPath() {
	        return path;
	    }
	}
}

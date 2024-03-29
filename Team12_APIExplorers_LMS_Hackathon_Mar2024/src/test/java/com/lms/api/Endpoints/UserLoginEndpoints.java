package com.lms.api.Endpoints;

public class UserLoginEndpoints {
	
	public enum endpoint	{
		LOGINPOST("/login"),
		PostInvalid_LoginEndpoint("/Logins");
		private final String path;
		
		endpoint(String path) {
			this.path=path;
		}
		
		public String getPath() {
	        return path;
	    }
	}
}

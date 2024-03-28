package com.lms.api.endpoints;

public class LoginControllerEndpoints {
	public enum endpoint	{
		LOGINPOST("/login");
		private final String path;
		
		endpoint(String path) {
			this.path=path;
		}
		
		public String getPath() {
	        return path;
	    }
	}
}

package com.lms.api.Endpoints;

public class ProgramEndpoints {

	public enum endpoint	{
		PROGRAMPOST("/saveprogram"),
		INVALIDPROGRAMPOST("/saveprogrammss");
		
		private final String path;
		
		endpoint(String path) {
			this.path=path;
		}
		
		public String getPath() {
	        return path;
	    }
	}
}

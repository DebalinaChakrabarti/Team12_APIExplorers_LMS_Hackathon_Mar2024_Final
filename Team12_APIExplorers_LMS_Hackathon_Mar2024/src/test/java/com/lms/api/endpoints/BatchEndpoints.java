package com.lms.api.endpoints;

public class BatchEndpoints {
	public enum endpoint	{
		BATCHPOST("/batches");
		private final String path;
		
		endpoint(String path) {
			this.path=path;
		}
		
		public String getPath() {
	        return path;
	    }
		
	}
}

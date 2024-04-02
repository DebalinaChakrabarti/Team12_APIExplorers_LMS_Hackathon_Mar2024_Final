package com.lms.api.Endpoints;

public class RoleProgramBatchMapEndpoints {
	
	
		public enum endpoint	
		{
			GETROLEPROGRAMBATCHMAP("/userRoleProgramBatchMap"),
			GETROLEPROGRAMBATCHMAPBYADMINID("/userRoleProgramBatchMap/"),
			DELETEROLEPROGRAMBATCHMAP("/userRoleProgramBatchMap/deleteAll/");
			
			
			private final String path;
			
			endpoint(String path) {
				this.path=path;
			}
			
			public String getPath() {
		        return path;
		    }
			
		}
}

package com.lms.api.Endpoints;

public class ProgramEndpoints {

	public enum endpoint	{
		PROGRAMPOST("/saveprogram"),
		INVALIDPROGRAMPOST("/saveprogrammss"),
		GETALLPRMS("/allPrograms"),
		GETPGBYPROGRAMID("/programs/"),
		GETALLPGWITHUSERS("/allProgramsWithUsers"),
		UPDATEBYPGRMID("/putprogram/"),
		UPDATEBYPGRMNAME("/program/"),
		DELETEBYPRGMID("/deletebyprogid/"),
		DELETEBYPRGMNAME("/deletebyprogname/");
		
		private final String path;
		
		endpoint(String path) {
			this.path=path;
		}
		
		public String getPath() {
	        return path;
	    }
	}
}

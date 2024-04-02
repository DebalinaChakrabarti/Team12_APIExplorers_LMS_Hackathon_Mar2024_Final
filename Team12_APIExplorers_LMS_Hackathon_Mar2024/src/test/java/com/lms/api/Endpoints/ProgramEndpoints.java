package com.lms.api.Endpoints;

public class ProgramEndpoints {

	public enum endpoint	{
		PROGRAMPOST("/saveprogram"),
		INVALIDPROGRAMPOST("/saveprogrammss"),
		GETALLPRMS("/allPrograms"),
		INVALIDGET("/allPrograammss"),
		GETPGBYPROGRAMID("/programs/"),
		GETBYPGMIDINVALIDEP("/programmss/"),
		GETALLPGWITHUSERS("/allProgramsWithUsers"),
		GETALLPGUSERSINVALIDEP("/allProgrammssWithUsers"),
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

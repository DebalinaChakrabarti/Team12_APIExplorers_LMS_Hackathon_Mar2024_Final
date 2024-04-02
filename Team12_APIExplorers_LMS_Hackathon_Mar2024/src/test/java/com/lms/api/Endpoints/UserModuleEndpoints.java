package com.lms.api.Endpoints;

public class UserModuleEndpoints {
	public enum endpoint	{
		PostUserWithRole("/users/roleStatus"),
		GetAllRoles("users/roles"),
		GetAllAdmins("/users/roles/"),
		GetByAdminId("users/"),
		GetUsersByRoleId("/v2/users"),
		GetAllUsersWithRoles("users/roles"),
		CountOfUsers("/users/byStatus"),
		GetAllActiveUsers("/users/activeUsers"),
		AdminsByProgramBatches("/users/programBatch/"),
		GetAdminForProgram("/users/programs/"),
		UpdateAdminRoleId("/users/roleId/"),
		UpdateUserRoleStatus("/users/roleStatus/"),
		UpdateAdminRoleProgramBatchStatus("/users/roleProgramBatchStatus/"),
		UpdateAdminLoginStatus("/users/userLogin/"),
		UpdateAdmininfo("/users/"),
		DeleteByAdminId("/userRoleProgramBatchMap/deleteAll/"),
		GetAdminByRoleId("/users/roles/"),
		GetAdminWithRoles("/roles");
		private final String path;
		
		endpoint(String path) {
			this.path=path;
		}
		
		public String getPath() {
	        return path;
	    }
	}
}

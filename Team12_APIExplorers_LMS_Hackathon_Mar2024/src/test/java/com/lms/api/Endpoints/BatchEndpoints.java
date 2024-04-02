package com.lms.api.Endpoints;

public class BatchEndpoints {
	public enum endpoint	{
		CREATEBATCH("/batches"),
		CreateBatch_invalidEndpoint("/batchesss"),
		GETALLBATCHES("/batches"),
		GetAllBatches_InvalidEndpoint("/batchesss"),
		GETBATCHBYBATCHID("/batches/batchId/"),
		GETBATCHBYBATCHNAME("/batches/batchName/"),
		GETBATCHBYPROGRAMID("/batches/program/"),
		UPDATEBYBATCHID("/batches/"),
		DELETEBYBATCHID("/batches/"); 
				
		private final String path;
		
		endpoint(String path) {
			this.path=path;
		}
		
		public String getPath() {
	        return path;
	    }
		
	}
}

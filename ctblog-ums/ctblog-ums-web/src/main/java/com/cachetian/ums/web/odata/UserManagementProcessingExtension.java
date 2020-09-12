package com.cachetian.ums.web.odata;

import org.apache.olingo.odata2.jpa.processor.api.model.JPAEdmExtension;
import org.apache.olingo.odata2.jpa.processor.api.model.JPAEdmSchemaView;
import java.io.InputStream;

public class UserManagementProcessingExtension implements JPAEdmExtension {

	@Override
	public void extendWithOperation(JPAEdmSchemaView view) {
//		view.registerOperations(CustomerProcessor.class, null);
//		view.registerOperations(SalesOrderProcessor.class, null);
//		view.registerOperations(CustomerReviewProcessor.class, null);
	}

	@Override
	public void extendJPAEdmSchema(JPAEdmSchemaView arg0) {

	}

	@Override
	public InputStream getJPAEdmMappingModelStream() {
		return null;
	}

}

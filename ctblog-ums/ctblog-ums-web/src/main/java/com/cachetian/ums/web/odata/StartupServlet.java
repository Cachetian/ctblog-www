package com.cachetian.ums.web.odata;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StartupServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static EntityManagerFactory emf;

	private static final Logger LOGGER = LoggerFactory.getLogger(StartupServlet.class);

	@Override
	public void init() throws ServletException {
		try {
			emf = JpaEntityManagerFactory.getEntityManagerFactory();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new ServletException(e);
		}
	}

	@Override
	public void destroy() {
		emf.close();
	}

}

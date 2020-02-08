package com.cachetian.ums.application.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cachetian.ums.application.api.IRoleService;
import com.cachetian.ums.application.api.IUMSFactory;
import com.cachetian.ums.application.api.IUserService;

public class UMSFactory implements IUMSFactory {
	private static final String PERSISTENCE_UNIT_NAME = "ctblog-ums-jpa";
	private static EntityManagerFactory factory;
	private static UMSFactory instance;

	private UMSFactory() {
		super();
	}

	public static IUMSFactory getInstance() {
		if (instance == null) {
			instance = new UMSFactory();
		}
		return instance;
	}

	public IUserService createUserService() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		UserService service = new UserService();
		service.setEm(em);
		return service;
	}

	@Override
	public IRoleService createRoleService() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		RoleService service = new RoleService();
		service.setEm(em);
		return service;
	}

}

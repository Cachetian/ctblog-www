package com.cachetian.ums;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Test;

import com.cachetian.ums.application.model.Role;
import com.cachetian.ums.application.model.User;
import com.cachetian.ums.application.service.UMSFactory;
import com.cachetian.ums.persistence.model.CtEntityAction;
import com.cachetian.ums.persistence.model.CtEntityGroup;
import com.cachetian.ums.persistence.model.CtEntityRole;
import com.cachetian.ums.persistence.model.CtEntityUser;
import com.cachetian.ums.persistence.model.CtEntityUserRoleAssociation;

public class AppTest {

	private static final String PERSISTENCE_UNIT_NAME = "ctblog-ums-jpa";
	private static EntityManagerFactory factory;

	@Test
	public void testApp() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		// read the existing entries and write to console
		Query qu = em.createQuery("select u from CtEntityUser u");
		List<?> userList = qu.getResultList();
		System.out.println("Size: " + userList.size());
		em.getTransaction().begin();
		for (Object user : userList) {
			System.out.println(user);
			em.remove(user);
		}
		em.getTransaction().commit();

		// create role
		Query qr = em.createQuery("select r from CtEntityRole r");
		List<?> roleList = qr.getResultList();
		System.out.println("Size: " + roleList.size());
		em.getTransaction().begin();
		for (Object role : roleList) {
			System.out.println(role);
			em.remove(role);
		}
		em.getTransaction().commit();
		
		// create group
		Query qg = em.createQuery("select g from CtEntityGroup g");
		List<?> groupList = qg.getResultList();
		System.out.println("Size: " + groupList.size());
		em.getTransaction().begin();
		for (Object group : groupList) {
			System.out.println(group);
			em.remove(group);
		}
		em.getTransaction().commit();
		
		// create action
		Query qa = em.createQuery("select a from CtEntityAction a");
		List<?> actionList = qa.getResultList();
		System.out.println("Size: " + actionList.size());
		em.getTransaction().begin();
		for (Object action : actionList) {
			System.out.println(action);
			em.remove(action);
		}
		em.getTransaction().commit();
		
		// create new user
		em.getTransaction().begin();
		CtEntityUser user = new CtEntityUser();
		user.setUniqueName("Sky");
		user.setUuid(UUID.randomUUID().toString());
		em.persist(user);
		em.getTransaction().commit();
		
		// create new role
		em.getTransaction().begin();
		CtEntityRole role = new CtEntityRole();
		role.setUniqueName("Developer");
		role.setUuid(UUID.randomUUID().toString());
		em.persist(role);
		em.getTransaction().commit();
		
		// create new group
		em.getTransaction().begin();
		CtEntityGroup group = new CtEntityGroup();
		group.setUniqueName("Developers");
		group.setUuid(UUID.randomUUID().toString());
		em.persist(group);
		em.getTransaction().commit();
		
		// create new action
		em.getTransaction().begin();
		CtEntityAction action = new CtEntityAction();
		action.setUniqueName("writeCode");
		action.setUuid(UUID.randomUUID().toString());
		action.setRoleId(role.getId());
		em.persist(action);
		em.getTransaction().commit();

		// assign user to role
		em.getTransaction().begin();
		CtEntityUserRoleAssociation ur = new CtEntityUserRoleAssociation();
		ur.setRoleId(role.getId());
		ur.setUserId(user.getId());
		em.persist(ur);
		em.getTransaction().commit();
		
		// test UMS factory
		User existUser = UMSFactory.getInstance().createUserService().getUserByUniqueName("Sky");
		Assert.assertEquals(existUser.getUniqueName(), user.getUniqueName());

		List<Role> existRoles = UMSFactory.getInstance().createRoleService().getRolesByUserUniqueName("Sky");
		for (Role existRole : existRoles) {
			Assert.assertEquals(existRole.getUniqueName(), role.getUniqueName());
		}

		em.close();
	}
}

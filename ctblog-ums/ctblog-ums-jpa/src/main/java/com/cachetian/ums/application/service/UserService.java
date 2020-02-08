package com.cachetian.ums.application.service;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.cachetian.commons.utils.BeanUtils;
import com.cachetian.ums.application.api.IUserService;
import com.cachetian.ums.application.model.User;
import com.cachetian.ums.persistence.model.CtEntityUser;

public class UserService implements IUserService {

	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public Long createUser(User newUser) {
		try {
			em.getTransaction().begin();
			CtEntityUser entity = new CtEntityUser();
			entity.setUniqueName(newUser.getUniqueName());
			getEm().persist(entity);
			em.getTransaction().commit();
			return entity.getId();
		} finally {
			em.close();
		}
	}

	public void addToRoles(Long userId, List<String> roleIds) {
		// TODO Auto-generated method stub

	}

	public void removeFromRole(Long userId, Long roleId) {
		// TODO Auto-generated method stub

	}

	public void addToGroups(Long userId, List<String> groupIds) {
		// TODO Auto-generated method stub

	}

	public void removeFromGroup(Long userId, Long groupId) {
		// TODO Auto-generated method stub

	}

	public Long createUserWithAssociations(User newUserWithAssociations) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addToAssociations(Long userId, List<String> roleIds, List<String> groupIds) {
		// TODO Auto-generated method stub

	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	public void updateUserWithAssociations(User userWithAssociations) {
		// TODO Auto-generated method stub

	}

	public void removeUser(Long id) {
		// TODO Auto-generated method stub

	}

	public void removeUser(User user) {
		// TODO Auto-generated method stub

	}

	public User getUser(Long id) {
		try {
			CtEntityUser entity = em.find(CtEntityUser.class, id);
			User user = new User();
			user.setId(entity.getId());
			user.setUniqueName(entity.getUniqueName());
			return user;
		} finally {
			em.close();
		}
	}

	public User getUserByUniqueName(String uniqueName) {
		try {
			Query query = em.createNamedQuery("User.getUserByUniqueName");
			query.setParameter("uniqueName", uniqueName);
			CtEntityUser bo = (CtEntityUser) query.getSingleResult();
			User vo = new User();
			BeanUtils.copyProperties(bo, vo, Arrays.asList(new String[] { "Id", "UniqueName" }));
			return vo;
		} finally {
			em.close();
		}
	}

	@Override
	public User getUserRoleAssociations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserGroupAssociations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserWithAssociations() {
		// TODO Auto-generated method stub
		return null;
	}

}

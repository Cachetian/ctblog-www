package com.cachetian.ums.application.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.cachetian.commons.utils.BeanUtils;
import com.cachetian.ums.application.api.IRoleService;
import com.cachetian.ums.application.model.Role;
import com.cachetian.ums.persistence.model.CtEntityRole;
import com.cachetian.ums.persistence.model.CtEntityUser;
import com.cachetian.ums.persistence.model.CtEntityUserRoleAssociation;

public class RoleService implements IRoleService {
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Role> getRolesByUserUniqueName(String uniqueName) {
		List<Role> roles = new ArrayList<Role>();
		try {
			Query query = em.createNamedQuery("User.getUserByUniqueName");
			query.setParameter("uniqueName", uniqueName);
			List<CtEntityUserRoleAssociation> roleList = null;

			CtEntityUser user = (CtEntityUser) query.getSingleResult();
			query = em.createNamedQuery("UserRole.getRolesByUserId");
			query.setParameter("userId", user.getId());
			roleList = query.getResultList();
			for (CtEntityUserRoleAssociation ur : roleList) {
				CtEntityRole bo = em.find(CtEntityRole.class, ur.getRoleId());
				Role vo = new Role();
				BeanUtils.copyProperties(bo, vo, Arrays.asList(new String[] {"Id","UniqueName"}));
				roles.add(vo);
			}
		} finally {
			em.close();
		}
		return roles;
	}

	public Role getRole(Long id) {
		try {
			CtEntityRole entity = em.find(CtEntityRole.class, id);
			Role role = new Role();
			role.setId(entity.getId());
			role.setUniqueName(entity.getUniqueName());
			return role;
		} finally {
			em.close();
		}
	}

}

package com.cachetian.ums.persistence.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cachetian.ums.persistence.core.CtPersistenceObject;

/**
 * @author cachetian
 *
 */
@Entity
@Table(name = "tb_user_role")
public class CtEntityRoleGroupAssociation extends CtPersistenceObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Long roleId;
	private Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "CtEntityRoleGroupAssociation [userId=" + userId + ", roleId=" + roleId + "]";
	}
}

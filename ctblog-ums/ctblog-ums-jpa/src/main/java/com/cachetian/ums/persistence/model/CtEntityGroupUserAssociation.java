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
@Table(name = "tb_user_group")
public class CtEntityGroupUserAssociation extends CtPersistenceObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Long groupId;
	private Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	@Override
	public String toString() {
		return "CtEntityGroupUserAssociation [userId=" + userId + ", groupId=" + groupId + "]";
	}

}

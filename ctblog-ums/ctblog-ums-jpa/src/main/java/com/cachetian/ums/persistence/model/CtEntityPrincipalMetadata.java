package com.cachetian.ums.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cachetian.ums.persistence.core.CtPersistenceObject;

/**
 * @author cachetian
 *
 */
@Entity
@Table(name = "tb_principal_metadata")
public class CtEntityPrincipalMetadata extends CtPersistenceObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String type;
	private String attribute;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	@Override
	public String toString() {
		return "CtEntityPrincipalMetadata [id=" + id + ", type=" + type + ", attribute=" + attribute + "]";
	}
}

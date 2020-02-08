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
@Table(name = "tb_principal_attribute")
public class CtEntityPrincipalAttribute extends CtPersistenceObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Long principalId;
	private String label;
	private String value;

	public Long getPrincipalId() {
		return principalId;
	}

	public void setPrincipalId(Long principalId) {
		this.principalId = principalId;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "CtEntityPrincipalAttribute [principalId=" + principalId + ", label=" + label + ", value=" + value + "]";
	}
}

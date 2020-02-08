package com.cachetian.ums.persistence.model;

import javax.persistence.*;

import com.cachetian.ums.persistence.core.CtPersistenceObject;

/**
 * @author cachetian
 *
 */
@Entity
@Table(name="tb_group")
public class CtEntityGroup extends CtPersistenceObject {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String uniqueName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUniqueName() {
        return uniqueName;
    }

    public void setUniqueName(String uniqueName) {
        this.uniqueName = uniqueName;
    }

	@Override
	public String toString() {
		return "CtEntityGroup [id=" + id + ", uniqueName=" + uniqueName + "]";
	}
}

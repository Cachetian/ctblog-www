package com.cachetian.ums.persistence.core;

import java.io.Serializable;

public class CtPersistenceObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}

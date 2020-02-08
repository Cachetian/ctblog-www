package com.cachetian.ums.application.model;

public class Metadata {
	private Long id;
	private String type;
	private String attribute;

	public Long getId() {
		return id;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setId(Long id) {
		this.id = id;
	}
}

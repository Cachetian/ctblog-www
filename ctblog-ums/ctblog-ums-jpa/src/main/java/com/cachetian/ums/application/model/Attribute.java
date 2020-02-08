package com.cachetian.ums.application.model;

public class Attribute {
	private Principal principal;
	private String label;
	private String value;

	public Principal getPrincipal() {
		return principal;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setPrincipal(Principal principal) {
		this.principal = principal;
	}
}

package com.cachetian.ums.web.model;

import java.util.List;

public class Role {
    private String roleId;
    private String uniqueName;
    private String description;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getUniqueName() {
        return uniqueName;
    }

    public void setUniqueName(String uniqueName) {
        this.uniqueName = uniqueName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void updateRoleDescription(String roleDescription) {

    }

    public List<String> getAssignedActionNameList() {
        return null;
    }

    public List<String> getAssignedUserNameList() {
        return null;
    }

    public List<String> getAssignedGroupNameList() {
        return null;
    }
}

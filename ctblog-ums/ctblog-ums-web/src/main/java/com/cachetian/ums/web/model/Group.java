package com.cachetian.ums.web.model;

import java.util.List;

public class Group {
    private String groupId;
    private String uniqueName;
    private String description;
    private String parentGroupId;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
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

    public String getParentGroupId() {
        return parentGroupId;
    }

    public void setParentGroupId(String parentGroupId) {
        this.parentGroupId = parentGroupId;
    }

    public List<String> getAssignedUserNameList() {
        return null;
    }

    public List<String> getAssignedRoleNameList() {
        return null;
    }

    public List<String> getDirectSubGroupNameList() {
        return null;
    }
}

package com.cachetian.ums.web;

import com.cachetian.ums.web.model.Action;
import com.cachetian.ums.web.model.Group;
import com.cachetian.ums.web.model.Role;
import com.cachetian.ums.web.model.User;

import java.util.List;

public class UserManagementService {

    public User createNewUser(String uniqueName) {
        return null;
    }

    public User copyExistingUserToNewUser(String userId) {
        return null;
    }

    public User getUserByUserId(String userId) {
        return null;
    }

    public List<User> getUserListByDisplayName(String displayName) {
        return null;
    }

    public void deleteUser(String userId) {

    }

    public Role createNewRole(String roleUniqueName, String roleDescription) {
        return null;
    }

    public List<Role> getRoleListByNameDescription(String roleNameDescription) {
        return null;
    }

    public void deleteRole(String roleId) {

    }

    public Action createNewAction(String actionName) {
        return null;
    }

    public Group createNewGroup(String groupUniqueName, String groupDescription) {
        return null;
    }

    public List<Role> getGroupListByNameDescription(String groupNameDescription) {
        return null;
    }

    public void deleteGroup(String groupId) {

    }
}

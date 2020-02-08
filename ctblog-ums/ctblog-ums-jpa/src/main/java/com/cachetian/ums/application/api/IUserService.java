package com.cachetian.ums.application.api;

import java.util.List;

import com.cachetian.ums.application.model.User;

public interface IUserService {
	Long createUser(User newUser);

	void addToRoles(Long userId, List<String> roleIds);
	
	void removeFromRole(Long userId, Long roleId);

	void addToGroups(Long userId, List<String> groupIds);
	
	void removeFromGroup(Long userId, Long groupId);

	Long createUserWithAssociations(User newUserWithAssociations);

	void addToAssociations(Long userId, List<String> roleIds, List<String> groupIds);

	void updateUser(User user);
	
	void updateUserWithAssociations(User userWithAssociations);

	void removeUser(Long id);

	void removeUser(User user);

	User getUser(Long id);

	User getUserByUniqueName(String uniqueName);
	
	User getUserRoleAssociations();
	
	User getUserGroupAssociations();
	
	User getUserWithAssociations();
}

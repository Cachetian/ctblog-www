package com.cachetian.ums.application.model;

import java.util.List;

public class Group extends Principal {
	List<Group> subGroups;
	List<User> users;
	List<Role> roles;
}

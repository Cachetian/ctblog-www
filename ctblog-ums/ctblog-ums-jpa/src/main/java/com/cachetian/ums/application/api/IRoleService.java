package com.cachetian.ums.application.api;

import java.util.List;

import com.cachetian.ums.application.model.Role;

public interface IRoleService {

	List<Role> getRolesByUserUniqueName(String uniqeName);
}

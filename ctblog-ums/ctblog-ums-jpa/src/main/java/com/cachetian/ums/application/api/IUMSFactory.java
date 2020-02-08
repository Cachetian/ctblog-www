package com.cachetian.ums.application.api;

public interface IUMSFactory {
	IUserService createUserService();

	IRoleService createRoleService();
}

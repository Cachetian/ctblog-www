package com.cachetian.security.jaas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

import com.cachetian.ums.application.service.UMSFactory;

public class CtBasicLoginModule implements LoginModule {

	private CallbackHandler handler;
	private Subject subject;
	// private Map<String, ?> sharedState;
	// private Map<String, ?> options;
	private UserPrincipal userPrincipal;
	private List<String> roles;

	@Override
	public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState,
			Map<String, ?> options) {
		this.handler = callbackHandler;
		this.subject = subject;
		// this.sharedState = sharedState;
		// this.options = options;
	}

	@Override
	public boolean login() throws LoginException {
		Callback[] callbacks = new Callback[2];
		callbacks[0] = new NameCallback("login");
		callbacks[1] = new PasswordCallback("password", true);
		try {
			handler.handle(callbacks);
			String username = ((NameCallback) callbacks[0]).getName();
			String password = String.valueOf(((PasswordCallback) callbacks[1]).getPassword());
			if (username == null ) {
				throw new LoginException("No username");
			}
			if (password == null){
				throw new LoginException("No password");
			}
			if (!password.equals(UMSFactory.getInstance().createUserService().getUserByUniqueName(username).getPassword())) {
				throw new LoginException("Incorrect username and password");
			}
			// init context for commit
			this.userPrincipal = new UserPrincipal(username);
			this.roles = new ArrayList<String>();
			return true;
		} catch (IOException e) {
			throw new LoginException(e.getMessage());
		} catch (UnsupportedCallbackException e) {
			throw new LoginException(e.getMessage());
		}
	}

	@Override
	public boolean commit() throws LoginException {
		subject.getPrincipals().add(this.userPrincipal);
		if (this.roles != null && this.roles.size() > 0) {
			for (String role : this.roles) {
				RolePrincipal rolePrincipal = new RolePrincipal(role);
				subject.getPrincipals().add(rolePrincipal);
			}
		}
		return true;
	}

	@Override
	public boolean abort() throws LoginException {
		logout();
		return false;
	}

	@Override
	public boolean logout() throws LoginException {
		subject.getPrincipals().clear();
		this.subject = null;
		this.handler = null;
		return true;
	}
}

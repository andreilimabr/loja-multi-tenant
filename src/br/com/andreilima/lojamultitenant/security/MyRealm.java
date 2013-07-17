package br.com.andreilima.lojamultitenant.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyRealm extends AuthorizingRealm{

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo("andrei", new String("andrei").toCharArray(), getName());
		SimpleCredentialsMatcher simpleCredentialsMatcher = new SimpleCredentialsMatcher();
		boolean doCredentialsMatch = simpleCredentialsMatcher.doCredentialsMatch(token, info);
		if (doCredentialsMatch){
			return info;
		}
		throw new AuthenticationException();
	}

	

}

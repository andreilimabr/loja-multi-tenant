package br.com.andreilima.lojamultitenant.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
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
		UsernamePasswordToken userpass =(UsernamePasswordToken)token;
		String username = userpass.getUsername();
		char[] pass = userpass.getPassword();
		String password = String.copyValueOf(pass);
		if (username != null && password != null){
			if (username.equals("andrei") && password.equals("andrei")){
					return new SimpleAuthenticationInfo(username, pass, getName());
			}
		}
		return null;
	}

	

}

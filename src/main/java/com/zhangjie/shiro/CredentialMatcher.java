package com.zhangjie.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/***
 * @author zhangjie
 * @date 2019/4/7 22:54
 */
public class CredentialMatcher extends SimpleCredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken usernamePasswordToken=(UsernamePasswordToken)token;
        String password=new String(usernamePasswordToken.getPassword());
        String dbPassword=(String) info.getCredentials();
        return this.equals(password,dbPassword);
    }
}

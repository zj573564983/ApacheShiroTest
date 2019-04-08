package com.zhangjie.shiro;

import com.zhangjie.shiro.model.Permission;
import com.zhangjie.shiro.model.Role;
import com.zhangjie.shiro.model.User;
import com.zhangjie.shiro.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/***
 * @author zhangjie
 * @date 2019/4/7 16:59
 */
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user=(User)principalCollection.fromRealm(this.getClass().getName()).iterator().next();
        List<String> permissionList=new ArrayList<>();
        List<String> roleNameList=new ArrayList<>();
        Set<Role> roles=user.getRoles();
        if(!CollectionUtils.isEmpty(roles)){
            for(Role role:roles){
                roleNameList.add(role.getName());
                Set<Permission> permissionSet=role.getPermissions();
                if(!CollectionUtils.isEmpty(permissionSet)){
                    for(Permission permission:permissionSet){
                        permissionList.add(permission.getName());
                    }
                }
            }
        }
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.addStringPermissions(permissionList);
        info.addRoles(roleNameList);
        return info;
    }
    //认证登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken=(UsernamePasswordToken)authenticationToken;
        String username=usernamePasswordToken.getUsername();
        User user=userService.findByUsername(username);
        return new SimpleAuthenticationInfo(user,user.getPassword(),this.getClass().getName());
    }
}

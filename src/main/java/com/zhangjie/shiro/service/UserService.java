package com.zhangjie.shiro.service;

import com.zhangjie.shiro.model.User;

/***
 * @author zhangjie
 * @date 2019/4/7 16:33
 */
public interface UserService {

    User findByUsername(String name);
}

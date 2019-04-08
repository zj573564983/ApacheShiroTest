package com.zhangjie.shiro.service;

import com.zhangjie.shiro.mapper.UserMapper;
import com.zhangjie.shiro.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/***
 * @author zhangjie
 * @date 2019/4/7 16:35
 */
@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;
    @Override
    public User findByUsername(String name) {
        return userMapper.findByUsername(name);
    }
}

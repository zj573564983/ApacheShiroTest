package com.zhangjie.shiro.mapper;

import com.zhangjie.shiro.model.User;
import org.apache.ibatis.annotations.Param;

/***
 * @author zhangjie
 * @date 2019/4/7 16:31
 */
public interface UserMapper {

    User findByUsername(@Param("username") String username);
}

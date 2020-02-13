package com.casic.warehouse.dao;

import com.casic.warehouse.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface UserDao {
    //根据账号查询用户
    public User getUserByLoginName(@Param("loginName") String loginName);
}

package com.casic.warehouse.service;

import com.casic.warehouse.bean.User;
import com.casic.warehouse.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public User getUserByLoginName(String loginName){
        User user=userDao.getUserByLoginName(loginName);
        return user;
    }
}

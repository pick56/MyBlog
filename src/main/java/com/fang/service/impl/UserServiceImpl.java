package com.fang.service.impl;

import com.fang.model.User;
import com.fang.dao.UserDao;
import com.fang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public boolean login(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        int login = userDao.countByUser(user);
        //int login = 1 ;
        if (0 >= login) {
            return false;
        } else {
            return true;
        }
    }

    public User selectUser(int userId) {
        return this.userDao.selectByPrimaryKey(userId);
    }
}
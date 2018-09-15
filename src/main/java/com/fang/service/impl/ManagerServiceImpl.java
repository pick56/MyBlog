package com.fang.service.impl;

import com.fang.dao.UserDao;
import com.fang.model.User;
import com.fang.service.ManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service("ManagerService")
public class ManagerServiceImpl implements ManagerService {
    @Resource
    private  UserDao userDao ;
    @Override
    public ArrayList<User> getAllUser() {
        ArrayList<User> userlist = userDao.getAllUser() ;
        System.out.println(userlist);
        return userlist ;
    }
}

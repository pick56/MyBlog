package com.fang.dao;

import com.fang.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int countByUser(User record) ;

    ArrayList<User> getAllUser() ;
}
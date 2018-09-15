package com.fang.service;

import com.fang.model.User;

public interface UserService {
    /**
     * 用户登录情况
     *
     * @param username 用户名
     * @param password 密码
     */
    boolean login(String username, String password);

    public User selectUser(int id);
}

package com.powermock.helloworld.service;

import com.powermock.common.User;
import com.powermock.helloworld.dao.UserDao;

public class UserService {
    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public int queryUserCount() {
        return userDao.getCount();
    }

    public void saveUser(User user) {
        userDao.insertUser(user);
    }
}

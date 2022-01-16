package com.powermock.local.service;

import com.powermock.common.User;
import com.powermock.local.dao.UserDao;

public class UserService {

    public int queryUserCount() {
        UserDao userDao = new UserDao();
        return userDao.getCount();
    }

    public void saveUser(User user) {
        UserDao userDao = new UserDao();
        userDao.insertUser(user);
    }
}

package com.powermock.matcher.service;

import com.powermock.matcher.dao.UserDao;

public class UserService {

    public String find(String userName) {
        UserDao userDao = new UserDao();
        return userDao.query(userName);
    }
}

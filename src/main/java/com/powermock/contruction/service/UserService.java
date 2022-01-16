package com.powermock.contruction.service;

import com.powermock.common.User;
import com.powermock.contruction.dao.UserDao;

public class UserService {

    public void save(String userName, String password) {
        UserDao userDao = new UserDao(userName, password);
        userDao.insert();
    }
}

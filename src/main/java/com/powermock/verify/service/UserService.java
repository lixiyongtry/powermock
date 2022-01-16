package com.powermock.verify.service;

import com.powermock.common.User;
import com.powermock.verify.dao.UserDao;

public class UserService {

    public void saveOrUpdate(User user) {
        UserDao userDao = new UserDao();

        if (userDao.getCount(user) > 0) {
            userDao.updateUser(user);
        } else {
            userDao.insertUser(user);
        }
    }
}

package com.powermock.mockstatic.service;

import com.powermock.common.User;
import com.powermock.mockstatic.dao.UserDao;

public class UserService {

    public int queryUserCount() {
        return UserDao.getCount();
    }

    public void saveUser(User user) {
        UserDao.insertUser(user);
    }
}

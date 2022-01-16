package com.powermock.contruction.dao;

import com.powermock.common.User;

public class UserDao {
    private String userName;
    private String password;

    public UserDao(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public void insert() {
        throw new UnsupportedOperationException();
    }
}

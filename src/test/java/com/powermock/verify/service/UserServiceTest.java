package com.powermock.verify.service;

import com.powermock.common.User;
import com.powermock.verify.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class, UserDao.class})
public class UserServiceTest {

    @Test
    public void saveOrUpdateWillAddUser() {
        try {
            User user = PowerMockito.mock(User.class);
            UserDao userDao = PowerMockito.mock(UserDao.class);
            PowerMockito.whenNew(UserDao.class).withNoArguments().thenReturn(userDao);

            PowerMockito.when(userDao.getCount(user)).thenReturn(0);

            UserService userService = new UserService();
            userService.saveOrUpdate(user);

            Mockito.verify(userDao).insertUser(user);
            Mockito.verify(userDao, Mockito.never()).updateUser(user);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void saveOrUpdateWillUpdateUser() {
    }
}
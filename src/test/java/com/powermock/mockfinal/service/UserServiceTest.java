package com.powermock.mockfinal.service;

import com.powermock.common.User;
import com.powermock.mockfinal.dao.UserDao;
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
    public void queryUserCount() {
        UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.when(userDao.getCount()).thenReturn(10);

        UserService userService = new UserService(userDao);
        int result = userService.queryUserCount();
        assertEquals(10, result);

    }

    @Test
    public void saveUser() {
        User user = new User();
        UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.doNothing().when(userDao).insertUser(user);

        UserService userService = new UserService(userDao);
        userService.saveUser(user);
        Mockito.verify(userDao).insertUser(user);
    }
}
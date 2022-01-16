package com.powermock.local.service;
/**
 * 模拟局部变量
 */

import com.powermock.common.User;
import com.powermock.local.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class})

public class UserServiceTest {

    @Test
    public void queryUserCount() {
        try {
            UserService userService = new UserService();

            //mock局部变量
            UserDao userDao = mock(UserDao.class);
            whenNew(UserDao.class).withNoArguments().thenReturn(userDao);

            doReturn(10).when(userDao).getCount();
            int result = userService.queryUserCount();
            assertEquals(10, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void saveUser() {
        try {
            User user = new User();
            UserService userService = new UserService();
            UserDao userDao = mock(UserDao.class);
            whenNew(UserDao.class).withNoArguments().thenReturn(userDao);
            doNothing().when(userDao).insertUser(user);

            userService.saveUser(user);
            Mockito.verify(userDao, Mockito.times(1)).insertUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
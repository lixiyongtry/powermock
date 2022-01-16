package com.powermock.mockstatic.service;

import com.powermock.common.User;
import com.powermock.mockstatic.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class, UserDao.class})
public class UserServiceTest {

    @Test
    public void queryUserCount() {
        PowerMockito.mockStatic(UserDao.class);
        PowerMockito.when(UserDao.getCount()).thenReturn(10);

        UserService userService = new UserService();
        int resutl = userService.queryUserCount();
        assertEquals(10, resutl);
    }

    @Test
    public void saveUser() {
        PowerMockito.mockStatic(UserDao.class);
        User user = new User();
        PowerMockito.doNothing().when(UserDao.class);

        UserService userService = new UserService();
        userService.saveUser(user);

        PowerMockito.verifyStatic();
    }
}
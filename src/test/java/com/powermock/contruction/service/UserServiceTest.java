package com.powermock.contruction.service;

import com.powermock.contruction.dao.UserDao;
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
    public void save() throws Exception{
        UserDao userDao = PowerMockito.mock(UserDao.class);
        String userName = "zhangsan";
        String password = "123456";

        PowerMockito.whenNew(UserDao.class).withArguments(userName, password).thenReturn(userDao);

        PowerMockito.doNothing().when(userDao).insert();

        UserService userService = new UserService();
        userService.save(userName, password);

        Mockito.verify(userDao).insert();


    }
}
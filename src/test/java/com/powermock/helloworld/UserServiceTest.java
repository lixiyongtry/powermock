package com.powermock.helloworld;

import com.powermock.common.User;
import com.powermock.helloworld.dao.UserDao;
import com.powermock.helloworld.service.UserService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;

import static org.junit.Assert.*;

public class UserServiceTest {

    private UserService userService;

    @Mock
    private UserDao userDao;

    @Before
    public void setUp() {
        userService = new UserService(new UserDao());
    }

    @Ignore
    @Test
    public void testQueryUserCountWithPowermock() {
        UserDao uDao = PowerMockito.mock(UserDao.class);
        PowerMockito.when(uDao.getCount()).thenReturn(10);
        UserService service = new UserService(uDao);
        int result = service.queryUserCount();
        assertEquals(10, result);
    }

    @Test
    public void testSaveUserWithPosermock() {
        UserDao uDao = PowerMockito.mock(UserDao.class);
        User user = new User();
        PowerMockito.doNothing().when(uDao).insertUser(user);
        UserService service = new UserService(uDao);
        service.saveUser(user);
        //是否调用了这个方法
        Mockito.verify(uDao).insertUser(user);

    }

    @Ignore
    @Test
    public void testQueryUserCountWithMockito() {
        MockitoAnnotations.initMocks(this);
        UserService service = new UserService(userDao);
        Mockito.when(userDao.getCount()).thenReturn(10);
        assertEquals(10, userDao.getCount());

    }

    @Ignore
    @Test
    public void queryUserCountWithJunit() {

        int count = 0;
        try {
            count = userService.queryUserCount();
        } catch (Exception e) {
            assertTrue(e instanceof UnsupportedOperationException);
        }
    }
    @Ignore
    @Test
    public void saveUserWithJunit() throws Exception{
        try {
            userService.saveUser(new User());
        } catch (Exception e) {
            assertTrue(e instanceof UnsupportedOperationException);
        }
    }
}
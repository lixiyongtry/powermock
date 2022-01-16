package com.powermock.matcher.service;

import com.powermock.matcher.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class, UserDao.class})
public class UserServiceTest {

    @Test
    public void find() throws Exception{

        UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);

        PowerMockito.when(userDao.query(Matchers.argThat(new MyArgumentMatcher()))).thenReturn("zhangsan");

        UserService userService = new UserService();
        assertEquals("zhangsan", userService.find("alex"));
        assertEquals("zhangsan", userService.find("jacky"));

    }

    @Test
    public void testFindWithAnswer() throws Exception{
        UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);

        PowerMockito.when(userDao.query(Mockito.anyString())).then(invocationOnMock -> {
           String arg = (String) invocationOnMock.getArguments()[0];
           switch (arg) {
               case "jacky":
                   return "i m jacky";
               case "alex":
                   return "i m alex";
               default:
                   throw new RuntimeException("not support" + arg);
           }
        });

        UserService service = new UserService();
        assertEquals("i m jacky" ,service.find("jacky"));
        assertEquals("i m alex", service.find("alex"));

        try {
            String anyValue = service.find("any");
            fail("never process here");
        } catch (Exception e) {
            assertTrue(e instanceof RuntimeException);
        }
    }

    static class MyArgumentMatcher extends ArgumentMatcher<String> {
        @Override
        public boolean matches(Object o) {
            String arg = (String) o;
            switch (arg) {
                case "alex":
                case "jacky":
                case "van":
                case "tony":
                    return true;
                default:
                    return false;

            }
        }
    }
}
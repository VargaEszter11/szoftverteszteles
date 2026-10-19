package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void mockedUserReturnsConfiguredData() {
        User user = mock(User.class);

        when(user.getUserName()).thenReturn("TesztElek");
        when(user.getPassword()).thenReturn("TOPSECRET");
        when(user.isLoggedIn()).thenReturn(true);
        when(user.getId()).thenReturn(123);

        assertEquals("TesztElek", user.getUserName());
        assertEquals("TOPSECRET", user.getPassword());
        assertTrue(user.isLoggedIn());
        assertEquals(123, user.getId());

        verify(user).getUserName();
        verify(user).getPassword();
        verify(user).isLoggedIn();
        verify(user).getId();
    }

    @Test
    void updatePwdCallsDatabase() {
        UserDatabase userDatabase = mock(UserDatabase.class);
        User user = new User(userDatabase);

        user.updatePwd("newPwd", true);

        verify(userDatabase).setPassword(user.getId(), "newPwd");
        assertEquals("newPwd", user.getPassword());
    }
}

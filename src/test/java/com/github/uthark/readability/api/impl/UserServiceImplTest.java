package com.github.uthark.readability.api.impl;

import com.github.uthark.readability.AbstractReadabilityTest;
import com.github.uthark.readability.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Oleg Atamanenko
 * @since 1/23/13
 */
public class UserServiceImplTest extends AbstractReadabilityTest {

    private UserServiceImpl userService;

    @BeforeMethod
    public void init() {
        userService = new UserServiceImpl(instance);
    }

    @Test
    public void testGetCurrentUser() throws Exception {
        User currentUser = userService.getCurrentUser();

        Assert.assertNotNull(currentUser);
    }
}

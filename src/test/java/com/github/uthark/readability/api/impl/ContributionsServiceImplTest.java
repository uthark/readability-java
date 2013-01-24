package com.github.uthark.readability.api.impl;

import com.github.uthark.readability.AbstractReadabilityTest;
import com.github.uthark.readability.api.ContributionsService;
import com.github.uthark.readability.model.ContributionsFilter;
import com.github.uthark.readability.model.ContributionsResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Oleg Atamanenko
 * @since 1/24/13
 */
public class ContributionsServiceImplTest extends AbstractReadabilityTest {

    private ContributionsService contributionsService;

    @BeforeMethod
    public void init() {
        contributionsService = new ContributionsServiceImpl(instance);
    }

    @Test
    public void testGetContributions() throws Exception {

        ContributionsResponse response = contributionsService.getContributions(new ContributionsFilter());

        Assert.assertNotNull(response);
    }
}

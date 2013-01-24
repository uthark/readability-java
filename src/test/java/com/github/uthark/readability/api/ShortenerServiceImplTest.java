package com.github.uthark.readability.api;

import com.github.uthark.readability.AbstractReadabilityTest;
import com.github.uthark.readability.ReadabilityException;
import com.github.uthark.readability.api.impl.ShortenerServiceImpl;
import com.github.uthark.readability.model.ShortenerResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Oleg Atamanenko
 * @since 1/24/13
 */
public class ShortenerServiceImplTest extends AbstractReadabilityTest {

    private ShortenerService shortenerService;

    @BeforeMethod
    public void init() {
        shortenerService = new ShortenerServiceImpl(instance);
    }

    @Test
    public void testShorten() throws Exception {
        ShortenerResponse response =
                shortenerService.shorten("http://en.wikipedia.org/wiki/Comparison_of_file_systems");

        Assert.assertNotNull(response);

        Assert.assertTrue(response.getSuccess());

        String articleId = response.getMeta().getId();

        ShortenerResponse details = shortenerService.getDetails(articleId);

        Assert.assertNotNull(details);

        Assert.assertNotNull(details.getMeta().getArticle());
    }

    @Test(expectedExceptions = ReadabilityException.class)
    public void testGetUnknown() throws Exception {
        shortenerService.getDetails("unknown article id");
    }
}

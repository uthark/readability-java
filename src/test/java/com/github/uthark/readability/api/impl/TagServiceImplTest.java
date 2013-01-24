package com.github.uthark.readability.api.impl;

import com.github.uthark.readability.AbstractReadabilityTest;
import com.github.uthark.readability.ReadabilityException;
import com.github.uthark.readability.model.Tag;
import com.github.uthark.readability.model.TagsResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Oleg Atamanenko
 * @since 1/23/13
 */
public class TagServiceImplTest extends AbstractReadabilityTest {

    private TagServiceImpl tagService;

    @BeforeMethod
    public void setUp() throws Exception {

        tagService = new TagServiceImpl(instance);
    }

    @Test
    public void testGetTags() throws Exception {
        TagsResponse tags = tagService.getTags();

        for (Tag tag : tags) {
            Tag fetchedTag = tagService.getTag(tag.getId());
            Assert.assertNotNull(fetchedTag);
        }
        Assert.assertNotNull(tags);
    }

    @Test(expectedExceptions = ReadabilityException.class)
    public void testGetUnknownTag() throws Exception {
        tagService.getTag(1L);
    }

    @Test(expectedExceptions = ReadabilityException.class)
    public void testDeleteUnknownTag() throws Exception {
        tagService.deleteTag(1L);
    }


}

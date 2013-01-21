package com.github.uthark.readability.api.impl;

import com.github.uthark.readability.AbstractReadabilityTest;
import com.github.uthark.readability.api.BookmarksService;
import com.github.uthark.readability.model.AddBookmarkResponse;
import com.github.uthark.readability.model.Bookmark;
import com.github.uthark.readability.model.BookmarksResponse;
import com.github.uthark.readability.model.Conditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author <a href="mailto:oatamanenko@eastbanctech.com">Oleg Atamanenko</a>
 * @since 1/20/13
 */
public class BookmarksServiceImplTest extends AbstractReadabilityTest {

    private BookmarksService bookmarksService;

    @BeforeMethod
    public void setUp() throws Exception {
        bookmarksService = new BookmarksServiceImpl(instance);

    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetBookmarks() throws Exception {

        BookmarksResponse bookmarksResponse = bookmarksService.getBookmarks(new Conditions());

        Assert.assertNotNull(bookmarksResponse);
    }

    @Test
    public void testAddBookmark() throws Exception {
        AddBookmarkResponse response = bookmarksService.addBookmark("http://habrahabr.ru/post/166291/", false, false);
        Assert.assertNotNull(response);
    }

    @Test
    public void testGetBookmark() throws Exception {
        AddBookmarkResponse response =
                bookmarksService.addBookmark("http://habrahabr.ru/post/166413/#comment_5752005", false, false);
        Bookmark bookmark = bookmarksService.getBookmark(response.getBookmarkId());
        Assert.assertNotNull(bookmark);
    }
}

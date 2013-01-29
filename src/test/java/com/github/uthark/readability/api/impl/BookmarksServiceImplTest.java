package com.github.uthark.readability.api.impl;

import com.github.uthark.readability.AbstractReadabilityTest;
import com.github.uthark.readability.ReadabilityException;
import com.github.uthark.readability.api.BookmarksService;
import com.github.uthark.readability.model.AddBookmarkResponse;
import com.github.uthark.readability.model.Bookmark;
import com.github.uthark.readability.model.BookmarkFilter;
import com.github.uthark.readability.model.BookmarksResponse;
import com.github.uthark.readability.model.Tag;
import com.github.uthark.readability.model.TagsResponse;
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

        BookmarkFilter bookmarkFilter = new BookmarkFilter();
        bookmarkFilter.setArchive(true);
        BookmarksResponse bookmarksResponse = bookmarksService.getBookmarks(bookmarkFilter);

        Assert.assertNotNull(bookmarksResponse);
    }

    @Test
    public void testAddBookmark() throws Exception {
        AddBookmarkResponse response = bookmarksService.addBookmark("http://habrahabr.ru/post/166291/", false, false);
        Assert.assertNotNull(response);

        bookmarksService.deleteBookmark(response.getBookmarkId());
    }

    @Test
    public void testGetBookmark() throws Exception {
        AddBookmarkResponse response =
                bookmarksService.addBookmark("http://en.wikipedia.org/wiki/Readability", false, false);
        Bookmark bookmark = bookmarksService.getBookmark(response.getBookmarkId());
        Assert.assertNotNull(bookmark);

        Bookmark updated = bookmarksService.updateBookmark(bookmark.getId(), true, true, 0.5);
        Assert.assertTrue(updated.getFavorite());
        Assert.assertTrue(updated.getArchive());
        Assert.assertEquals(updated.getReadPercent(), 0.5, 0.01);

        bookmarksService.deleteBookmark(bookmark.getId());

        try {
            bookmarksService.getBookmark(bookmark.getId());
        } catch (ReadabilityException e) {
            Assert.assertEquals(e.getCode(), 404);
        }
    }

    @Test
    public void testTags() throws Exception {
        AddBookmarkResponse response =
                bookmarksService.addBookmark("http://en.wikipedia.org/wiki/Rova_of_Antananarivo", false, false);

        if (null == response.getArticleLocation()) {
            bookmarksService.deleteBookmark(response.getBookmarkId());
            response =
                    bookmarksService.addBookmark("http://en.wikipedia.org/wiki/Rova_of_Antananarivo", false, false);
        }

        TagsResponse tags1 = bookmarksService.addTags(response.getBookmarkId(), "my tag 1", "my tag 2", "my tag 3");

        Assert.assertNotNull(tags1);
        Assert.assertEquals(tags1.getTags().size(), 3);

        TagsResponse tags2 = bookmarksService.addTags(response.getBookmarkId(), "my tag 3", "new tag");
        Assert.assertEquals(tags2.getTags().size(), 1);

        TagsResponse toDelete = bookmarksService.getTags(response.getBookmarkId());

        for (Tag tag : toDelete) {
            bookmarksService.removeTag(response.getBookmarkId(), tag.getId());
        }


    }
}

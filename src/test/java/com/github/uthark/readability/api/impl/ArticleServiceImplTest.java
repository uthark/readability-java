package com.github.uthark.readability.api.impl;

import com.github.uthark.readability.AbstractReadabilityTest;
import com.github.uthark.readability.model.AddBookmarkResponse;
import com.github.uthark.readability.model.Article;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Oleg Atamanenko
 * @since 1/23/13
 */
public class ArticleServiceImplTest extends AbstractReadabilityTest {

    private ArticleServiceImpl articleService;

    private BookmarksServiceImpl bookmarksService;

    @BeforeMethod
    public void setup() {
        articleService = new ArticleServiceImpl(instance);
        bookmarksService = new BookmarksServiceImpl(instance);
    }

    @Test
    public void testGetArticle() throws Exception {
        AddBookmarkResponse addBookmarkResponse =
                bookmarksService.addBookmark("http://en.wikipedia.org/wiki/Ranavalona_III", true, false);

        Article article = articleService.getArticle(addBookmarkResponse.getArticleId());

        Assert.assertNotNull(article);

        bookmarksService.deleteBookmark(addBookmarkResponse.getBookmarkId());

    }
}

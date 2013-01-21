package com.github.uthark.readability.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="mailto:oatamanenko@eastbanctech.com">Oleg Atamanenko</a>
 * @since 1/21/13
 */
public class AddBookmarkResponse {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddBookmarkResponse.class);

    private String bookmarkLocation;

    private String articleLocation;

    private Long bookmarkId;

    public AddBookmarkResponse(String bookmarkLocation, String articleLocation) {

        this.bookmarkLocation = bookmarkLocation;
        this.articleLocation = articleLocation;
    }

    public String getBookmarkLocation() {
        return bookmarkLocation;
    }

    public String getArticleLocation() {
        return articleLocation;
    }

    public Long getBookmarkId() {
        if (null == bookmarkId) {
            int i = bookmarkLocation.lastIndexOf('/');
            bookmarkId = Long.valueOf(bookmarkLocation.substring(i + 1));
        }
        return bookmarkId;
    }
}

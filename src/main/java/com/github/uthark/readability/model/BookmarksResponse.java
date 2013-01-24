package com.github.uthark.readability.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author <a href="mailto:oatamanenko@eastbanctech.com">Oleg Atamanenko</a>
 * @since 1/20/13
 */
public class BookmarksResponse {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookmarksResponse.class);

    @JsonProperty("bookmarks")
    private List<Bookmark> bookmarks;

    @JsonProperty("meta")
    private Meta meta;

    @JsonProperty("conditions")
    private BookmarkFilter bookmarkFilter;

    @JsonAnySetter()
    public void setUnknownProperty(String key, Object value) {
        LOGGER.warn("Setting unknown {}={}", key, value);
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<Bookmark> getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(List<Bookmark> bookmarks) {
        this.bookmarks = bookmarks;
    }

    public BookmarkFilter getBookmarkFilter() {
        return bookmarkFilter;
    }

    public void setBookmarkFilter(BookmarkFilter bookmarkFilter) {
        this.bookmarkFilter = bookmarkFilter;
    }
}

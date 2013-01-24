package com.github.uthark.readability.api;

import com.github.uthark.readability.model.AddBookmarkResponse;
import com.github.uthark.readability.model.Bookmark;
import com.github.uthark.readability.model.BookmarkFilter;
import com.github.uthark.readability.model.BookmarksResponse;
import com.github.uthark.readability.model.TagsResponse;

import java.io.IOException;

/**
 * @author <a href="mailto:oleg.atamanenko@gmail.com">Oleg Atamanenko</a>
 * @since 1/20/13
 */
public interface BookmarksService {

    BookmarksResponse getBookmarks(BookmarkFilter bookmarkFilter) throws IOException;

    Bookmark getBookmark(Long bookmarkId) throws IOException;

    AddBookmarkResponse addBookmark(String url, boolean favorite, boolean archive) throws IOException;

    void deleteBookmark(Long bookmarkId) throws IOException;

    Bookmark updateBookmark(Long bookmarkId, boolean favorite, boolean archive, double readPercent) throws IOException;

    TagsResponse getTags(Long bookmarkId) throws IOException;

    TagsResponse addTags(Long bookmarkId, String... newTags) throws IOException;

    void removeTag(Long bookmarkId, Long tagId) throws IOException;
}

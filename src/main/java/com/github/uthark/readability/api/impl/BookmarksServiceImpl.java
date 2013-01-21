package com.github.uthark.readability.api.impl;

import com.github.uthark.readability.ReadabilityException;
import com.github.uthark.readability.api.BookmarksService;
import com.github.uthark.readability.model.AddBookmarkResponse;
import com.github.uthark.readability.model.Bookmark;
import com.github.uthark.readability.model.BookmarksResponse;
import com.github.uthark.readability.model.Conditions;
import com.github.uthark.readability.parser.ResponseParser;
import com.github.uthark.readability.xauth.OAuthRequest;
import com.github.uthark.readability.xauth.Readability;
import org.scribe.model.Response;
import org.scribe.model.Verb;

import java.io.IOException;
import java.io.StringReader;

/**
 * @author <a href="mailto:oatamanenko@eastbanctech.com">Oleg Atamanenko</a>
 * @since 1/20/13
 */
public class BookmarksServiceImpl implements BookmarksService {

    public static final int HTTP_CODE_ACCEPTED = 202;

    public static final String HEADER_LOCATION = "Location";

    public static final String HEADER_ARTICLE_LOCATION = "X-Article-Location";

    private static final String BOOKMARKS_URL = "https://www.readability.com/api/rest/v1/bookmarks";

    private Readability readability;

    private ResponseParser responseParser = new ResponseParser();

    public BookmarksServiceImpl(Readability readability) {
        this.readability = readability;
    }

    @Override
    public BookmarksResponse getBookmarks(Conditions conditions) throws IOException {
        OAuthRequest request = new OAuthRequest(Verb.GET, BOOKMARKS_URL);
        Response response = readability.executeRequest(request);
        String responseBody = response.getBody();

        StringReader reader = new StringReader(responseBody);
        return responseParser.parse(reader, BookmarksResponse.class);
    }

    public Bookmark getBookmark(Long bookmarkId) throws IOException {
        OAuthRequest request = new OAuthRequest(Verb.GET, BOOKMARKS_URL + "/" + bookmarkId);
        Response response = readability.executeRequest(request);
        String responseBody = response.getBody();

        StringReader reader = new StringReader(responseBody);
        return responseParser.parse(reader, Bookmark.class);
    }

    @Override
    public AddBookmarkResponse addBookmark(String url, boolean favorite, boolean archive) throws IOException {

        // TODO: Extract article location.
        // X-Article-Location=/api/rest/v1/articles/bjvf8w1p
        OAuthRequest request = new OAuthRequest(Verb.POST, BOOKMARKS_URL);
        request.addBodyParameter("url", url);
        request.addQuerystringParameter("favorite", String.valueOf(favorite ? 1 : 0));
        request.addQuerystringParameter("archive", String.valueOf(archive ? 1 : 0));
        Response response = readability.executeRequest(request);

        if (response.getCode() == HTTP_CODE_ACCEPTED) {
            String bookmarkLocation = response.getHeader(HEADER_LOCATION);
            String articleLocation = response.getHeader(HEADER_ARTICLE_LOCATION);

            return new AddBookmarkResponse(bookmarkLocation, articleLocation);

        } else {
            String body = response.getBody();
            throw new ReadabilityException(response.getCode(), body);
        }

    }
}

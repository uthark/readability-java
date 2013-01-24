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

    public static final String PARAM_FAVORITE = "favorite";

    public static final String PARAM_ARCHIVE = "archive";

    public static final String PARAM_URL = "url";

    public static final String PARAM_READ_PERCENT = "read_percent";

    private static final String BOOKMARKS_URL = "https://www.readability.com/api/rest/v1/bookmarks";

    private static final int HTTP_CODE_NO_CONTENT = 204;

    private static final int HTTP_CODE_OK = 200;

    private static final int HTTP_CODE_CONFLICT = 409;

    private static final int HTTP_CODE_NOT_FOUND = 404;

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
        OAuthRequest request = new OAuthRequest(Verb.GET, buildUrl(bookmarkId));
        Response response = readability.executeRequest(request);

        if (response.getCode() == HTTP_CODE_NOT_FOUND) {
            throw new ReadabilityException(response.getCode(), "Bookmark with id=" + bookmarkId + " was not found");
        }

        String responseBody = response.getBody();

        StringReader reader = new StringReader(responseBody);
        return responseParser.parse(reader, Bookmark.class);
    }

    private String buildUrl(Long bookmarkId) {
        return BOOKMARKS_URL + "/" + bookmarkId;
    }

    @Override
    public AddBookmarkResponse addBookmark(String url, boolean favorite, boolean archive) throws IOException {

        // TODO: Extract article location.
        // X-Article-Location=/api/rest/v1/articles/bjvf8w1p
        OAuthRequest request = new OAuthRequest(Verb.POST, BOOKMARKS_URL);
        request.addBodyParameter(PARAM_URL, url);
        request.addBodyParameter(PARAM_FAVORITE, toString(favorite));
        request.addBodyParameter(PARAM_ARCHIVE, toString(archive));
        Response response = readability.executeRequest(request);

        if (response.getCode() == HTTP_CODE_ACCEPTED) {
            String bookmarkLocation = response.getHeader(HEADER_LOCATION);
            String articleLocation = response.getHeader(HEADER_ARTICLE_LOCATION);

            return new AddBookmarkResponse(bookmarkLocation, articleLocation);

        } else if (response.getCode() == HTTP_CODE_CONFLICT) {
            String bookmarkLocation = response.getHeader(HEADER_LOCATION);
            return new AddBookmarkResponse(bookmarkLocation, null);
        } else {
            String body = response.getBody();
            throw new ReadabilityException(response.getCode(), body);
        }

    }

    private String toString(boolean favorite) {
        return String.valueOf(favorite ? 1 : 0);
    }

    @Override
    public void deleteBookmark(Long bookmarkId) throws IOException {
        OAuthRequest request = new OAuthRequest(Verb.DELETE, buildUrl(bookmarkId));
        Response response = readability.executeRequest(request);
        if (response.getCode() != HTTP_CODE_NO_CONTENT) {
            throw new ReadabilityException(response.getCode(), "Unable to delete bookmark with id=" + bookmarkId);
        }
    }

    @Override
    public Bookmark updateBookmark(Long bookmarkId, boolean favorite, boolean archive, double readPercent)
            throws IOException {
        OAuthRequest request = new OAuthRequest(Verb.POST, buildUrl(bookmarkId));

        request.addBodyParameter(PARAM_FAVORITE, toString(favorite));
        request.addBodyParameter(PARAM_ARCHIVE, toString(archive));

        // TODO: Maybe we should normalize representation of read percent.
        request.addBodyParameter(PARAM_READ_PERCENT, String.valueOf(readPercent));

        Response response = readability.executeRequest(request);

        if (response.getCode() != HTTP_CODE_OK) {
            throw new ReadabilityException(response.getCode(), "Unable to update bookmark with id=" + bookmarkId);
        }

        String responseBody = response.getBody();

        return responseParser.parse(new StringReader(responseBody), Bookmark.class);
    }
}

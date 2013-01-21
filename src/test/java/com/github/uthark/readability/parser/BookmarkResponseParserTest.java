package com.github.uthark.readability.parser;

import com.github.uthark.readability.model.BookmarksResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author <a href="mailto:oatamanenko@eastbanctech.com">Oleg Atamanenko</a>
 * @since 1/20/13
 */
public class BookmarkResponseParserTest {

    @Test
    public void testParse() throws IOException {

        InputStreamReader reader =
                new InputStreamReader(getClass().getClassLoader().getResourceAsStream("bookmarks.response.json"));

        ResponseParser parser = new ResponseParser();

        BookmarksResponse response = parser.parse(reader, BookmarksResponse.class);

        Assert.assertNotNull(response);
    }

}

package com.github.uthark.readability.api.impl;

import com.github.uthark.readability.ReadabilityException;
import com.github.uthark.readability.api.TagService;
import com.github.uthark.readability.model.Tag;
import com.github.uthark.readability.model.TagsResponse;
import com.github.uthark.readability.parser.ResponseParser;
import com.github.uthark.readability.xauth.OAuthRequest;
import com.github.uthark.readability.xauth.Readability;
import org.scribe.model.Response;
import org.scribe.model.Verb;

import java.io.IOException;
import java.io.StringReader;

/**
 * @author Oleg Atamanenko
 * @since 1/23/13
 */
public class TagServiceImpl implements TagService {

    private static final String TAGS_URL = "https://www.readability.com/api/rest/v1/tags";

    private Readability readability;

    private ResponseParser responseParser = new ResponseParser();

    public TagServiceImpl(Readability readability) {
        this.readability = readability;
    }

    @Override
    public TagsResponse getTags() throws IOException {
        OAuthRequest request = new OAuthRequest(Verb.GET, TAGS_URL);
        Response response = readability.executeRequest(request);

        String body = response.getBody();
        return responseParser.parse(new StringReader(body), TagsResponse.class);
    }

    @Override
    public Tag getTag(Long tagId) throws IOException {
        OAuthRequest request = new OAuthRequest(Verb.GET, buildUrl(tagId));
        Response response = readability.executeRequest(request);
        if (response.getCode() != HttpCode.HTTP_CODE_OK) {
            throw new ReadabilityException(response.getCode(), response.getBody());
        }
        String body = response.getBody();
        return responseParser.parse(new StringReader(body), Tag.class);
    }

    private String buildUrl(Long tagId) {
        return TAGS_URL + "/" + tagId;
    }

    @Override
    public void deleteTag(Long tagId) {
        OAuthRequest request = new OAuthRequest(Verb.DELETE, buildUrl(tagId));
        Response response = readability.executeRequest(request);
        if (response.getCode() != HttpCode.HTTP_CODE_NO_CONTENT) {
            throw new ReadabilityException(response.getCode(), response.getBody());
        }
    }
}

package com.github.uthark.readability.api.impl;

import com.github.uthark.readability.api.ShortenerService;
import com.github.uthark.readability.model.ShortenerResponse;
import com.github.uthark.readability.parser.ResponseParser;
import com.github.uthark.readability.xauth.OAuthRequest;
import com.github.uthark.readability.xauth.Readability;
import org.scribe.model.Response;
import org.scribe.model.Verb;

import java.io.IOException;
import java.io.StringReader;

/**
 * @author Oleg Atamanenko
 * @since 1/24/13
 */
public class ShortenerServiceImpl implements ShortenerService {

    public static final String SHORTENER_URL = "http://www.readability.com/api/shortener/v1/urls";

    private Readability readability;

    private ResponseParser responseParser;

    public ShortenerServiceImpl(Readability readability) {
        this.readability = readability;
        responseParser = new ResponseParser();
    }

    @Override
    public ShortenerResponse shorten(String url) throws IOException {
        OAuthRequest request = new OAuthRequest(Verb.POST, SHORTENER_URL);
        request.addBodyParameter("url", url);

        Response response = readability.executeRequest(request);

        String body = response.getBody();
        StringReader reader = new StringReader(body);
        return responseParser.parse(reader, ShortenerResponse.class);
    }

    @Override
    public ShortenerResponse getDetails(String articleId) throws IOException {
        OAuthRequest request = new OAuthRequest(Verb.GET, SHORTENER_URL + '/' + articleId);

        Response response = readability.executeRequest(request);

        String body = response.getBody();
        StringReader reader = new StringReader(body);
        return responseParser.parse(reader, ShortenerResponse.class);
    }
}

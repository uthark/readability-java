package com.github.uthark.readability.api.impl;

import com.github.uthark.readability.api.ContributionsService;
import com.github.uthark.readability.model.ContributionsFilter;
import com.github.uthark.readability.model.ContributionsResponse;
import com.github.uthark.readability.parser.ResponseParser;
import com.github.uthark.readability.xauth.OAuthRequest;
import com.github.uthark.readability.xauth.Readability;
import org.scribe.model.Response;
import org.scribe.model.Verb;

import java.io.IOException;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Oleg Atamanenko
 * @since 1/24/13
 */
public class ContributionsServiceImpl implements ContributionsService {

    public static final String CONTRIBUTIONS_URL = "https://www.readability.com/api/rest/v1/contributions";

    private Readability readability;

    private ResponseParser responseParser;

    public ContributionsServiceImpl(Readability readability) {
        this.readability = readability;
        responseParser = new ResponseParser();
    }

    @Override
    public ContributionsResponse getContributions(ContributionsFilter contributionsFilter) throws IOException {
        OAuthRequest request = new OAuthRequest(Verb.GET, CONTRIBUTIONS_URL);

        addParam(request, "since", toString(contributionsFilter.getSince()));
        addParam(request, "until", toString(contributionsFilter.getUntil()));
        addParam(request, "domain", contributionsFilter.getDomain());
        addParam(request, "page", toString(contributionsFilter.getPage()));
        addParam(request, "per_page", toString(contributionsFilter.getPerPage()));

        Response response = readability.executeRequest(request);

        String body = response.getBody();
        StringReader reader = new StringReader(body);
        return responseParser.parse(reader, ContributionsResponse.class);
    }

    private String toString(Date addedSince) {
        if (null == addedSince) {
            return null;
        }
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(addedSince);
    }

    private String toString(Integer page) {
        if (null == page) {
            return null;
        }
        return String.valueOf(page);
    }

    private void addParam(OAuthRequest request, String name, String value) {
        if (null != value) {
            request.addQuerystringParameter(name, value);
        }
    }

}

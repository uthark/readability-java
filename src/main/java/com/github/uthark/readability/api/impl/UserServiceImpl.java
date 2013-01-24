package com.github.uthark.readability.api.impl;

import com.github.uthark.readability.api.UserService;
import com.github.uthark.readability.model.User;
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
public class UserServiceImpl implements UserService {

    private static final String USER_INFO_URL = "https://www.readability.com/api/rest/v1/users/_current";

    private Readability readability;

    private ResponseParser responseParser = new ResponseParser();

    public UserServiceImpl(Readability readability) {
        this.readability = readability;
    }

    @Override
    public User getCurrentUser() throws IOException {
        OAuthRequest request = new OAuthRequest(Verb.GET, USER_INFO_URL);

        Response response = readability.executeRequest(request);

        String body = response.getBody();

        return responseParser.parse(new StringReader(body), User.class);

    }
}

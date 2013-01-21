package com.github.uthark.readability.xauth;

import org.scribe.builder.api.DefaultApi10a;
import org.scribe.model.OAuthConfig;
import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;

/**
 * @author <a href="mailto:oatamanenko@eastbanctech.com">Oleg Atamanenko</a>
 * @since 1/19/13
 */
public class ReadabilityApi extends DefaultApi10a {

    @Override
    public String getRequestTokenEndpoint() {
        return "https://www.readability.com/api/rest/v1/oauth/request_token/";

    }

    @Override
    public String getAccessTokenEndpoint() {
        return "https://www.readability.com/api/rest/v1/oauth/access_token/";
    }

    @Override
    public String getAuthorizationUrl(Token requestToken) {
        return "https://www.readability.com/api/rest/v1/oauth/authorize/";
    }

    @Override
    public OAuthService createService(OAuthConfig config) {

        return new XAuth10aServiceImpl(this, config);
    }
}

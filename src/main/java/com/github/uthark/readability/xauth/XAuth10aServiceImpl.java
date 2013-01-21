package com.github.uthark.readability.xauth;

import org.scribe.builder.api.DefaultApi10a;
import org.scribe.model.OAuthConfig;
import org.scribe.model.OAuthConstants;
import org.scribe.model.RequestTuner;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuth10aServiceImpl;
import org.scribe.utils.MapUtils;

import java.util.Map;

/**
 * @author <a href="mailto:oatamanenko@eastbanctech.com">Oleg Atamanenko</a>
 * @since 1/19/13
 */
public class XAuth10aServiceImpl extends OAuth10aServiceImpl {

    private final DefaultApi10a api;

    private final XAuthConfig config;

    /**
     * Default constructor
     *
     * @param api    OAuth1.0a api information
     * @param config OAuth 1.0a configuration param object
     */
    public XAuth10aServiceImpl(DefaultApi10a api, OAuthConfig config) {
        super(api, config);
        this.api = api;
        this.config = (XAuthConfig) config;
    }

    public Token getRequestToken(RequestTuner tuner) {
        config.log("obtaining request token from " + api.getRequestTokenEndpoint());
        OAuthRequest
                request = new OAuthRequest(api.getRequestTokenVerb(), api.getRequestTokenEndpoint());


        config.log("setting oauth_callback to " + config.getCallback());
        request.addOAuthParameter(OAuthConstants.CALLBACK, config.getCallback());

        addOAuthParams(request, OAuthConstants.EMPTY_TOKEN);
        appendSignature(request);

        config.log("sending request...");
        Response response = request.send(tuner);
        String body = response.getBody();

        config.log("response status code: " + response.getCode());
        config.log("response body: " + body);
        return api.getRequestTokenExtractor().extract(body);
    }

    @Override
    public Token getAccessToken(Token requestToken, Verifier verifier, RequestTuner tuner) {
        config.log("obtaining access token from " + api.getAccessTokenEndpoint());
        OAuthRequest request = new OAuthRequest(api.getAccessTokenVerb(), api.getAccessTokenEndpoint());
        request.addBodyParameter("x_auth_username", config.getXAuthParams().getUsername());
        request.addBodyParameter("x_auth_password", config.getXAuthParams().getPassword());
        request.addBodyParameter("x_auth_mode", "client_auth");

        config.log("setting token to: " + requestToken + " and verifier to: " + verifier);
//        request.addOAuthParameter(OAuthConstants.TOKEN, requestToken.getToken());
        request.addOAuthParameter(OAuthConstants.VERIFIER, verifier.getValue());
        addOAuthParams(request, requestToken);

        appendSignature(request);


        Response response = request.send(tuner);
        return api.getAccessTokenExtractor().extract(response.getBody());
    }

    private void addOAuthParams(OAuthRequest request, Token token) {
        request.addOAuthParameter(OAuthConstants.TIMESTAMP, api.getTimestampService().getTimestampInSeconds());
        request.addOAuthParameter(OAuthConstants.NONCE, api.getTimestampService().getNonce());
        request.addOAuthParameter(OAuthConstants.CONSUMER_KEY, config.getApiKey());
        request.addOAuthParameter(OAuthConstants.SIGN_METHOD, api.getSignatureService().getSignatureMethod());
        request.addOAuthParameter(OAuthConstants.VERSION, getVersion());
        if (config.hasScope()) {
            request.addOAuthParameter(OAuthConstants.SCOPE, config.getScope());
        }
        request.addOAuthParameter(OAuthConstants.SIGNATURE, getSignature(request, token));

        config.log("appended additional OAuth parameters: " + MapUtils.toString(request.getOauthParameters()));
    }

    private void appendSignature(OAuthRequest request) {
        switch (config.getSignatureType()) {
            case Header:
                config.log("using Http Header signature");

                String oauthHeader = api.getHeaderExtractor().extract(request);
                request.addHeader(OAuthConstants.HEADER, oauthHeader);
                break;
            case QueryString:
                config.log("using Querystring signature");

                for (Map.Entry<String, String> entry : request.getOauthParameters().entrySet()) {
                    request.addQuerystringParameter(entry.getKey(), entry.getValue());
                }
                break;
        }
    }

    private String getSignature(OAuthRequest request, Token token) {
        config.log("generating signature...");
        String baseString = api.getBaseStringExtractor().extract(request);
        String signature = api.getSignatureService().getSignature(baseString, config.getApiSecret(), token.getSecret());

        config.log("base string is: " + baseString);
        config.log("signature is: " + signature);
        return signature;
    }
}

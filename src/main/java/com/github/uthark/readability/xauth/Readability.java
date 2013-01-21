package com.github.uthark.readability.xauth;

import org.scribe.model.Response;
import org.scribe.model.SignatureType;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import java.io.IOException;

/**
 * @author <a href="mailto:oatamanenko@eastbanctech.com">Oleg Atamanenko</a>
 * @since 1/19/13
 */
public class Readability {

    private OAuthService service;

    private Token accessToken;

    public Readability(OAuthService service, Token accessToken) {
        this.service = service;

        this.accessToken = accessToken;
    }

    public static Readability getInstance(AuthorizationParams authorizationParams)
            throws IOException {


        OAuthService service = new XAuthServiceBuilder()
                .provider(ReadabilityApi.class)
                .apiKey(authorizationParams.getApiKey())
                .apiSecret(authorizationParams.getApiSecret())
                .signatureType(SignatureType.QueryString)
                .debug()
                .debugStream(System.err)
                .xauthParams(authorizationParams.getXAuthParams())
                .build();

        Token accessToken = service.getAccessToken(new Token("", ""), new Verifier(""));

        return new Readability(service, accessToken);
    }

    public Response executeRequest(OAuthRequest request) {
        service.signRequest(accessToken, request);
        return request.send();
    }
}

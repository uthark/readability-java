package com.github.uthark.readability.xauth;

/**
 * @author <a href="mailto:oatamanenko@eastbanctech.com">Oleg Atamanenko</a>
 * @since 1/19/13
 */
public class AuthorizationParams {

    private String apiKey;

    private String apiSecret;

    private XAuthParams xauth;

    public AuthorizationParams(String apiKey, String apiSecret, XAuthParams xauth) {
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.xauth = xauth;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getApiSecret() {
        return apiSecret;
    }

    public XAuthParams getXAuthParams() {
        return xauth;
    }
}

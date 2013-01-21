package com.github.uthark.readability.xauth;

import org.scribe.model.OAuthConfig;
import org.scribe.model.SignatureType;

import java.io.OutputStream;

/**
 * @author <a href="mailto:oatamanenko@eastbanctech.com">Oleg Atamanenko</a>
 * @since 1/20/13
 */
public class XAuthConfig extends OAuthConfig {

    private XAuthParams xAuthParams;

    public XAuthConfig(String key, String secret) {
        super(key, secret);
    }

    public XAuthConfig(String key, String secret, String callback, SignatureType type,
                       String scope, OutputStream stream) {
        super(key, secret, callback, type, scope, stream);
    }

    public XAuthConfig(String apiKey, String apiSecret, String callback, SignatureType signatureType, String scope,
                       OutputStream debugStream, XAuthParams xAuthParams) {
        super(apiKey, apiSecret, callback, signatureType, scope, debugStream);
        this.xAuthParams = xAuthParams;
    }

    public XAuthParams getXAuthParams() {
        return xAuthParams;
    }
}

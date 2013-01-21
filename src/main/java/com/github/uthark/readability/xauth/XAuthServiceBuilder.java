package com.github.uthark.readability.xauth;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.Api;
import org.scribe.exceptions.OAuthException;
import org.scribe.model.OAuthConstants;
import org.scribe.model.SignatureType;
import org.scribe.oauth.OAuthService;
import org.scribe.utils.Preconditions;

import java.io.OutputStream;

/**
 * @author <a href="mailto:oatamanenko@eastbanctech.com">Oleg Atamanenko</a>
 * @since 1/20/13
 */
public class XAuthServiceBuilder extends ServiceBuilder {

    private String apiKey;

    private String apiSecret;

    private String callback;

    private Api api;

    private String scope;

    private SignatureType signatureType;

    private OutputStream debugStream;

    private XAuthParams xAuthParams;

    /**
     * Default constructor
     */
    public XAuthServiceBuilder() {
        this.callback = OAuthConstants.OUT_OF_BAND;
        this.signatureType = SignatureType.Header;
        this.debugStream = null;
    }

    /**
     * Configures the {@link Api}
     *
     * @param apiClass the class of one of the existent {@link Api}s on org.scribe.api package
     * @return the {@link XAuthServiceBuilder} instance for method chaining
     */
    public XAuthServiceBuilder provider(Class<? extends Api> apiClass) {
        this.api = createApi(apiClass);
        return this;
    }

    private Api createApi(Class<? extends Api> apiClass) {
        Preconditions.checkNotNull(apiClass, "Api class cannot be null");
        Api api;
        try {
            api = apiClass.newInstance();
        } catch (Exception e) {
            throw new OAuthException("Error while creating the Api object", e);
        }
        return api;
    }

    /**
     * Configures the {@link Api}
     * <p/>
     * Overloaded version. Let's you use an instance instead of a class.
     *
     * @param api instance of {@link Api}s
     * @return the {@link XAuthServiceBuilder} instance for method chaining
     */
    public XAuthServiceBuilder provider(Api api) {
        Preconditions.checkNotNull(api, "Api cannot be null");
        this.api = api;
        return this;
    }

    /**
     * Adds an OAuth callback url
     *
     * @param callback callback url. Must be a valid url or 'oob' for out of band OAuth
     * @return the {@link XAuthServiceBuilder} instance for method chaining
     */
    public XAuthServiceBuilder callback(String callback) {
        Preconditions.checkNotNull(callback, "Callback can't be null");
        this.callback = callback;
        return this;
    }

    /**
     * Configures the api key
     *
     * @param apiKey The api key for your application
     * @return the {@link XAuthServiceBuilder} instance for method chaining
     */
    public XAuthServiceBuilder apiKey(String apiKey) {
        Preconditions.checkEmptyString(apiKey, "Invalid Api key");
        this.apiKey = apiKey;
        return this;
    }

    /**
     * Configures the api secret
     *
     * @param apiSecret The api secret for your application
     * @return the {@link XAuthServiceBuilder} instance for method chaining
     */
    public XAuthServiceBuilder apiSecret(String apiSecret) {
        Preconditions.checkEmptyString(apiSecret, "Invalid Api secret");
        this.apiSecret = apiSecret;
        return this;
    }

    /**
     * Configures the OAuth scope. This is only necessary in some APIs (like Google's).
     *
     * @param scope The OAuth scope
     * @return the {@link XAuthServiceBuilder} instance for method chaining
     */
    public XAuthServiceBuilder scope(String scope) {
        Preconditions.checkEmptyString(scope, "Invalid OAuth scope");
        this.scope = scope;
        return this;
    }

    /**
     * Configures the signature type, choose between header, querystring, etc. Defaults to Header
     *
     * @param scope The OAuth scope
     * @return the {@link XAuthServiceBuilder} instance for method chaining
     */
    public XAuthServiceBuilder signatureType(SignatureType type) {
        Preconditions.checkNotNull(type, "Signature type can't be null");
        this.signatureType = type;
        return this;
    }

    public XAuthServiceBuilder xauthParams(XAuthParams xAuthParams) {
        Preconditions.checkNotNull(xAuthParams, "XAuth params can't be null");
        this.xAuthParams = xAuthParams;
        return this;
    }

    public XAuthServiceBuilder debugStream(OutputStream stream) {
        Preconditions.checkNotNull(stream, "debug stream can't be null");
        this.debugStream = stream;
        return this;
    }

    public XAuthServiceBuilder debug() {
        this.debugStream(System.out);
        return this;
    }

    /**
     * Returns the fully configured {@link OAuthService}
     *
     * @return fully configured {@link OAuthService}
     */
    public OAuthService build() {
        Preconditions.checkNotNull(api, "You must specify a valid api through the provider() method");
        Preconditions.checkEmptyString(apiKey, "You must provide an api key");
        Preconditions.checkEmptyString(apiSecret, "You must provide an api secret");
        return api.createService(
                new XAuthConfig(apiKey, apiSecret, callback, signatureType, scope, debugStream, xAuthParams));
    }
}

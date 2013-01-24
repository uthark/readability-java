package com.github.uthark.readability.api.impl;

/**
 * Defines HTTP Codes returned by Readability api.
 *
 * @author Oleg Atamanenko
 * @see <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html">RFC 2616 Fielding</a>
 * @since 1/23/13
 */
public interface HttpCode {

    /**
     * The request has succeeded. The information returned with the response is dependent on the method used in the
     * request, for example:
     * <p/>
     * GET an entity corresponding to the requested resource is sent in the response;
     * <p/>
     * HEAD the entity-header fields corresponding to the requested resource are sent in the response without any
     * message-body;
     * <p/>
     * POST an entity describing or containing the result of the action;
     * <p/>
     * TRACE an entity containing the request message as received by the end server.
     */
    int OK = 200;
    /**
     * The request has been accepted for processing, but the processing has not been completed. The request might or
     * might not eventually be acted upon, as it might be disallowed when processing actually takes place. There is no
     * facility for re-sending a status code from an asynchronous operation such as this.
     * <p/>
     * The 202 response is intentionally non-committal. Its purpose is to allow a server to accept a request for some
     * other process (perhaps a batch-oriented process that is only run once per day) without requiring that the user
     * agent's connection to the server persist until the process is completed. The entity returned with this response
     * SHOULD include an indication of the request's current status and either a pointer to a status monitor or some
     * estimate of when the user can expect the request to be fulfilled.
     */
    int ACCEPTED = 202;
    /**
     * The server has fulfilled the request but does not need to return an entity-body, and might want to return updated
     * metainformation. The response MAY include new or updated metainformation in the form of entity-headers, which if
     * present SHOULD be associated with the requested variant.
     * <p/>
     * If the client is a user agent, it SHOULD NOT change its document view from that which caused the request to be
     * sent. This response is primarily intended to allow input for actions to take place without causing a change to
     * the user agent's active document view, although any new or updated metainformation SHOULD be applied to the
     * document currently in the user agent's active view.
     * <p/>
     * The 204 response MUST NOT include a message-body, and thus is always terminated by the first empty line after the
     * header fields.
     */
    int NO_CONTENT = 204;
    /**
     * The request could not be understood by the server due to malformed syntax. The client SHOULD NOT repeat the
     * request without modifications.
     */
    int BAD_REQUEST = 400;
    /**
     * The server has not found anything matching the Request-URI. No indication is given of whether the condition is
     * temporary or permanent. The 410 (Gone) status code SHOULD be used if the server knows, through some internally
     * configurable mechanism, that an old resource is permanently unavailable and has no forwarding address. This
     * status code is commonly used when the server does not wish to reveal exactly why the request has been refused, or
     * when no other response is applicable.
     */
    int NOT_FOUND = 404;
    /**
     * The request could not be completed due to a conflict with the current state of the resource. This code is only
     * allowed in situations where it is expected that the user might be able to resolve the conflict and resubmit the
     * request. The response body SHOULD include enough
     * <p/>
     * information for the user to recognize the source of the conflict. Ideally, the response entity would include
     * enough information for the user or user agent to fix the problem; however, that might not be possible and is not
     * required.
     * <p/>
     * Conflicts are most likely to occur in response to a PUT request. For example, if versioning were being used and
     * the entity being PUT included changes to a resource which conflict with those made by an earlier (third-party)
     * request, the server might use the 409 response to indicate that it can't complete the request. In this case, the
     * response entity would likely contain a list of the differences between the two versions in a format defined by
     * the response Content-Type.
     */
    int CONFLICT = 409;

}

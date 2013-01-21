package com.github.uthark.readability;

/**
 * @author <a href="mailto:oatamanenko@eastbanctech.com">Oleg Atamanenko</a>
 * @since 1/21/13
 */
public class ReadabilityException extends RuntimeException {

    private final int code;

    private final String response;

    public ReadabilityException(int code, String body) {
        this.code = code;
        this.response = body;
    }

    public String getResponse() {
        return response;
    }

    public int getCode() {
        return code;
    }
}

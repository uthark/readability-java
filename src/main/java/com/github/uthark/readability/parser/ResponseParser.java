package com.github.uthark.readability.parser;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Reader;

/**
 * @author <a href="mailto:oatamanenko@eastbanctech.com">Oleg Atamanenko</a>
 * @since 1/20/13
 */
public class ResponseParser {

    private ObjectMapper mapper;

    public ResponseParser() {
        mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
    }

    public <T> T parse(Reader reader, Class<T> responseClass) throws IOException {
        return mapper.readValue(reader, responseClass);
    }

}

package com.github.uthark.readability.parser;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Reader;

/**
 * @author <a href="mailto:oatamanenko@eastbanctech.com">Oleg Atamanenko</a>
 * @since 1/20/13
 */
public class ResponseParser {

    public <T> T parse(Reader reader, Class<T> responseClass) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(reader, responseClass);
    }
}

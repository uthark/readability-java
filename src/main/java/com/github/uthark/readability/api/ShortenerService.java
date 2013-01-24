package com.github.uthark.readability.api;

import com.github.uthark.readability.model.ShortenerResponse;

import java.io.IOException;

/**
 * @author Oleg Atamanenko
 * @since 1/24/13
 */
public interface ShortenerService {

    ShortenerResponse shorten(String url) throws IOException;

    ShortenerResponse getDetails(String articleId) throws IOException;
}

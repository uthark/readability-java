package com.github.uthark.readability.api.impl;

import com.github.uthark.readability.api.ArticleService;
import com.github.uthark.readability.model.Article;
import com.github.uthark.readability.parser.ResponseParser;
import com.github.uthark.readability.xauth.OAuthRequest;
import com.github.uthark.readability.xauth.Readability;
import org.scribe.model.Response;
import org.scribe.model.Verb;

import java.io.IOException;
import java.io.StringReader;

/**
 * @author Oleg Atamanenko
 * @since 1/23/13
 */
public class ArticleServiceImpl implements ArticleService {

    private final Readability readability;

    private static final String ARTICLE_URL = "https://www.readability.com/api/rest/v1/articles/";

    private ResponseParser responseParser = new ResponseParser();

    public ArticleServiceImpl(Readability readability) {
        this.readability = readability;
    }

    @Override
    public Article getArticle(String articleId) throws IOException {
        OAuthRequest request = new OAuthRequest(Verb.GET, buildUrl(articleId));
        Response response = readability.executeRequest(request);
        String responseBody = response.getBody();

        StringReader reader = new StringReader(responseBody);
        return responseParser.parse(reader, Article.class);
    }

    private String buildUrl(String articleId) {
        return ARTICLE_URL + articleId;
    }
}

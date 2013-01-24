package com.github.uthark.readability.api;

import com.github.uthark.readability.model.Article;

import java.io.IOException;

/**
 * @author Oleg Atamanenko
 * @since 1/23/13
 */
public interface ArticleService {

    Article getArticle(String articleId) throws IOException;
}

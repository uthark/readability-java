package com.github.uthark.readability.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Oleg Atamanenko
 * @since 1/24/13
 */
public class ShortenerMeta {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShortenerMeta.class);

    @JsonProperty("id")
    private String id;

    @JsonProperty("url")
    private String url;

    @JsonProperty("rdd_url")
    private String rddUrl;

    @JsonProperty("full_url")
    private String fullUrl;

    @JsonProperty("article")
    private Article article;

    @JsonAnySetter()
    public void setUnknownProperty(String key, Object value) {
        LOGGER.warn("Setting unknown {}={}", key, value);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRddUrl() {
        return rddUrl;
    }

    public void setRddUrl(String rddUrl) {
        this.rddUrl = rddUrl;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
